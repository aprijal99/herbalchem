package org.herbal.chem.structure.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.structure.entity.StructureEntity;
import org.herbal.chem.structure.repository.StructureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StructureServiceImpl implements StructureService {
    private final StructureRepository structureRepository;

    @Override
    public void saveStructure(StructureEntity structureEntity) {
        structureRepository.save(structureEntity);
    }

    @Override
    public Optional<StructureEntity> getStructureByCid(Integer cid) {
        return structureRepository.findByHerbalChemCid(cid);
    }
}
