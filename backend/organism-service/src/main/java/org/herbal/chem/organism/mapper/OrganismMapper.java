package org.herbal.chem.organism.mapper;

import org.herbal.chem.api.dto.organism.Organism;
import org.herbal.chem.organism.entity.OrganismEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface OrganismMapper {
    OrganismEntity dtoToEntity(Organism organism);
    Organism entityToDto(OrganismEntity organismEntity);
}
