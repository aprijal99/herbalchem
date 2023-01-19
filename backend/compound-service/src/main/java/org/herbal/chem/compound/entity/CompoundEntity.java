package org.herbal.chem.compound.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "compound")
@Relation(collectionRelation = "compounds")
public class CompoundEntity extends RepresentationModel<CompoundEntity> {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "compound_name", nullable = false, length = 1000)
    private String compoundName;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    public CompoundEntity(String compoundName) {
        this.compoundName = compoundName;
    }

    public Integer getHerbalChemCid() {
        return herbalChemCid;
    }

    public void setHerbalChemCid(Integer herbalChemCid) {
        this.herbalChemCid = herbalChemCid;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
