package org.herbal.chem.compound.form.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.detail.controller.CompoundDetailController;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
import org.herbal.chem.compound.form.dto.CompoundRequest;
import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;
import org.herbal.chem.compound.form.service.CompoundFormService;
import org.herbal.chem.compound.form.service.CompoundFormServiceImpl;
import org.herbal.chem.compound.form.service.CompoundSummaryService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/compound-form")
public class CompoundFormController {
    private final CompoundFormService compoundFormService;
    private final CompoundSummaryService compoundSummaryService;

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

        // Send CompoundSummary to Elasticsearch
        CompoundSummaryEntity compoundSummary = CompoundSummaryEntity.builder()
                .herbalChemCid(herbalChemCid)
                .compoundName(compoundServiceDto.getCompoundName())
                .synonym(compoundDetailRequest.getNameIdentifierServiceDto().getSynonym().getSynonym())
                .molecularFormula(compoundDetailRequest.getNameIdentifierServiceDto().getMolecularFormula().getMolecularFormula())
                .molecularWeight(compoundDetailRequest.getChemicalPhysicalPropertyServiceDto().getComputedProperty().getMolecularWeight())
                .iupacName(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getIupacName())
                .canonicalSmiles(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getCanonicalSmiles())
                .inchlKey(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getInchlKey())
                .inchl(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getInchl())
                .createdAt(compoundServiceDto.getCreatedAt())
                .structure2DUrl(compoundDetailRequest.getStructureServiceDto().getStructure2DUrl())
                .build();

        compoundSummaryService.sendCompoundSummaryToElasticsearch(compoundSummary);

        return ResponseEntity
                .created(linkTo(methodOn(CompoundDetailController.class).compoundDetail(herbalChemCid)).toUri())
                .body(newCompoundResponse);
    }
}
