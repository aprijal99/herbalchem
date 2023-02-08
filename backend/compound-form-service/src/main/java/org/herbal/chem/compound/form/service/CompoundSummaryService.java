package org.herbal.chem.compound.form.service;

import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;

public interface CompoundSummaryService {
    void sendCompoundSummaryToElasticsearch(CompoundSummaryEntity compoundSummaryEntity);
}
