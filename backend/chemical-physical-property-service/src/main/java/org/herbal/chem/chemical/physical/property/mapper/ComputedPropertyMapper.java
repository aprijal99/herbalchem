package org.herbal.chem.chemical.physical.property.mapper;

import org.herbal.chem.api.dto.chemical.physical.property.ComputedProperty;
import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ComputedPropertyMapper {
    ComputedPropertyEntity dtoToEntity(ComputedProperty computedProperty);
    ComputedProperty entityToDto(ComputedPropertyEntity computedPropertyEntity);
}
