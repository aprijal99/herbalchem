import {Dropdown, Text} from '@nextui-org/react';

const SignedUserMenu = ({ username }: { username: string }) => {
  return (
    <Dropdown.Menu
      aria-label='User menu actions'
      color='success'
    >
      <Dropdown.Item key='profile'>
        <Text color='inherit'>Sign in as <span style={{ fontWeight: 'bold' }}>{username}</span></Text>
      </Dropdown.Item>
      <Dropdown.Item key='help_and_feedback' withDivider>Help & Feedback</Dropdown.Item>
      <Dropdown.Item key='setting'>Setting</Dropdown.Item>
      <Dropdown.Item key='logout' withDivider color='error'>Log out</Dropdown.Item>
    </Dropdown.Menu>
  );
}

export default SignedUserMenu;