package org.herbal.chem.name.identifier.entity;

import javax.persistence.*;

@Entity
@Table(name = "synonym")
public class SynonymEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "synonym", nullable = false, length = 100)
    private String synonym;

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

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    @Override
    public String toString() {
        return "SynonymEntity{" +
                "id=" + id +
                ", herbalChemCid=" + herbalChemCid +
                ", synonym='" + synonym + '\'' +
                '}';
    }
}
