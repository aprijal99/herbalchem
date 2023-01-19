package org.herbal.chem.structure.service;

import org.herbal.chem.structure.entity.StructureEntity;

import java.util.Optional;

public interface StructureService {
    void saveStructure(StructureEntity structureEntity);
    Optional<StructureEntity> getStructureByCid(Integer cid);
}
