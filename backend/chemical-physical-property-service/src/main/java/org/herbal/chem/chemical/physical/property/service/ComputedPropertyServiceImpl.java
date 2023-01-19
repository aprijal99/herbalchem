package org.herbal.chem.chemical.physical.property.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.chemical.physical.property.entity.ComputedPropertyEntity;
import org.herbal.chem.chemical.physical.property.repository.ComputedPropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ComputedPropertyServiceImpl implements ComputedPropertyService {
    private ComputedPropertyRepository computedPropertyRepository;

    @Override
    public void saveComputedProperty(ComputedPropertyEntity computedPropertyEntity) {
        computedPropertyRepository.save(computedPropertyEntity);
    }

    @Override
    public Optional<ComputedPropertyEntity> getComputedPropertyByCid(Integer cid) {
        return computedPropertyRepository.findByHerbalChemCid(cid);
    }
}
