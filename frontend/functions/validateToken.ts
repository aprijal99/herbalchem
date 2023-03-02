import {GetServerSidePropsContext, PreviewData} from 'next';
import {ParsedUrlQuery} from 'querystring';
import {AppStore} from '../store';
import {setUserData} from '../store/slices/user';

const validateToken = (store: AppStore) => async (context: GetServerSidePropsContext<ParsedUrlQuery, PreviewData>) => {
  const token: string = context.req.cookies['token'] as string;
  let isAuth = false;

  if (token === undefined || token === null) { // return if token is undefined or null
    store.dispatch(setUserData({
      isAuth,
      username: '',
    }));

    return {
      props: {
        isAuth,
      },
    }
  }

  const body: { [n: string]: string } = {
    token,
    client_id: 'nextJsClient',
    client_secret: '@pr1j@l9h1y@s',
  }

  const formBody = Object.keys(body).map((key: string) => encodeURIComponent(key) + '=' + encodeURIComponent(body[key])).join('&');

  const res = await fetch(`http://${process.env.NEXT_PUBLIC_AUTH_SERVER_SERVICE}/authorization-server/oauth2/introspect`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
    },
    body: formBody,
  });

  const data : {
    active: boolean,
    sub: string | undefined, // username
    aud: string[] | undefined,
    nbf: number | undefined,
    scope: string | undefined,
    roles: { [n: string]: string }[] | undefined,
    iss: string | undefined,
    exp: number | undefined,
    iat: number | undefined,
    client_id: string | undefined,
    token_type: string | undefined,
  } = await res.json();

  if (data.active) {
    isAuth = true;
    store.dispatch(setUserData({
      isAuth,
      username: data.sub,
    }));
  } else {
    store.dispatch(setUserData({
      isAuth,
      username: '',
    }));
  }

  return {
    props: {
      isAuth,
    },
  }
}

export default validateToken;
