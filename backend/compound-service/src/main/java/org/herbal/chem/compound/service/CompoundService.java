package org.herbal.chem.compound.service;

import org.herbal.chem.compound.entity.CompoundEntity;

import java.util.List;
import java.util.Optional;

public interface CompoundService {
    CompoundEntity saveCompound(CompoundEntity compoundEntity);
    Optional<CompoundEntity> getCompoundByCid(Integer cid);
    List<CompoundEntity> getAllCompounds();
}
