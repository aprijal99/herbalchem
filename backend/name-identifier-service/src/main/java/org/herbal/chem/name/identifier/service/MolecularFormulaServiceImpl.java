package org.herbal.chem.name.identifier.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.name.identifier.entity.MolecularFormulaEntity;
import org.herbal.chem.name.identifier.repository.MolecularFormulaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class MolecularFormulaServiceImpl implements MolecularFormulaService {
    private final MolecularFormulaRepository molecularFormulaRepository;

    @Override
    public void saveMolecularFormula(MolecularFormulaEntity molecularFormulaEntity) {
        molecularFormulaRepository.save(molecularFormulaEntity);
    }

    @Override
    public Optional<MolecularFormulaEntity> getMolecularFormulaByCid(Integer cid) {
        return molecularFormulaRepository.findByHerbalChemCid(cid);
    }
}
