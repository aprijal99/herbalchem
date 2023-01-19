package org.herbal.chem.compound.detail.service;

import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;

public interface CompoundDetailService {
    CompoundServiceDto getCompoundFromCompoundService(Integer cid);
    StructureServiceDto getStructureFromStructureService(Integer cid);
    NameIdentifierServiceDto getNameIdentifierFromNameIdentifierService(Integer cid);
    ChemicalPhysicalPropertyServiceDto getChemicalPhysicalPropertyFromChemicalPhysicalPropertyService(Integer cid);
    OrganismServiceDto getOrganismFromOrganismService(Integer cid);
}
