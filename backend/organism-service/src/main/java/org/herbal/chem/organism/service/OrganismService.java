package org.herbal.chem.organism.service;

import org.herbal.chem.organism.entity.OrganismEntity;

public interface OrganismService {
    OrganismEntity saveOrganism(OrganismEntity organismEntity);
    OrganismEntity getOrganismById(Integer id);
}
