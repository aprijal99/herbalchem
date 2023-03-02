package org.herbal.chem.compound.form.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.detail.controller.CompoundDetailController;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
import org.herbal.chem.compound.form.dto.CompoundRequest;
import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;
import org.herbal.chem.compound.form.service.CompoundFormService;
import org.herbal.chem.compound.form.service.CompoundSummaryService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/compound-form")
public class CompoundFormController {
    private final CompoundFormService compoundFormService;
    private final CompoundSummaryService compoundSummaryService;

    @PostMapping(path = "/new-compound", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newCompound(@RequestBody CompoundRequest compoundRequest) {
        // Extract CompoundServiceDto and CompoundDetailRequest
        CompoundServiceDto compoundServiceDto = compoundRequest.getCompoundServiceDto();
        CompoundDetailRequest compoundDetailRequest = compoundRequest.getCompoundDetailRequest();

        // Send CompoundServiceDto to kafka and get herbalChemCid
        byte[] serializedCompoundServiceDto = SerializationUtils.serialize(compoundServiceDto);
        Integer herbalChemCid = compoundFormService.sendCompoundServiceDtoToKafka(serializedCompoundServiceDto);

        // Send CompoundDetailRequest to kafka asynchronously
        compoundDetailRequest.setHerbalChemCid(herbalChemCid);
        byte[] serializedCompoundDetailRequest = SerializationUtils.serialize(compoundDetailRequest);
        compoundFormService.sendCompoundDetailRequestToKafka(serializedCompoundDetailRequest);

        // Send CompoundSummary to elasticsearch
        CompoundSummaryEntity compoundSummary = compoundSummaryService.crateCompoundSummaryEntity(herbalChemCid, compoundServiceDto, compoundDetailRequest);
        compoundSummaryService.sendCompoundSummaryToElasticsearch(compoundSummary);

        // Create EntityModel for the response
        EntityModel<Map<String, Integer>> newCompoundResponse = EntityModel.of(Map.of("HerbalChem CID", herbalChemCid),
                linkTo(methodOn(CompoundDetailController.class).compoundDetail(herbalChemCid)).withSelfRel());

        return ResponseEntity
                .created(linkTo(methodOn(CompoundDetailController.class).compoundDetail(herbalChemCid)).toUri())
                .body(newCompoundResponse);
    }
}
