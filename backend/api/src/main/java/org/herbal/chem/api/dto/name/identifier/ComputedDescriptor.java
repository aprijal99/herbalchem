package org.herbal.chem.api.dto.name.identifier;

import java.io.Serializable;

public class ComputedDescriptor implements Serializable {
    private Integer herbalChemCid;
    private String iupacName;
    private String inchl;
    private String inchlKey;
    private String canonicalSmiles;

    public ComputedDescriptor() {
    }

    public ComputedDescriptor(Integer herbalChemCid, String iupacName, String inchl, String inchlKey, String canonicalSmiles) {
        this.herbalChemCid = herbalChemCid;
        this.iupacName = iupacName;
        this.inchl = inchl;
        this.inchlKey = inchlKey;
        this.canonicalSmiles = canonicalSmiles;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getIupacName() {
        return iupacName;
    }

    public void setIupacName(String iupacName) {
        this.iupacName = iupacName;
    }

    public String getInchl() {
        return inchl;
    }

    public void setInchl(String inchl) {
        this.inchl = inchl;
    }

    public String getInchlKey() {
        return inchlKey;
    }

    public void setInchlKey(String inchlKey) {
        this.inchlKey = inchlKey;
    }

    public String getCanonicalSmiles() {
        return canonicalSmiles;
    }

    public void setCanonicalSmiles(String canonicalSmiles) {
        this.canonicalSmiles = canonicalSmiles;
    }

    @Override
    public String toString() {
        return "ComputedDescriptor{" +
                "herbalChemCid=" + herbalChemCid +
                ", iupacName='" + iupacName + '\'' +
                ", inchl='" + inchl + '\'' +
                ", inchlKey='" + inchlKey + '\'' +
                ", canonicalSmiles='" + canonicalSmiles + '\'' +
                '}';
    }
}
