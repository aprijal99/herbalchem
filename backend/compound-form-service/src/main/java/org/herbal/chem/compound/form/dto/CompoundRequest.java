package org.herbal.chem.compound.form.dto;

import org.herbal.chem.api.dto.CompoundServiceDto;

public class CompoundRequest {
    private CompoundServiceDto compoundServiceDto;
    private CompoundDetailRequest compoundDetailRequest;

    public CompoundRequest() {
    }

    public CompoundRequest(CompoundServiceDto compoundServiceDto, CompoundDetailRequest compoundDetailRequest) {
        this.compoundServiceDto = compoundServiceDto;
        this.compoundDetailRequest = compoundDetailRequest;
    }

    public CompoundServiceDto getCompoundServiceDto() {
        return compoundServiceDto;
    }

    public void setCompoundServiceDto(CompoundServiceDto compoundServiceDto) {
        this.compoundServiceDto = compoundServiceDto;
    }

    public CompoundDetailRequest getCompoundDetailRequest() {
        return compoundDetailRequest;
    }

    public void setCompoundDetailRequest(CompoundDetailRequest compoundDetailRequest) {
        this.compoundDetailRequest = compoundDetailRequest;
    }

    @Override
    public String toString() {
        return "CompoundRequest{" +
                "compoundServiceDto=" + compoundServiceDto +
                ", compoundDetailRequest=" + compoundDetailRequest +
                '}';
    }
}
