package org.herbal.chem.name.identifier.entity;

import javax.persistence.*;

@Entity
@Table(name = "computed_descriptor")
public class ComputedDescriptorEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "iupac_name", nullable = false, length = 1000)
    private String iupacName;

    @Column(name = "inchl", nullable = false, length = 1000)
    private String inchl;

    @Column(name = "inchlkey", nullable = false, length = 1000)
    private String inchlKey;

    @Column(name = "canonical_smiles", nullable = false, length = 1000)
    private String canonicalSmiles;

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
        return "ComputedDescriptorEntity{" +
                "id=" + id +
                ", herbalChemCid=" + herbalChemCid +
                ", iupacName='" + iupacName + '\'' +
                ", inchl='" + inchl + '\'' +
                ", inchlKey='" + inchlKey + '\'' +
                ", canonicalSmiles='" + canonicalSmiles + '\'' +
                '}';
    }
}
