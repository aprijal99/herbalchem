package org.herbal.chem.compound.form.processor;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class CompoundFormServiceProcessor {
    @Bean
    public Function<KStream<String, byte[]>, KStream<String, byte[]>[]> compoundDetailRequestProcessor() {
        Predicate<String, byte[]> isNameIdentifierServiceDto = (key, value) -> SerializationUtils.deserialize(value)
                .getClass().getName().equals(NameIdentifierServiceDto.class.getName());

        Predicate<String, byte[]> isChemicalPhysicalPropertyServiceDto = (key, value) -> SerializationUtils.deserialize(value)
                .getClass().getName().equals(ChemicalPhysicalPropertyServiceDto.class.getName());

        Predicate<String, byte[]> isOrganismServiceDto = (key, value) -> SerializationUtils.deserialize(value)
                .getClass().getName().equals(OrganismServiceDto.class.getName());

        Predicate<String, byte[]> isStructureServiceDto = (key, value) -> SerializationUtils.deserialize(value)
                .getClass().getName().equals(StructureServiceDto.class.getName());

        return input -> {
            Map<String, KStream<String, byte[]>> kStreamMap = input
                    .map((key, value) -> new KeyValue<>(key, (CompoundDetailRequest) SerializationUtils.deserialize(value)))
                    .flatMapValues(value -> List.of(
                            SerializationUtils.serialize(value.getNameIdentifierServiceDto()),
                            SerializationUtils.serialize(value.getChemicalPhysicalPropertyServiceDto()),
                            SerializationUtils.serialize(value.getOrganismServiceDto()),
                            SerializationUtils.serialize(value.getStructureServiceDto())
                    ))
                    .map(KeyValue::new)
                    .split()
                    .branch(isNameIdentifierServiceDto)
                    .branch(isChemicalPhysicalPropertyServiceDto)
                    .branch(isOrganismServiceDto)
                    .branch(isStructureServiceDto)
                    .noDefaultBranch();

            return kStreamMap.values().toArray(new KStream[0]);
        };
    }
}
