package org.herbal.chem.compound.detail.dto;

import lombok.*;
import org.herbal.chem.api.dto.CompoundServiceDto;
import org.herbal.chem.api.dto.chemical.physical.property.ChemicalPhysicalPropertyServiceDto;
import org.herbal.chem.api.dto.name.identifier.NameIdentifierServiceDto;
import org.herbal.chem.api.dto.organism.OrganismServiceDto;
import org.herbal.chem.api.dto.structure.StructureServiceDto;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompoundDetail extends RepresentationModel<CompoundDetail> {
    private CompoundServiceDto compoundServiceDto;
    private StructureServiceDto structureServiceDto;
    private NameIdentifierServiceDto nameIdentifierServiceDto;
    private ChemicalPhysicalPropertyServiceDto chemicalPhysicalPropertyServiceDto;
    private OrganismServiceDto organismServiceDto;
}
