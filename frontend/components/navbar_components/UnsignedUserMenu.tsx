import {Dropdown, Text} from '@nextui-org/react';

const UnsignedUserMenu = () => {
  return (
    <Dropdown.Menu
      aria-label='User menu actions'
      color='success'
    >
      <Dropdown.Item key='login'>Login</Dropdown.Item>
      <Dropdown.Item key='register'>Register</Dropdown.Item>
    </Dropdown.Menu>
  );
}

export default UnsignedUserMenu;