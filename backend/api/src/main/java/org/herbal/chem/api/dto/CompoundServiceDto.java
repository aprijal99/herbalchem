package org.herbal.chem.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompoundServiceDto implements Serializable {
    private Integer herbalChemCid;
    private String compoundName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompoundServiceDto() {
    }

    public CompoundServiceDto(Integer herbalChemCid, String compoundName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.herbalChemCid = herbalChemCid;
        this.compoundName = compoundName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    @Override
    public String toString() {
        return "CompoundServiceDto{" +
                "herbalChemCid=" + herbalChemCid +
                ", compoundName='" + compoundName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
