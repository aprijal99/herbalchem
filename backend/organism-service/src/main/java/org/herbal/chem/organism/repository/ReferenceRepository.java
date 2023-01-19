package org.herbal.chem.organism.repository;

import org.herbal.chem.organism.entity.ReferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferenceRepository extends JpaRepository<ReferenceEntity, Integer> {
    Optional<ReferenceEntity> findByHerbalChemCid(Integer cid);
}
