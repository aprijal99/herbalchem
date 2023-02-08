import {Link, styled, Text} from '@nextui-org/react';

const CustomImg = styled('img', {
  h: '45px',
  mr: '10px',
  '@media (max-width: 770px)': {
    display: 'none',
  },
});

const HerbalChemLogo = () => {
  return (
    <Link href='/'>
      <CustomImg
        src='/images/herbalchem_logo.png'
        alt='HerbalChem Logo'
      />
      <Text
        css={{
          color: '$black',
          fontWeight: '$bold',
          fontSize: '$3xl',
          '&:hover': {
            color: '$black'
          }
        }}
      >
        HerbalChem
      </Text>
    </Link>
  );
}

export default HerbalChemLogo;
