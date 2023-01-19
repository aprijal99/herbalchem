package org.herbal.chem.name.identifier.service;

import org.herbal.chem.name.identifier.entity.MolecularFormulaEntity;

import java.util.Optional;

public interface MolecularFormulaService {
    void saveMolecularFormula(MolecularFormulaEntity molecularFormulaEntity);
    Optional<MolecularFormulaEntity> getMolecularFormulaByCid(Integer cid);
}
