package org.herbal.chem.name.identifier.mapper;

import org.herbal.chem.api.dto.name.identifier.Synonym;
import org.herbal.chem.name.identifier.entity.SynonymEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SynonymMapper {
    SynonymEntity dtoToEntity(Synonym synonym);
    Synonym entityToDto(SynonymEntity synonymEntity);
}
