package org.herbal.chem.organism.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.organism.entity.OrganismEntity;
import org.herbal.chem.organism.repository.OrganismRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrganismServiceImpl implements OrganismService {
    private final OrganismRepository organismRepository;

    @Override
    public OrganismEntity saveOrganism(OrganismEntity organismEntity) {
        return organismRepository.save(organismEntity);
    }

    @Override
    public OrganismEntity getOrganismById(Integer id) {
        return organismRepository.findById(id).get();
    }
}
