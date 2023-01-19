package org.herbal.chem.api.dto.organism;

import java.io.Serializable;

public class OrganismServiceDto implements Serializable {
    private Reference reference;
    private Organism organism;

    public OrganismServiceDto() {
    }

    public OrganismServiceDto(Reference reference, Organism organism) {
        this.reference = reference;
        this.organism = organism;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    @Override
    public String toString() {
        return "OrganismServiceDto{" +
                "reference=" + reference +
                ", organism=" + organism +
                '}';
    }
}
