package org.herbal.chem.organism.consumer;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.organism.Organism;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.organism.Reference;
import org.herbal.chem.organism.entity.OrganismEntity;
import org.herbal.chem.organism.entity.ReferenceEntity;
import org.herbal.chem.organism.mapper.OrganismMapper;
import org.herbal.chem.organism.mapper.ReferenceMapper;
import org.herbal.chem.organism.service.OrganismService;
import org.herbal.chem.organism.service.ReferenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ConsumerConfiguration {
    private final ReferenceService referenceService;
    private final OrganismService organismService;

    private final ReferenceMapper referenceMapper;
    private final OrganismMapper organismMapper;

    @Bean
    public Consumer<byte[]> organismServiceDtoConsumer() {
        return value -> {
            OrganismServiceDto organismServiceDto = (OrganismServiceDto) SerializationUtils.deserialize(value);

            Reference reference = organismServiceDto.getReference();
            ReferenceEntity referenceEntity = referenceMapper.dtoToEntity(reference);

            if (reference.getOrganismId() == null) {
                Organism organism = organismServiceDto.getOrganism();
                OrganismEntity organismEntity = organismMapper.dtoToEntity(organism);

                organismEntity.setReferenceEntities(new ArrayList<>());
                OrganismEntity savedOrganismEntity = organismService.saveOrganism(organismEntity);

                referenceEntity.setOrganism(savedOrganismEntity);
            } else {
                OrganismEntity organism = organismService.getOrganismById(reference.getOrganismId());

                referenceEntity.setOrganism(organism);
            }

            referenceService.saveReference(referenceEntity);
        };
    }
}
