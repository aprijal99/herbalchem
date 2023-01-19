package org.herbal.chem.organism.service;

import org.herbal.chem.organism.entity.ReferenceEntity;

import java.util.Optional;

public interface ReferenceService {
    void saveReference(ReferenceEntity referenceEntity);
    Optional<ReferenceEntity> getReferenceByCid(Integer cid);
}
