package org.herbal.chem.name.identifier.mapper;

import org.herbal.chem.api.dto.name.identifier.ComputedDescriptor;
import org.herbal.chem.name.identifier.entity.ComputedDescriptorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ComputedDescriptorMapper {
    ComputedDescriptorEntity dtoToEntity(ComputedDescriptor computedDescriptor);
    ComputedDescriptor entityToDto(ComputedDescriptorEntity computedDescriptorEntity);
}
