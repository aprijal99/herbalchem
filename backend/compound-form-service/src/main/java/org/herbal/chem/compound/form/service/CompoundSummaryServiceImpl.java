package org.herbal.chem.compound.form.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;
import org.herbal.chem.compound.form.repository.CompoundSummaryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompoundSummaryServiceImpl implements CompoundSummaryService {
    private final CompoundSummaryRepository compoundSummaryRepository;

    @Override
    public void sendCompoundSummaryToElasticsearch(CompoundSummaryEntity compoundSummaryEntity) {
        compoundSummaryRepository.save(compoundSummaryEntity);
    }
}
