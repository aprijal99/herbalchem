package org.herbal.chem.structure.entity;

import javax.persistence.*;

@Entity
@Table(name = "structure")
public class StructureEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "structure_2d_url", nullable = false)
    private String structure2DUrl;

    @Column(name = "structure_3d_url", nullable = false)
    private String structure3DUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
