package org.herbal.chem.structure.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.structure.entity.StructureEntity;
import org.herbal.chem.structure.mapper.StructureMapper;
import org.herbal.chem.structure.service.StructureService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class StructureController {
    private final StructureService structureService;
    private final StructureMapper structureMapper;

    @GetMapping(path = "/structures/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StructureServiceDto> structure(@PathVariable(name = "cid") Integer cid) {
        StructureEntity structureEntity = structureService.getStructureByCid(cid).get();
        StructureServiceDto structureServiceDto = structureMapper.entityToDto(structureEntity);

        return ResponseEntity.ok(structureServiceDto);
    }
}
