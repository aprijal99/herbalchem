import {SectionContainer} from './util/LayoutUtil';
import {SectionSubTitle, SectionTitle} from './util/TitleUtil';
import {Table} from '@nextui-org/react';
import {PropsDetails} from '../../pages/compounds/[cid]';

const PropertySection = ({ data }: PropsDetails) => {
  return (
    <SectionContainer>
      <SectionTitle number='4' title='Chemical and Physical Properties' />
      <SectionSubTitle subTitle='Computed Properties' />
      <Table
        compact
        shadow={false}
        css={{
          px: '0',
          py: '$5',
        }}
        aria-label='Table of computed properties of chemical and physical properties section'
      >
        <Table.Header>
          <Table.Column>Property Name</Table.Column>
          <Table.Column>Property Value</Table.Column>
        </Table.Header>
        <Table.Body>
          <Table.Row key='1'>
            <Table.Cell>Molecular Weight</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.molecularWeight}</Table.Cell>
          </Table.Row>
          <Table.Row key='2'>
            <Table.Cell>XLogP3</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.xLogP3}</Table.Cell>
          </Table.Row>
          <Table.Row key='3'>
            <Table.Cell>Hydrogen Bond Donor Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.hydrogenDonor}</Table.Cell>
          </Table.Row>
          <Table.Row key='4'>
            <Table.Cell>Hydrogen Bond Acceptor Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.hydrogenAcceptor}</Table.Cell>
          </Table.Row>
          <Table.Row key='5'>
            <Table.Cell>Rotatable Bond Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.rotatableBond}</Table.Cell>
          </Table.Row>
          <Table.Row key='6'>
            <Table.Cell>Exact Mass</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.exactMass}</Table.Cell>
          </Table.Row>
          <Table.Row key='7'>
            <Table.Cell>Monoisotopic Mass</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.monoisotopicMass}</Table.Cell>
          </Table.Row>
          <Table.Row key='8'>
            <Table.Cell>Topological Polar Surface Area</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.topPolarSurfaceArea} Å²</Table.Cell>
          </Table.Row>
          <Table.Row key='9'>
            <Table.Cell>Heavy Atom Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.heavyAtom}</Table.Cell>
          </Table.Row>
          <Table.Row key='10'>
            <Table.Cell>Formal Charge</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.formalCharge}</Table.Cell>
          </Table.Row>
          <Table.Row key='11'>
            <Table.Cell>Complexity</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.complexity}</Table.Cell>
          </Table.Row>
          <Table.Row key='12'>
            <Table.Cell>Isotope Atom Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.isotopeAtom}</Table.Cell>
          </Table.Row>
          <Table.Row key='13'>
            <Table.Cell>Defined Atom Stereocenter Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.defAtomStereocenter}</Table.Cell>
          </Table.Row>
          <Table.Row key='14'>
            <Table.Cell>Undefined Atom Stereocenter Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.undefAtomStereocenter}</Table.Cell>
          </Table.Row>
          <Table.Row key='15'>
            <Table.Cell>Defined Bond Stereocenter Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.defBondStereocenter}</Table.Cell>
          </Table.Row>
          <Table.Row key='16'>
            <Table.Cell>Undefined Bond Stereocenter Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.undefBondStereocenter}</Table.Cell>
          </Table.Row>
          <Table.Row key='17'>
            <Table.Cell>Covalently-Bonded Unit Count</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.covalentlyBondedUnit}</Table.Cell>
          </Table.Row>
          <Table.Row key='18'>
            <Table.Cell>Compound Is Canonicalized</Table.Cell>
            <Table.Cell>{data.chemicalPhysicalPropertyServiceDto.computedProperty.canonicalized ? 'Yes' : 'No'}</Table.Cell>
          </Table.Row>
        </Table.Body>
      </Table>
    </SectionContainer>
  );
}

export default PropertySection;