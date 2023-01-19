package org.herbal.chem.api.dto.chemical.physical.property;

import java.io.Serializable;

public class ChemicalPhysicalPropertyServiceDto implements Serializable {
    private ComputedProperty computedProperty;

    public ChemicalPhysicalPropertyServiceDto() {
    }

    public ChemicalPhysicalPropertyServiceDto(ComputedProperty computedProperty) {
        this.computedProperty = computedProperty;
    }

    public ComputedProperty getComputedProperty() {
        return computedProperty;
    }

    public void setComputedProperty(ComputedProperty computedProperty) {
        this.computedProperty = computedProperty;
    }

    @Override
    public String toString() {
        return "PhysicalChemicalPropertyServiceDto{" +
                "computedProperty=" + computedProperty +
                '}';
    }
}
