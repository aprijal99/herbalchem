package org.herbal.chem.name.identifier.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.name.identifier.entity.SynonymEntity;
import org.herbal.chem.name.identifier.repository.SynonymRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SynonymServiceImpl implements SynonymService {
    private final SynonymRepository synonymRepository;

    @Override
    public void saveSynonym(SynonymEntity synonymEntity) {
        synonymRepository.save(synonymEntity);
    }

    @Override
    public Optional<SynonymEntity> getSynonymByCid(Integer cid) {
        return synonymRepository.findByHerbalChemCid(cid);
    }
}
