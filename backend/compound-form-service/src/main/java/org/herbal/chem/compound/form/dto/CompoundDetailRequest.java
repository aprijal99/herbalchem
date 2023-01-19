package org.herbal.chem.compound.form.dto;

import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;

import java.io.Serializable;

public class CompoundDetailRequest implements Serializable {
    private NameIdentifierServiceDto nameIdentifierServiceDto;
    private ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto;
    private OrganismServiceDto organismServiceDto;
    private StructureServiceDto structureServiceDto;

    public CompoundDetailRequest() {
    }

    public CompoundDetailRequest(NameIdentifierServiceDto nameIdentifierServiceDto,
                                 ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto,
                                 OrganismServiceDto organismServiceDto,
                                 StructureServiceDto structureServiceDto) {
        this.nameIdentifierServiceDto = nameIdentifierServiceDto;
        this.chemicalPhysicalPropertyServiceDto = chemicalPhysicalPropertyServiceDto;
        this.organismServiceDto = organismServiceDto;
        this.structureServiceDto = structureServiceDto;
    }

    public NameIdentifierServiceDto getNameIdentifierServiceDto() {
        return nameIdentifierServiceDto;
    }

    public void setNameIdentifierServiceDto(NameIdentifierServiceDto nameIdentifierServiceDto) {
        this.nameIdentifierServiceDto = nameIdentifierServiceDto;
    }

    public ChemicalPhysicalPropertyServiceDto getChemicalPhysicalPropertyServiceDto() {
        return chemicalPhysicalPropertyServiceDto;
    }

    public void setChemicalPhysicalPropertyServiceDto(ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto) {
        this.chemicalPhysicalPropertyServiceDto = chemicalPhysicalPropertyServiceDto;
    }

    public OrganismServiceDto getOrganismServiceDto() {
        return organismServiceDto;
    }

    public void setOrganismServiceDto(OrganismServiceDto organismServiceDto) {
        this.organismServiceDto = organismServiceDto;
    }

    public StructureServiceDto getStructureServiceDto() {
        return structureServiceDto;
    }

    public void setStructureServiceDto(StructureServiceDto structureServiceDto) {
        this.structureServiceDto = structureServiceDto;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.getNameIdentifierServiceDto().getComputedDescriptor().setHerbalChemCid(herbalChemCid);
        this.getNameIdentifierServiceDto().getMolecularFormula().setHerbalChemCid(herbalChemCid);
        this.getNameIdentifierServiceDto().getSynonym().setHerbalChemCid(herbalChemCid);
        this.getChemicalPhysicalPropertyServiceDto().getComputedProperty().setHerbalChemCid(herbalChemCid);
        this.getOrganismServiceDto().getReference().setHerbalChemCid(herbalChemCid);
        this.getStructureServiceDto().setHerbalChemCid(herbalChemCid);
    }

    @Override
    public String toString() {
        return "CompoundDetailRequest{" +
                "nameIdentifierServiceDto=" + nameIdentifierServiceDto +
                ", chemicalPhysicalPropertyServiceDto=" + chemicalPhysicalPropertyServiceDto +
                ", organismServiceDto=" + organismServiceDto +
                ", structureServiceDto=" + structureServiceDto +
                '}';
    }
}
