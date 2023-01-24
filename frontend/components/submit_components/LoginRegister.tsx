import {Button, Card, Grid, Link, Text} from '@nextui-org/react';

const LoginRegister = () => {
  return (
    <>
      <Text css={{ mb: '$lg' }}>
        You need to login or register a new account in order to submit data to HerbalChem.
        You must agree to a data submission policy when you create an account.
        We look forward to receiving your data
      </Text>
      <Grid.Container justify='center'>
        <Grid
          css={{
            w: '100%',
            '@xsMin': {
              maxW: '400px',
            },
          }}
        >
          <Card variant='bordered'>
            <Card.Body
              css={{
                p: '$10',
              }}
            >
              <Button
                color='success'
                as='a'
                href='http://localhost:8921/oauth2/authorize?response_type=code&client_id=nextJsClient&redirect_uri=http://127.0.0.1:3000/login-success&scope=openid profile compound-data-posting compound-file-upload'
                target='_blank'
                css={{
                  mb: '$md',
                  fs: '$md',
                  fontWeight: '$bold',
                }}
              >
                Login
              </Button>
              <Button
                color='success'
                as='a'
                href='#'
                target='_black'
                css={{
                  fs: '$md',
                  fontWeight: '$bold',
                }}
              >
                Register
              </Button>
            </Card.Body>
          </Card>
        </Grid>
      </Grid.Container>
    </>
  );
}

export default LoginRegister;