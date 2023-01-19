package org.herbal.chem.organism.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.organism.Organism;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.organism.Reference;
import org.herbal.chem.organism.entity.OrganismEntity;
import org.herbal.chem.organism.entity.ReferenceEntity;
import org.herbal.chem.organism.mapper.OrganismMapper;
import org.herbal.chem.organism.mapper.ReferenceMapper;
import org.herbal.chem.organism.service.ReferenceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class OrganismController {
    private final ReferenceService referenceService;

    private final ReferenceMapper referenceMapper;
    private final OrganismMapper organismMapper;

    @GetMapping(path = "/organisms/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrganismServiceDto> organism(@PathVariable(name = "cid") Integer cid) {
        ReferenceEntity referenceEntity = referenceService.getReferenceByCid(cid).get();
        Reference reference = referenceMapper.entityToDto(referenceEntity);

        OrganismEntity organismEntity = referenceEntity.getOrganism();
        Organism organism = organismMapper.entityToDto(organismEntity);

        reference.setOrganismId(organismEntity.getId());
        OrganismServiceDto organismServiceDto = new OrganismServiceDto(reference, organism);

        return ResponseEntity.ok(organismServiceDto);
    }
}
