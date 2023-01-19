package org.herbal.chem.chemical.physical.property.repository;

import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComputedPropertyRepository extends JpaRepository<ComputedPropertyEntity, Integer> {
    Optional<ComputedPropertyEntity> findByHerbalChemCid(Integer cid);
}
