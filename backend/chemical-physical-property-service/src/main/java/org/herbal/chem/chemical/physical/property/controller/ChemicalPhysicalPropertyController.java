package org.herbal.chem.chemical.physical.property.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ComputedProperty;
import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;
import org.herbal.chem.chemical.physical.property.mapper.ComputedPropertyMapper;
import org.herbal.chem.chemical.physical.property.service.ComputedPropertyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class ChemicalPhysicalPropertyController {
    private final ComputedPropertyService computedPropertyService;

    private final ComputedPropertyMapper computedPropertyMapper;

    @GetMapping(path = "/chemical-physical-properties/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChemicalPhysicalPropertyServiceDto>  chemicalPhysicalProperty(@PathVariable(name = "cid") Integer cid) {
        ComputedPropertyEntity computedPropertyEntity = computedPropertyService.getComputedPropertyByCid(cid).get();
        ComputedProperty computedProperty = computedPropertyMapper.entityToDto(computedPropertyEntity);

        ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto = new ChemicalPhysicalPropertyServiceDto(computedProperty);

        return ResponseEntity.ok(chemicalPhysicalPropertyServiceDto);
    }
}
