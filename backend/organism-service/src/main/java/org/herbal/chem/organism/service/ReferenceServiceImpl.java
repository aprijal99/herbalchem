package org.herbal.chem.organism.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.organism.entity.ReferenceEntity;
import org.herbal.chem.organism.repository.ReferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {
    private final ReferenceRepository referenceRepository;

    @Override
    public void saveReference(ReferenceEntity referenceEntity) {
        referenceRepository.save(referenceEntity);
    }

    @Override
    public Optional<ReferenceEntity> getReferenceByCid(Integer cid) {
        return referenceRepository.findByHerbalChemCid(cid);
    }
}
