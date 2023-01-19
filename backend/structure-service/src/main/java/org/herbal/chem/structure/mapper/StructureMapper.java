package org.herbal.chem.structure.mapper;

import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.herbal.chem.structure.entity.StructureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface StructureMapper {
    StructureEntity dtoToEntity(StructureServiceDto structureServiceDto);
    StructureServiceDto entityToDto(StructureEntity structureEntity);
}
