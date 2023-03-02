import {GetServerSideProps, NextPage} from 'next';
import {ParsedUrlQuery} from 'querystring';
import {Container} from '@nextui-org/react';
import {composeServerSideProps} from 'next-composition';
import StructureSection from '../../components/compound_components/StructureSection';
import {CompoundTitle} from '../../components/compound_components/util/TitleUtil';
import SummarySection from '../../components/compound_components/SummarySection';
import NameIdentifierSection from '../../components/compound_components/NameIdentifierSection';
import PropertySection from '../../components/compound_components/PropertySection';
import OrganismSection from '../../components/compound_components/OrganismSection';
import {wrapper} from '../../store';
import validateToken from '../../functions/validateToken';

interface QParams extends ParsedUrlQuery {
  cid: string,
}

interface DataDetails {
  compoundServiceDto: {
    herbalChemCid: number,
    compoundName: string,
    createdAt: string,
    updatedAt: string,
  },
  structureServiceDto: {
    herbalChemCid: number,
    structure2DUrl: string,
    structure3DUrl: string,
  },
  nameIdentifierServiceDto: {
    computedDescriptor: {
      herbalChemCid: number,
      iupacName: string,
      inchl: string,
      inchlKey: string,
      canonicalSmiles: string,
    },
    molecularFormula: {
      herbalChemCid: number,
      molecularFormula: string,
    },
    synonym: {
      herbalChemCid: number,
      synonym: string,
    },
  },
  chemicalPhysicalPropertyServiceDto: {
    computedProperty: {
      herbalChemCid: number,
      molecularWeight: number,
      xLogP3: number,
      hydrogenDonor: number,
      hydrogenAcceptor: number,
      rotatableBond: number,
      exactMass: number,
      monoisotopicMass: number,
      topPolarSurfaceArea: number,
      heavyAtom: number,
      formalCharge: number,
      complexity: number,
      isotopeAtom: number,
      defAtomStereocenter: number,
      undefAtomStereocenter: number,
      defBondStereocenter: number,
      undefBondStereocenter: number,
      covalentlyBondedUnit: number,
      canonicalized: boolean,
    },
  },
  organismServiceDto: {
    reference: {
      herbalChemCid: number,
      reference: string,
      organismId: number,
    },
    organism: {
      family: string,
      species: string,
      subspecies: string,
    },
  },
  _links: {
    self: {
      href: string,
    },
  },
}

export interface PropsDetails {
  data: DataDetails,
}

const Compound: NextPage<PropsDetails> = (props) => {
  const { data } = props;

  return (
    <Container
      lg
      css={{
        py: '$xl',
        '@xsMax': {
          px: 'var(--nextui-space-6)',
        },
      }}
    >
      <CompoundTitle
        title={data.compoundServiceDto.compoundName}
        date={data.compoundServiceDto.createdAt}
      />
      <SummarySection
        cid={data.compoundServiceDto.herbalChemCid}
        mf={data.nameIdentifierServiceDto.molecularFormula.molecularFormula}
        synonym={data.nameIdentifierServiceDto.synonym.synonym}
        mw={data.chemicalPhysicalPropertyServiceDto.computedProperty.molecularWeight}
        ca={data.compoundServiceDto.createdAt}
        ua={data.compoundServiceDto.updatedAt}
      />
      <StructureSection
        url2d={data.structureServiceDto.structure2DUrl}
        url3d={data.structureServiceDto.structure3DUrl}
      />
      <NameIdentifierSection
        iupacName={data.nameIdentifierServiceDto.computedDescriptor.iupacName}
        inchl={data.nameIdentifierServiceDto.computedDescriptor.inchl}
        inchlKey={data.nameIdentifierServiceDto.computedDescriptor.inchlKey}
        smiles={data.nameIdentifierServiceDto.computedDescriptor.canonicalSmiles}
        mf={data.nameIdentifierServiceDto.molecularFormula.molecularFormula}
        synonym={data.nameIdentifierServiceDto.synonym.synonym}
      />
      <PropertySection data={data} />
      <OrganismSection
        family={data.organismServiceDto.organism.family}
        species={data.organismServiceDto.organism.species}
        subspecies={data.organismServiceDto.organism.subspecies}
        reference={data.organismServiceDto.reference.reference}
      />
    </Container>
  );
}

const withToken: GetServerSideProps = wrapper.getServerSideProps(validateToken);

const withCompoundDetail: GetServerSideProps = async (context) => {
  const { cid } = context.params as QParams;
  const result = await fetch(`https://${process.env.NEXT_PUBLIC_GATEWAY_SERVICE}/gateway/compound-detail/${cid}`);
  const data: DataDetails = await result.json();

  return {
    props: {
      data,
    },
  };
}

export const getServerSideProps = composeServerSideProps({
  use: [withToken, withCompoundDetail],
})

export default Compound;
