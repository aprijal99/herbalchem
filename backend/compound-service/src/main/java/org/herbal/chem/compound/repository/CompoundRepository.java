package org.herbal.chem.compound.repository;

import org.herbal.chem.compound.entity.CompoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompoundRepository extends JpaRepository<CompoundEntity, Integer> {
    Optional<CompoundEntity> findByHerbalChemCid(Integer cid);
}
