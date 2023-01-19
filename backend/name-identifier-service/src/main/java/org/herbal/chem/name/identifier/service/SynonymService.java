package org.herbal.chem.name.identifier.service;

import org.herbal.chem.name.identifier.entity.SynonymEntity;

import java.util.Optional;

public interface SynonymService {
    void saveSynonym(SynonymEntity synonymEntity);
    Optional<SynonymEntity> getSynonymByCid(Integer cid);
}
