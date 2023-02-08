package org.herbal.chem.compound.form.repository;

import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompoundSummaryRepository extends ElasticsearchRepository<CompoundSummaryEntity, Integer> {
}
