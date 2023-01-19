package org.herbal.chem.name.identifier.service;

import org.herbal.chem.name.identifier.entity.ComputedDescriptorEntity;

import java.util.Optional;

public interface ComputedDescriptorService {
    void saveComputedDescriptor(ComputedDescriptorEntity computedDescriptorEntity);
    Optional<ComputedDescriptorEntity> getComputedDescriptorByCid(Integer cid);
}
