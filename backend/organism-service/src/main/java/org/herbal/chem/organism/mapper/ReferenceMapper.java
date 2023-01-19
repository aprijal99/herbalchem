package org.herbal.chem.organism.mapper;

import org.herbal.chem.api.dto.organism.Reference;
import org.herbal.chem.organism.entity.ReferenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ReferenceMapper {
    ReferenceEntity dtoToEntity(Reference reference);
    Reference entityToDto(ReferenceEntity referenceEntity);
}
