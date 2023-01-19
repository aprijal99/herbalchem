package org.herbal.chem.organism.repository;

import org.herbal.chem.organism.entity.OrganismEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganismRepository extends JpaRepository<OrganismEntity, Integer> {
}
