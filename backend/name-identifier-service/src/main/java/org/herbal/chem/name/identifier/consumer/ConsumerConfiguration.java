package org.herbal.chem.name.identifier.consumer;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ConsumerConfiguration {
    private final ComputedDescriptorService computedDescriptorService;
    private final MolecularFormulaService molecularFormulaService;
    private final SynonymService synonymService;

    private final ComputedDescriptorMapper computedDescriptorMapper;
    private final MolecularFormulaMapper molecularFormulaMapper;
    private final SynonymMapper synonymMapper;

    @Bean
    public Consumer<byte[]> nameIdentifierServiceDtoConsumer() {
        return value -> {
            NameIdentifierServiceDto nameIdentifierServiceDto = (NameIdentifierServiceDto) SerializationUtils.deserialize(value);

            ComputedDescriptor computedDescriptor = nameIdentifierServiceDto.getComputedDescriptor();
            ComputedDescriptorEntity computedDescriptorEntity = computedDescriptorMapper.dtoToEntity(computedDescriptor);

            MolecularFormula molecularFormula = nameIdentifierServiceDto.getMolecularFormula();
            MolecularFormulaEntity molecularFormulaEntity = molecularFormulaMapper.dtoToEntity(molecularFormula);

            Synonym synonym = nameIdentifierServiceDto.getSynonym();
            SynonymEntity synonymEntity = synonymMapper.dtoToEntity(synonym);

            computedDescriptorService.saveComputedDescriptor(computedDescriptorEntity);
            molecularFormulaService.saveMolecularFormula(molecularFormulaEntity);
            synonymService.saveSynonym(synonymEntity);
        };
    }
}
