package org.herbal.chem.compound.detail.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.compound.detail.dto.CompoundDetail;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.detail.service.CompoundDetailService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/compound-detail")
public class CompoundDetailController {
    private final CompoundDetailService compoundDetailService;

    @GetMapping(path = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompoundDetail> compoundDetail(@PathVariable(name = "cid") Integer cid) {
        CompoundServiceDto compound = compoundDetailService.getCompoundFromCompoundService(cid);
        StructureServiceDto structure = compoundDetailService.getStructureFromStructureService(cid);
        NameIdentifierServiceDto nameIdentifier = compoundDetailService.getNameIdentifierFromNameIdentifierService(cid);
        ChemicalPhysicalPropertyServiceDto chemicalPhysicalProperty = compoundDetailService.getChemicalPhysicalPropertyFromChemicalPhysicalPropertyService(cid);
        OrganismServiceDto organism = compoundDetailService.getOrganismFromOrganismService(cid);

        CompoundDetail compoundDetail = CompoundDetail.builder()
                .compoundServiceDto(compound)
                .structureServiceDto(structure)
                .nameIdentifierServiceDto(nameIdentifier)
                .chemicalPhysicalPropertyServiceDto(chemicalPhysicalProperty)
                .organismServiceDto(organism)
                .build();

        compoundDetail
                .add(linkTo(methodOn(CompoundDetailController.class).compoundDetail(cid)).withSelfRel());

        return ResponseEntity.ok(compoundDetail);
    }
}
