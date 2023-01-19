package org.herbal.chem.name.identifier.mapper;

import org.herbal.chem.api.dto.name.identifier.MolecularFormula;
import org.herbal.chem.name.identifier.entity.MolecularFormulaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface MolecularFormulaMapper {
    MolecularFormulaEntity dtoToEntity(MolecularFormula molecularFormula);
    MolecularFormula entityToDto(MolecularFormulaEntity molecularFormulaEntity);
}
