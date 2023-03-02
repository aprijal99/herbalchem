package org.herbal.chem.compound.form.service;

import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
import org.herbal.chem.compound.form.entity.CompoundSummaryEntity;

public interface CompoundSummaryService {
    void sendCompoundSummaryToElasticsearch(CompoundSummaryEntity compoundSummaryEntity);
    CompoundSummaryEntity crateCompoundSummaryEntity(Integer herbalChemCid, CompoundServiceDto compoundServiceDto, CompoundDetailRequest compoundDetailRequest);
}
