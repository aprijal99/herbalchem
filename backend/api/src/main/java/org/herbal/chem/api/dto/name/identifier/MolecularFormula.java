package org.herbal.chem.api.dto.name.identifier;

import java.io.Serializable;

public class MolecularFormula implements Serializable {
    private Integer herbalChemCid;
    private String molecularFormula;

    public MolecularFormula() {
    }

    public MolecularFormula(Integer herbalChemCid, String molecularFormula) {
        this.herbalChemCid = herbalChemCid;
        this.molecularFormula = molecularFormula;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    @Override
    public String toString() {
        return "MolecularFormula{" +
                "herbalChemCid=" + herbalChemCid +
                ", molecularFormula='" + molecularFormula + '\'' +
                '}';
    }
}
