package org.herbal.chem.chemical.physical.property.entity;

import javax.persistence.*;

@Entity
@Table(name = "computed_property")
public class ComputedPropertyEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "herbal_chem_cid", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer herbalChemCid;

    @Column(name = "molecular_weight", nullable = false, columnDefinition = "FLOAT UNSIGNED")
    private Float molecularWeight;

    @Column(name = "xlogp3", nullable = false, columnDefinition = "FLOAT UNSIGNED")
    private Float xLogP3;

    @Column(name = "hydrogen_donor", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer hydrogenDonor;

    @Column(name = "hydrogen_acceptor", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer hydrogenAcceptor;

    @Column(name = "rotatable_bond", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer rotatableBond;

    @Column(name = "exact_mass", nullable = false, columnDefinition = "FLOAT UNSIGNED")
    private Float exactMass;

    @Column(name = "monoisotopic_mass", nullable = false, columnDefinition = "FLOAT UNSIGNED")
    private Float monoisotopicMass;

    @Column(name = "top_polar_surface_area", nullable = false, columnDefinition = "FLOAT UNSIGNED")
    private Float topPolarSurfaceArea;

    @Column(name = "heavy_atom", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer heavyAtom;

    @Column(name = "formal_charge", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer formalCharge;

    @Column(name = "complexity", nullable = false, columnDefinition = "SMALLINT(4) UNSIGNED")
    private Integer complexity;

    @Column(name = "isotope_atom", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer isotopeAtom;

    @Column(name = "def_atom_stereocenter", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer defAtomStereocenter;

    @Column(name = "undef_atom_stereocenter", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer undefAtomStereocenter;

    @Column(name = "def_bond_stereocenter", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer defBondStereocenter;

    @Column(name = "undef_bond_stereocenter", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer undefBondStereocenter;

    @Column(name = "covalently_bonded_unit", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED")
    private Integer covalentlyBondedUnit;

    @Column(name = "canonicalized", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Boolean canonicalized;

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

    public Float getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(Float molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public Float getxLogP3() {
        return xLogP3;
    }

    public void setxLogP3(Float xLogP3) {
        this.xLogP3 = xLogP3;
    }

    public Integer getHydrogenDonor() {
        return hydrogenDonor;
    }

    public void setHydrogenDonor(Integer hydrogenDonor) {
        this.hydrogenDonor = hydrogenDonor;
    }

    public Integer getHydrogenAcceptor() {
        return hydrogenAcceptor;
    }

    public void setHydrogenAcceptor(Integer hydrogenAcceptor) {
        this.hydrogenAcceptor = hydrogenAcceptor;
    }

    public Integer getRotatableBond() {
        return rotatableBond;
    }

    public void setRotatableBond(Integer rotatableBond) {
        this.rotatableBond = rotatableBond;
    }

    public Float getExactMass() {
        return exactMass;
    }

    public void setExactMass(Float exactMass) {
        this.exactMass = exactMass;
    }

    public Float getMonoisotopicMass() {
        return monoisotopicMass;
    }

    public void setMonoisotopicMass(Float monoisotopicMass) {
        this.monoisotopicMass = monoisotopicMass;
    }

    public Float getTopPolarSurfaceArea() {
        return topPolarSurfaceArea;
    }

    public void setTopPolarSurfaceArea(Float topPolarSurfaceArea) {
        this.topPolarSurfaceArea = topPolarSurfaceArea;
    }

    public Integer getHeavyAtom() {
        return heavyAtom;
    }

    public void setHeavyAtom(Integer heavyAtom) {
        this.heavyAtom = heavyAtom;
    }

    public Integer getFormalCharge() {
        return formalCharge;
    }

    public void setFormalCharge(Integer formalCharge) {
        this.formalCharge = formalCharge;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Integer getIsotopeAtom() {
        return isotopeAtom;
    }

    public void setIsotopeAtom(Integer isotopeAtom) {
        this.isotopeAtom = isotopeAtom;
    }

    public Integer getDefAtomStereocenter() {
        return defAtomStereocenter;
    }

    public void setDefAtomStereocenter(Integer defAtomStereocenter) {
        this.defAtomStereocenter = defAtomStereocenter;
    }

    public Integer getUndefAtomStereocenter() {
        return undefAtomStereocenter;
    }

    public void setUndefAtomStereocenter(Integer undefAtomStereocenter) {
        this.undefAtomStereocenter = undefAtomStereocenter;
    }

    public Integer getDefBondStereocenter() {
        return defBondStereocenter;
    }

    public void setDefBondStereocenter(Integer defBondStereocenter) {
        this.defBondStereocenter = defBondStereocenter;
    }

    public Integer getUndefBondStereocenter() {
        return undefBondStereocenter;
    }

    public void setUndefBondStereocenter(Integer undefBondStereocenter) {
        this.undefBondStereocenter = undefBondStereocenter;
    }

    public Integer getCovalentlyBondedUnit() {
        return covalentlyBondedUnit;
    }

    public void setCovalentlyBondedUnit(Integer covalentlyBondedUnit) {
        this.covalentlyBondedUnit = covalentlyBondedUnit;
    }

    public Boolean getCanonicalized() {
        return canonicalized;
    }

    public void setCanonicalized(Boolean canonicalized) {
        this.canonicalized = canonicalized;
    }

    @Override
    public String toString() {
        return "ComputedPropertyEntity{" +
                "id=" + id +
                ", herbalChemCid=" + herbalChemCid +
                ", molecularWeight=" + molecularWeight +
                ", xLogP3=" + xLogP3 +
                ", hydrogenDonor=" + hydrogenDonor +
                ", hydrogenAcceptor=" + hydrogenAcceptor +
                ", rotatableBond=" + rotatableBond +
                ", exactMass=" + exactMass +
                ", monoisotopicMass=" + monoisotopicMass +
                ", topPolarSurfaceArea=" + topPolarSurfaceArea +
                ", heavyAtom=" + heavyAtom +
                ", formalCharge=" + formalCharge +
                ", complexity=" + complexity +
                ", isotopeAtom=" + isotopeAtom +
                ", defAtomStereocenter=" + defAtomStereocenter +
                ", undefAtomStereocenter=" + undefAtomStereocenter +
                ", defBondStereocenter=" + defBondStereocenter +
                ", undefBondStereocenter=" + undefBondStereocenter +
                ", covalentlyBondedUnit=" + covalentlyBondedUnit +
                ", canonicalized=" + canonicalized +
                '}';
    }
}
