package org.herbal.chem.api.dto.name.identifier;

import java.io.Serializable;

public class Synonym implements Serializable {
    private Integer herbalChemCid;
    private String synonym;

    public Synonym() {
    }

    public Synonym(Integer herbalChemCid, String synonym) {
        this.herbalChemCid = herbalChemCid;
        this.synonym = synonym;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    @Override
    public String toString() {
        return "Synonym{" +
                "herbalChemCid=" + herbalChemCid +
                ", synonym='" + synonym + '\'' +
                '}';
    }
}
