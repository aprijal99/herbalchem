import { Text } from '@nextui-org/react';

const HerbalChemLogo = () => {
  return (
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
  );
}

export default HerbalChemLogo;