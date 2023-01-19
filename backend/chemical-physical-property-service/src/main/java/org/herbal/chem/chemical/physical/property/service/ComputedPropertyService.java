package org.herbal.chem.chemical.physical.property.service;

import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;

import java.util.Optional;

public interface ComputedPropertyService {
    void saveComputedProperty(ComputedPropertyEntity computedPropertyEntity);
    Optional<ComputedPropertyEntity> getComputedPropertyByCid(Integer cid);
}
