package org.herbal.chem.api.dto.organism;

import java.io.Serializable;

public class Reference implements Serializable {
    private Integer herbalChemCid;
    private String reference;
    private Integer organismId;

    public Reference() {
    }

    public Reference(Integer herbalChemCid, String reference, Integer organismId) {
        this.herbalChemCid = herbalChemCid;
        this.reference = reference;
        this.organismId = organismId;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getOrganismId() {
        return organismId;
    }

    public void setOrganismId(Integer organismId) {
        this.organismId = organismId;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "herbalChemCid=" + herbalChemCid +
                ", reference='" + reference + '\'' +
                ", organismId=" + organismId +
                '}';
    }
}
