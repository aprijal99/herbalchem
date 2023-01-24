import {Grid, Text} from '@nextui-org/react';
import DividedGrid from './util/DividedGrid';
import FormInput from './util/FormInput';

const NameIdentifierInput = () => {
  return (
    <Grid.Container gap={2} css={{ px: '0' }}>
      <Grid xs={12} css={{ pb: '0' }}>
        <Text h4 css={{ m: '0' }}>Names and Identifiers</Text>
      </Grid>
      <DividedGrid col='50%'>
        <FormInput label='IUPAC Name' placeholder='ex. 2-acetyloxybenzoic acid' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='InChl' placeholder='ex. 1S/C9H8O4/c1-6(10)13-8-5-3-2-4-7(8)9(11)12/h2-5H,1H3,(H,11,12)' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='InChlKey' placeholder='ex. BSYNRYMUTXBXSQ-UHFFFAOYSA-N' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Canonical SMILES' placeholder='ex. CC(=O)OC1=CC=CC=C1C(=O)O' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Molecular Formula' placeholder='ex. C9H8O4' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Synonym' placeholder='ex. Acetylsalicylic Acid' />
      </DividedGrid>
    </Grid.Container>
  );
}

export default NameIdentifierInput;