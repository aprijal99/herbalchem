package org.herbal.chem.compound.form.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.compound.form.dto.CompoundDetailRequest;
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

    @Override
    public CompoundSummaryEntity crateCompoundSummaryEntity(Integer herbalChemCid, CompoundServiceDto compoundServiceDto, CompoundDetailRequest compoundDetailRequest) {
        return CompoundSummaryEntity.builder()
                .herbalChemCid(herbalChemCid)
                .compoundName(compoundServiceDto.getCompoundName())
                .synonym(compoundDetailRequest.getNameIdentifierServiceDto().getSynonym().getSynonym())
                .molecularFormula(compoundDetailRequest.getNameIdentifierServiceDto().getMolecularFormula().getMolecularFormula())
                .molecularWeight(compoundDetailRequest.getChemicalPhysicalPropertyServiceDto().getComputedProperty().getMolecularWeight())
                .iupacName(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getIupacName())
                .canonicalSmiles(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getCanonicalSmiles())
                .inchlKey(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getInchlKey())
                .inchl(compoundDetailRequest.getNameIdentifierServiceDto().getComputedDescriptor().getInchl())
                .createdAt(compoundServiceDto.getCreatedAt().toString())
                .structure2DUrl(compoundDetailRequest.getStructureServiceDto().getStructure2DUrl())
                .build();
    }
}
