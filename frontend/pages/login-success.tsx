import {Container, Text} from '@nextui-org/react';
import {GetServerSideProps} from 'next';
import {ParsedUrlQuery} from 'querystring';
import cookie from 'cookie';

const LoginSuccess = () => {
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
      <Text h1>Login Success</Text>
    </Container>
  );
}

interface CodeParams extends ParsedUrlQuery {
  code: string,
}

export const getServerSideProps: GetServerSideProps = async (context) => {
  const { code } = context.query as CodeParams;

  const body: { [n: string]: string } = {
    grant_type: 'authorization_code',
    client_id: 'nextJsClient',
    client_secret: '@pr1j@l9h1y@s',
    code: code,
    redirect_uri: 'https://herbalchem.site/login-success',
  }

  const formBody = Object.keys(body).map((key: string) => encodeURIComponent(key) + '=' + encodeURIComponent(body[key])).join('&');

  const res = await fetch(`http://${process.env.NEXT_PUBLIC_AUTH_SERVER_SERVICE}/authorization-server/oauth2/token`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
    },
    body: formBody,
  });

  const data : {
    access_token: string,
    refresh_token: string,
    scope: string,
    id_token: string,
    token_type: string,
    expires_in: number,
  } = await res.json();

  // Set HTTP-only Cookie
  context.res.setHeader('Set-Cookie', cookie.serialize('token', data.access_token, {
    httpOnly: true,
    secure: true, // secure only work over https
    maxAge: 60 * 30,
    sameSite: 'lax',
    path: '/',
  }))

  return {
    props: {
      data: {},
    },
    redirect: {
      statusCode: 302,
      destination: '/',
    },
  };
}

export default LoginSuccess
