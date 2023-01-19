package org.herbal.chem.name.identifier.repository;

import org.herbal.chem.name.identifier.entity.SynonymEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SynonymRepository extends JpaRepository<SynonymEntity, Integer> {
    Optional<SynonymEntity> findByHerbalChemCid(Integer cid);
}
