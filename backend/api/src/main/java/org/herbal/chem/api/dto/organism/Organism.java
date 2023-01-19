package org.herbal.chem.api.dto.organism;

import java.io.Serializable;

public class Organism implements Serializable {
    private String family;
    private String species;
    private String subspecies;

    public Organism() {
    }

    public Organism(String family, String species, String subspecies) {
        this.family = family;
        this.species = species;
        this.subspecies = subspecies;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    @Override
    public String toString() {
        return "Organism{" +
                "family='" + family + '\'' +
                ", species='" + species + '\'' +
                ", subspecies='" + subspecies + '\'' +
                '}';
    }
}
