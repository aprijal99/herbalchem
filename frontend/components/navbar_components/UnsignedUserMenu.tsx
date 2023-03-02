import {Dropdown, Link} from '@nextui-org/react';

const UnsignedUserMenu = () => {
  return (
    <Dropdown.Menu
      aria-label='User menu actions'
      color='success'
    >
      <Dropdown.Item key='login'>
        <Link
          href={`https://${process.env.SITE_NAME}/authorization-server/oauth2/authorize?response_type=code&client_id=nextJsClient&redirect_uri=https://${process.env.SITE_NAME}/login-success&scope=openid profile compound-data-posting compound-file-upload`}
          color='inherit'
          target='_blank'
          css={{
            d: 'block',
            width: '100%',
          }}
        >
          Login
        </Link>
      </Dropdown.Item>
      <Dropdown.Item key='register'>
        <Link
          href={`https://${process.env.SITE_NAME}/authorization-server/signup`}
          color='inherit'
          target='_blank'
        >
          Register
        </Link>
      </Dropdown.Item>
    </Dropdown.Menu>
  );
}

export default UnsignedUserMenu;
