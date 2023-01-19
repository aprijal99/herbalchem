package org.herbal.chem.name.identifier.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.name.identifier.ComputedDescriptor;
import org.herbal.chem.api.dto.name.identifier.MolecularFormula;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.name.identifier.Synonym;
import org.herbal.chem.name.identifier.entity.ComputedDescriptorEntity;
import org.herbal.chem.name.identifier.entity.MolecularFormulaEntity;
import org.herbal.chem.name.identifier.entity.SynonymEntity;
import org.herbal.chem.name.identifier.mapper.ComputedDescriptorMapper;
import org.herbal.chem.name.identifier.mapper.MolecularFormulaMapper;
import org.herbal.chem.name.identifier.mapper.SynonymMapper;
import org.herbal.chem.name.identifier.service.ComputedDescriptorService;
import org.herbal.chem.name.identifier.service.MolecularFormulaService;
import org.herbal.chem.name.identifier.service.SynonymService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class NameIdentifierController {
    private final ComputedDescriptorService computedDescriptorService;
    private final MolecularFormulaService molecularFormulaService;
    private final SynonymService synonymService;

    private final ComputedDescriptorMapper computedDescriptorMapper;
    private final MolecularFormulaMapper molecularFormulaMapper;
    private final SynonymMapper synonymMapper;

    @GetMapping(path = "/names-identifiers/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NameIdentifierServiceDto> nameIdentifier(@PathVariable(name = "cid") Integer cid) {
        ComputedDescriptorEntity computedDescriptorEntity = computedDescriptorService.getComputedDescriptorByCid(cid).get();
        ComputedDescriptor computedDescriptor = computedDescriptorMapper.entityToDto(computedDescriptorEntity);

        MolecularFormulaEntity molecularFormulaEntity = molecularFormulaService.getMolecularFormulaByCid(cid).get();
        MolecularFormula molecularFormula = molecularFormulaMapper.entityToDto(molecularFormulaEntity);

        SynonymEntity synonymEntity = synonymService.getSynonymByCid(cid).get();
        Synonym synonym = synonymMapper.entityToDto(synonymEntity);

        NameIdentifierServiceDto nameIdentifierServiceDto = new NameIdentifierServiceDto(computedDescriptor, molecularFormula, synonym);

        return ResponseEntity.ok(nameIdentifierServiceDto);
    }
}
