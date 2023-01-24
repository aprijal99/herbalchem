import {Card, Container, Grid, Link, Text} from '@nextui-org/react';

const StatisticSection = () => {
  return (
    <Container
      sm
      css={{
        pt: '$xl',
        '@xsMax': {
          px: 'var(--nextui-space-6)',
        },
      }}
    >
      <Grid.Container gap={2} justify='center' css={{ p: '$0' }}>
        <Grid
          xs={6}
          sm={4}
        >
          <Card variant='bordered'>
            <Card.Body css={{ py: '$6' }}>
              <Text
                h2
                weight='light'
                css={{
                  mb: '$0',
                }}
              >
                6000
              </Text>
              <Text>Compounds</Text>
            </Card.Body>
            <Card.Footer css={{ pt: '$0' }}>
              <Link
                color='success'
                href='#'
              >
                Explore more
              </Link>
            </Card.Footer>
          </Card>
        </Grid>
        <Grid
          xs={6}
          sm={4}
        >
          <Card variant='bordered'>
            <Card.Body css={{ py: '$6' }}>
              <Text
                h2
                weight='light'
                css={{
                  mb: '$0'
                }}
              >
                4000
              </Text>
              <Text>Organisms</Text>
            </Card.Body>
            <Card.Footer css={{ pt: '$0' }}>
              <Link
                color='success'
                href='#'
              >
                Explore more
              </Link>
            </Card.Footer>
          </Card>
        </Grid>
        <Grid
          xs={6}
          sm={4}
        >
          <Card variant='bordered'>
            <Card.Body css={{ py: '$6' }}>
              <Text
                h2
                weight='light'
                css={{
                  mb: '$0'
                }}
              >
                5000
              </Text>
              <Text>Literatures</Text>
            </Card.Body>
            <Card.Footer css={{ pt: '$0' }}>
              <Link
                color='success'
                href='#'
              >
                Explore more
              </Link>
            </Card.Footer>
          </Card>
        </Grid>
      </Grid.Container>
    </Container>
  );
}

export default StatisticSection;