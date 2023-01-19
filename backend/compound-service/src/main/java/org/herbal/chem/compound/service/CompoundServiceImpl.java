package org.herbal.chem.compound.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.compound.entity.CompoundEntity;
import org.herbal.chem.compound.repository.CompoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CompoundServiceImpl implements CompoundService {
    private final CompoundRepository compoundRepository;

    @Override
    public CompoundEntity saveCompound(CompoundEntity compoundEntity) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Jakarta"));
        compoundEntity.setCreatedAt(now);
        compoundEntity.setUpdatedAt(now);

        return compoundRepository.save(compoundEntity);
    }

    @Override
    public Optional<CompoundEntity> getCompoundByCid(Integer cid) {
        return compoundRepository.findByHerbalChemCid(cid);
    }

    @Override
    public List<CompoundEntity> getAllCompounds() {
        return compoundRepository.findAll();
    }
}
