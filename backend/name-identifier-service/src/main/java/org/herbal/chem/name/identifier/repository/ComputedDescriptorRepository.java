package org.herbal.chem.name.identifier.repository;

import org.herbal.chem.name.identifier.entity.ComputedDescriptorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComputedDescriptorRepository extends JpaRepository<ComputedDescriptorEntity, Integer> {
    Optional<ComputedDescriptorEntity> findByHerbalChemCid(Integer cid);
}
