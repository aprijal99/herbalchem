package org.herbal.chem.compound.form.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Builder
@Document(indexName = "compound_summary")
public class CompoundSummaryEntity {
    @Id
    private Integer herbalChemCid;
    private String compoundName;
    private String synonym;
    private String molecularFormula;
    private Float molecularWeight;
    private String iupacName;
    private String canonicalSmiles;
    private String inchlKey;
    private String inchl;
    private LocalDateTime createdAt;
    private String structure2DUrl;

    public CompoundSummaryEntity() {
    }

    public CompoundSummaryEntity(Integer herbalChemCid,
                                 String compoundName,
                                 String synonym,
                                 String molecularFormula,
                                 Float molecularWeight,
                                 String iupacName,
                                 String canonicalSmiles,
                                 String inchlKey,
                                 String inchl,
                                 LocalDateTime createdAt,
                                 String structure2DUrl) {
        this.herbalChemCid = herbalChemCid;
        this.compoundName = compoundName;
        this.synonym = synonym;
        this.molecularFormula = molecularFormula;
        this.molecularWeight = molecularWeight;
        this.iupacName = iupacName;
        this.canonicalSmiles = canonicalSmiles;
        this.inchlKey = inchlKey;
        this.inchl = inchl;
        this.createdAt = createdAt;
        this.structure2DUrl = structure2DUrl;
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

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public Float getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(Float molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getIupacName() {
        return iupacName;
    }

    public void setIupacName(String iupacName) {
        this.iupacName = iupacName;
    }

    public String getCanonicalSmiles() {
        return canonicalSmiles;
    }

    public void setCanonicalSmiles(String canonicalSmiles) {
        this.canonicalSmiles = canonicalSmiles;
    }

    public String getInchlKey() {
        return inchlKey;
    }

    public void setInchlKey(String inchlKey) {
        this.inchlKey = inchlKey;
    }

    public String getInchl() {
        return inchl;
    }

    public void setInchl(String inchl) {
        this.inchl = inchl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStructure2DUrl() {
        return structure2DUrl;
    }

    public void setStructure2DUrl(String structure2DUrl) {
        this.structure2DUrl = structure2DUrl;
    }

    @Override
    public String toString() {
        return "CompoundSummaryEntity{" +
                "herbalChemCid=" + herbalChemCid +
                ", compoundName='" + compoundName + '\'' +
                ", synonym='" + synonym + '\'' +
                ", molecularFormula='" + molecularFormula + '\'' +
                ", molecularWeight=" + molecularWeight +
                ", iupacName='" + iupacName + '\'' +
                ", canonicalSmiles='" + canonicalSmiles + '\'' +
                ", inchlKey='" + inchlKey + '\'' +
                ", inchl='" + inchl + '\'' +
                ", createdAt=" + createdAt +
                ", structure2DUrl='" + structure2DUrl + '\'' +
                '}';
    }
}
