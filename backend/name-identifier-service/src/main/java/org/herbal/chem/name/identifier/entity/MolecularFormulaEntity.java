package org.herbal.chem.name.identifier.entity;

import javax.persistence.*;

@Entity
@Table(name = "molecular_formula")
public class MolecularFormulaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "molecular_formula", nullable = false, length = 100)
    private String molecularFormula;

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

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    @Override
    public String toString() {
        return "MolecularFormulaEntity{" +
                "id=" + id +
                ", herbalChemCid=" + herbalChemCid +
                ", molecularFormula='" + molecularFormula + '\'' +
                '}';
    }
}
