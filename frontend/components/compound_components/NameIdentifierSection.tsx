import {
  GridRow,
  NameIdentifierGridColumnContent,
  NameIdentifierGridColumnTitle,
  SectionContainer
} from './util/LayoutUtil';
import {SectionSubTitle, SectionTitle} from './util/TitleUtil';
import {Text} from '@nextui-org/react';

type NameIdentifierProps = {
  iupacName: string,
  inchl: string,
  inchlKey: string,
  smiles: string,
  mf: string,
  synonym: string,
}

const NameIdentifierSection = (
  { iupacName, inchl, inchlKey, smiles, mf, synonym }: NameIdentifierProps
) => {
  return (
    <SectionContainer>
      <SectionTitle number='3' title='Names and Identifier' />
      <SectionSubTitle subTitle='Computed Descriptor' />
      <GridRow border='borderBottom'>
        <NameIdentifierGridColumnTitle xs={12}>IUPAC Name</NameIdentifierGridColumnTitle>
        <NameIdentifierGridColumnContent xs={12}>{iupacName}</NameIdentifierGridColumnContent>
      </GridRow>

      <GridRow border='borderBottom'>
        <NameIdentifierGridColumnTitle xs={12}>InChl</NameIdentifierGridColumnTitle>
        <NameIdentifierGridColumnContent xs={12}>InChl={inchl}</NameIdentifierGridColumnContent>
      </GridRow>

      <GridRow border='borderBottom'>
        <NameIdentifierGridColumnTitle xs={12}>InChlKey</NameIdentifierGridColumnTitle>
        <NameIdentifierGridColumnContent xs={12}>{inchlKey}</NameIdentifierGridColumnContent>
      </GridRow>

      <GridRow>
        <NameIdentifierGridColumnTitle xs={12}>Canonical SMILES</NameIdentifierGridColumnTitle>
        <NameIdentifierGridColumnContent xs={12} css={{ overflowWrap: 'anywhere' }}>{smiles}</NameIdentifierGridColumnContent>
      </GridRow>

      <SectionSubTitle subTitle='Molecular Formula' />
      <GridRow>
        <Text
          css={{
            '@xsMin': {
              pl: '$5',
            },
          }}
        >
          {mf}
        </Text>
      </GridRow>

      <SectionSubTitle subTitle='Synonyms' />
      <GridRow>
        <Text
          css={{
            '@xsMin': {
              pl: '$5',
            },
          }}
        >
          {synonym}
        </Text>
      </GridRow>
    </SectionContainer>
  );
}

export default NameIdentifierSection;