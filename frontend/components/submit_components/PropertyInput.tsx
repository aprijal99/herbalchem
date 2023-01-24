import {Grid, Text} from '@nextui-org/react';
import DividedGrid from './util/DividedGrid';
import FormInput from './util/FormInput';

const PropertyInput = () => {
  return (
    <Grid.Container gap={2} css={{ px: '0' }}>
      <Grid xs={12} css={{ pb: '0' }}>
        <Text h4 css={{ m: '0' }}>Computed Properties</Text>
      </Grid>
      <DividedGrid col='50%'>
        <FormInput label='Molecular Weight' placeholder='ex. 180.16' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='XLogP3' placeholder='ex. 1.2' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Hydrogen Bond Donor Count' placeholder='ex. 1' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Hydrogen Bond Acceptor Count' placeholder='ex. 4' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Rotatable Bond Count' placeholder='ex. 3' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Exact Mass' placeholder='ex. 180.04225873' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Monoisotopic Mass' placeholder='ex. 180.04225873' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Topological Polar Surface Area' placeholder='ex. 63.6' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Heavy Atom Count' placeholder='ex. 13' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Formal Charge' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Complexity' placeholder='ex. 212' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Isotope Atom Count' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Defined Atom Stereocenter Count' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Undefined Atom Stereocenter Count' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Defined Bond Stereocenter Count' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Undefined Bond Stereocenter Count' placeholder='ex. 0' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Covalently-Bonded Unit Count' placeholder='ex. 1' />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput label='Compound Is Canonicalized' placeholder='ex. Yes' />
      </DividedGrid>
    </Grid.Container>
  );
}

export default PropertyInput;