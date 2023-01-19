package org.herbal.chem.organism.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organism")
public class OrganismEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "family", nullable = false)
    private String family;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "subspecies", nullable = true)
    private String subspecies;

    @OneToMany(mappedBy = "organism")
    private List<ReferenceEntity> referenceEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<ReferenceEntity> getReferenceEntities() {
        return referenceEntities;
    }

    public void setReferenceEntities(List<ReferenceEntity> referenceEntities) {
        this.referenceEntities = referenceEntities;
    }

    @Override
    public String toString() {
        return "OrganismEntity{" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", species='" + species + '\'' +
                ", subspecies='" + subspecies + '\'' +
                ", referenceEntities=" + referenceEntities +
                '}';
    }
}
