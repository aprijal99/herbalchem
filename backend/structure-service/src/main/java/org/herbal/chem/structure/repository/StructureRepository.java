package org.herbal.chem.structure.repository;

import org.herbal.chem.structure.entity.StructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StructureRepository extends JpaRepository<StructureEntity, Integer> {
    Optional<StructureEntity> findByHerbalChemCid(Integer cid);
}
