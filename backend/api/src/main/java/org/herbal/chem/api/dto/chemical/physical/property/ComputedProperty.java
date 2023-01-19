package org.herbal.chem.api.dto.chemical.physical.property;

import java.io.Serializable;

public class ComputedProperty implements Serializable {
    private Integer herbalChemCid;
    private Float molecularWeight;
    private Float xLogP3;
    private Integer hydrogenDonor;
    private Integer hydrogenAcceptor;
    private Integer rotatableBond;
    private Float exactMass;
    private Float monoisotopicMass;
    private Float topPolarSurfaceArea;
    private Integer heavyAtom;
    private Integer formalCharge;
    private Integer complexity;
    private Integer isotopeAtom;
    private Integer defAtomStereocenter;
    private Integer undefAtomStereocenter;
    private Integer defBondStereocenter;
    private Integer undefBondStereocenter;
    private Integer covalentlyBondedUnit;
    private Boolean canonicalized;

    public ComputedProperty() {
    }

    public ComputedProperty(Integer herbalChemCid, Float molecularWeight, Float xLogP3, Integer hydrogenDonor,
                            Integer hydrogenAcceptor, Integer rotatableBond, Float exactMass, Float monoisotopicMass,
                            Float topPolarSurfaceArea, Integer heavyAtom, Integer formalCharge, Integer complexity,
                            Integer isotopeAtom, Integer defAtomStereocenter, Integer undefAtomStereocenter,
                            Integer defBondStereocenter, Integer undefBondStereocenter, Integer covalentlyBondedUnit,
                            Boolean canonicalized) {
        this.herbalChemCid = herbalChemCid;
        this.molecularWeight = molecularWeight;
        this.xLogP3 = xLogP3;
        this.hydrogenDonor = hydrogenDonor;
        this.hydrogenAcceptor = hydrogenAcceptor;
        this.rotatableBond = rotatableBond;
        this.exactMass = exactMass;
        this.monoisotopicMass = monoisotopicMass;
        this.topPolarSurfaceArea = topPolarSurfaceArea;
        this.heavyAtom = heavyAtom;
        this.formalCharge = formalCharge;
        this.complexity = complexity;
        this.isotopeAtom = isotopeAtom;
        this.defAtomStereocenter = defAtomStereocenter;
        this.undefAtomStereocenter = undefAtomStereocenter;
        this.defBondStereocenter = defBondStereocenter;
        this.undefBondStereocenter = undefBondStereocenter;
        this.covalentlyBondedUnit = covalentlyBondedUnit;
        this.canonicalized = canonicalized;
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
        return "ComputedProperty{" +
                "herbalChemCid=" + herbalChemCid +
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
