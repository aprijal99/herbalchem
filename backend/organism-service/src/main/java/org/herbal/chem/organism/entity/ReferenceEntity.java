package org.herbal.chem.organism.entity;

import javax.persistence.*;

@Entity
@Table(name = "reference")
public class ReferenceEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "reference", nullable = false)
    private String reference;

    @ManyToOne @JoinColumn(name = "organism", nullable = false)
    private OrganismEntity organism;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public OrganismEntity getOrganism() {
        return organism;
    }

    public void setOrganism(OrganismEntity organism) {
        this.organism = organism;
    }

    @Override
    public String toString() {
        return "ReferenceEntity{" +
                "id=" + id +
                ", herbalChemCid=" + herbalChemCid +
                ", reference='" + reference + '\'' +
                ", organism=" + organism +
                '}';
    }
}
