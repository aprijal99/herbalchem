package org.herbal.chem.compound.mapper;

import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.entity.CompoundEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CompoundMapper {
    CompoundEntity dtoToEntity(CompoundServiceDto compoundServiceDto);
    CompoundServiceDto entityToDto(CompoundEntity compoundEntity);
}
