package org.herbal.chem.api.dto.name.identifier;

import java.io.Serializable;

public class NameIdentifierServiceDto implements Serializable {
    private ComputedDescriptor computedDescriptor;
    private MolecularFormula molecularFormula;
    private Synonym synonym;

    public NameIdentifierServiceDto() {
    }

    public NameIdentifierServiceDto(ComputedDescriptor computedDescriptor, MolecularFormula molecularFormula, Synonym synonym) {
        this.computedDescriptor = computedDescriptor;
        this.molecularFormula = molecularFormula;
        this.synonym = synonym;
    }

    public ComputedDescriptor getComputedDescriptor() {
        return computedDescriptor;
    }

    public void setComputedDescriptor(ComputedDescriptor computedDescriptor) {
        this.computedDescriptor = computedDescriptor;
    }

    public MolecularFormula getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(MolecularFormula molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public Synonym getSynonym() {
        return synonym;
    }

    public void setSynonym(Synonym synonym) {
        this.synonym = synonym;
    }

    @Override
    public String toString() {
        return "NameIdentifierServiceDto{" +
                "computedDescriptor=" + computedDescriptor +
                ", molecularFormula=" + molecularFormula +
                ", synonym=" + synonym +
                '}';
    }
}
