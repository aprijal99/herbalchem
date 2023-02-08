import {Container, Link, Text} from '@nextui-org/react';

const AboutSection = () => {
  return (
    <Container
      sm
      css={{
        py: '$xl',
        '@xsMax': {
          px: 'var(--nextui-space-6)',
        },
      }}
    >
      <Text h1 weight='thin' css={{ ta: 'center' }}>What is HerbalChem?</Text>
      <Text size='$lg' css={{ mb: '10px' }}>
        HerbalChem is a collection of compounds from Indonesia herbal plants.
        This database is fully accessible by public. The data are curated from three main
        databases, <Link isExternal target='_blank' color='success' href='http://herbaldb.farmasi.ui.ac.id/v3/'>HerbalDB</Link>
        , <Link isExternal target='_blank' color='success' href='http://www.knapsackfamily.com/knapsack_core/top.php'>KNApSAcK Family</Link>
        , and <Link isExternal target='_blank' color='success' href='https://pubchem.ncbi.nlm.nih.gov/'>PubChem</Link>.
        You can contribute for adding new compounds or any new data for the existing compounds.
      </Text>
      <Text size='$lg'>
        You can also freely <Link color='success' href='/download'>download</Link> all the data deposited in HerbalChem, or
        use the available <Link color='success' href='/api'>API</Link> to create another project.
      </Text>
    </Container>
  );
}

export default AboutSection;
