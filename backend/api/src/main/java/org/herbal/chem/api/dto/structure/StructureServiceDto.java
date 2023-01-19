package org.herbal.chem.api.dto.structure;

import java.io.Serializable;

public class StructureServiceDto implements Serializable {
    private Integer herbalChemCid;
    private String structure2DUrl;
    private String structure3DUrl;

    public StructureServiceDto() {
    }

    public StructureServiceDto(Integer herbalChemCid, String structure2DUrl, String structure3DUrl) {
        this.herbalChemCid = herbalChemCid;
        this.structure2DUrl = structure2DUrl;
        this.structure3DUrl = structure3DUrl;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getStructure2DUrl() {
        return structure2DUrl;
    }

    public void setStructure2DUrl(String structure2DUrl) {
        this.structure2DUrl = structure2DUrl;
    }

    public String getStructure3DUrl() {
        return structure3DUrl;
    }

    public void setStructure3DUrl(String structure3DUrl) {
        this.structure3DUrl = structure3DUrl;
    }

    @Override
    public String toString() {
        return "StructureServiceDto{" +
                "herbalChemCid=" + herbalChemCid +
                ", structure2DUrl='" + structure2DUrl + '\'' +
                ", structure3DUrl='" + structure3DUrl + '\'' +
                '}';
    }
}
