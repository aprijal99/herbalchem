package org.herbal.chem.compound.form.controller;

import lombok.extern.slf4j.Slf4j;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.detail.controller.CompoundDetailController;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
import org.herbal.chem.compound.form.dto.CompoundRequest;
import org.herbal.chem.compound.form.service.CompoundFormServiceImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Slf4j
@RestController
@RequestMapping(path = "/compound-form")
public class CompoundFormController {
    private final CompoundFormServiceImpl compoundFormService;

    public CompoundFormController(CompoundFormServiceImpl compoundFormService) {
        this.compoundFormService = compoundFormService;
    }

    @PostMapping(path = "/new-compound", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newCompound(@RequestBody CompoundRequest compoundRequest) {
        CompoundServiceDto compoundServiceDto = compoundRequest.getCompoundServiceDto();
        byte[] serializedCompoundServiceDto = SerializationUtils.serialize(compoundServiceDto);

        CompoundDetailRequest compoundDetailRequest = compoundRequest.getCompoundDetailRequest();

        log.info("Send {} to kafka then compound service", compoundServiceDto);
        Integer herbalChemCid = compoundFormService.sendCompoundServiceDtoToKafka(serializedCompoundServiceDto);

        if (herbalChemCid != null) {
            compoundDetailRequest.setHerbalChemCid(herbalChemCid);
            byte[] serializedCompoundDetailRequest = SerializationUtils.serialize(compoundDetailRequest);

            compoundFormService.sendCompoundDetailRequestToKafka(serializedCompoundDetailRequest);
        }

        EntityModel<Map<String, Integer>> newCompoundResponse = EntityModel.of(Map.of("HerbalChem CID", herbalChemCid),
                linkTo(methodOn(CompoundDetailController.class).compoundDetail(herbalChemCid)).withSelfRel());

        return ResponseEntity
                .created(linkTo(methodOn(CompoundDetailController.class).compoundDetail(herbalChemCid)).toUri())
                .body(newCompoundResponse);
    }
}
