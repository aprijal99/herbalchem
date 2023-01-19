package org.herbal.chem.name.identifier.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.name.identifier.entity.ComputedDescriptorEntity;
import org.herbal.chem.name.identifier.repository.ComputedDescriptorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ComputedDescriptorServiceImpl implements ComputedDescriptorService {
    private final ComputedDescriptorRepository computedDescriptorRepository;

    @Override
    public void saveComputedDescriptor(ComputedDescriptorEntity computedDescriptorEntity) {
        computedDescriptorRepository.save(computedDescriptorEntity);
    }

    @Override
    public Optional<ComputedDescriptorEntity> getComputedDescriptorByCid(Integer cid) {
        return computedDescriptorRepository.findByHerbalChemCid(cid);
    }
}
