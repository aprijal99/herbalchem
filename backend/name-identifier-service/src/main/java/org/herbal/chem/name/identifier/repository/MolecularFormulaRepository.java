package org.herbal.chem.name.identifier.repository;

import org.herbal.chem.name.identifier.entity.MolecularFormulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MolecularFormulaRepository extends JpaRepository<MolecularFormulaEntity, Integer> {
    Optional<MolecularFormulaEntity> findByHerbalChemCid(Integer cid);
}
