package org.herbal.chem.structure.consumer;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.structure.entity.StructureEntity;
import org.herbal.chem.structure.mapper.StructureMapper;
import org.herbal.chem.structure.service.StructureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ConsumerConfiguration {
    private final StructureService structureService;

    private final StructureMapper structureMapper;

    @Bean
    public Consumer<byte[]> structureServiceDtoConsumer() {
        return value -> {
            StructureServiceDto structureServiceDto = (StructureServiceDto) SerializationUtils.deserialize(value);
            StructureEntity structureEntity = structureMapper.dtoToEntity(structureServiceDto);

            structureService.saveStructure(structureEntity);
        };
    }
}
