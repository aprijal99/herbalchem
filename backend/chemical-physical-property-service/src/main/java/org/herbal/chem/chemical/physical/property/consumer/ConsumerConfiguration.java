package org.herbal.chem.chemical.physical.property.consumer;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ComputedProperty;
import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;
import org.herbal.chem.chemical.physical.property.mapper.ComputedPropertyMapper;
import org.herbal.chem.chemical.physical.property.service.ComputedPropertyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ConsumerConfiguration {
    private ComputedPropertyService computedPropertyService;

    private ComputedPropertyMapper computedPropertyMapper;

    @Bean
    public Consumer<byte[]> chemicalPhysicalPropertyConsumer() {
        return value -> {
            ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto = (ChemicalPhysicalPropertyServiceDto) SerializationUtils.deserialize(value);

            ComputedProperty computedProperty = chemicalPhysicalPropertyServiceDto.getComputedProperty();
            ComputedPropertyEntity computedPropertyEntity = computedPropertyMapper.dtoToEntity(computedProperty);

            computedPropertyService.saveComputedProperty(computedPropertyEntity);
        };
    }
}
