import {Link, Navbar, Dropdown, Avatar, Text} from '@nextui-org/react';
import HerbalChemLogo from './navbar_components/HerbalChemLogo';
import SearchInput from './navbar_components/SearchInput';
import {useSelector} from 'react-redux';
import {selectUser} from '../store/slices/user';
import {UserIcon} from './navbar_components/UserIcon';
import SignedUserMenu from './navbar_components/SignedUserMenu';
import UnsignedUserMenu from './navbar_components/UnsignedUserMenu';

const AppNavbar = () => {
  const user = useSelector(selectUser) as {
    data: {
      isAuth: boolean,
      username: string,
    }
  };

  const collapseItems = {
    download: '/download',
    api: '/herbal-chem-api',
    submit: '/submit'
  }

  return (
    <Navbar
      shouldHideOnScroll
      variant='sticky'
      css={{
        '& .nextui-navbar-container': {
          '@xsMax': {
            borderBottom: '1px solid var(--nextui--navbarBorderColor)',
          },
        },
      }}
    >
      <Navbar.Toggle
        css={{
          fb: '33.33333%',
          '@media (min-width: 770px)': {
            display: 'none',
          },
        }}
      />

      <Navbar.Brand
        css={{
          fb: '33.33333%',
        }}
      >
        <HerbalChemLogo />
      </Navbar.Brand>

      <Navbar.Content
        css={{
          '@media (max-width: 770px)': {
            display: 'none',
          },
        }}
      >
        <Navbar.Item>
          <SearchInput />
        </Navbar.Item>
      </Navbar.Content>

      <Navbar.Content
        activeColor='success'
        gap='15px'
        css={{
          fb: '33.33333%',
          jc: 'end',
        }}
      >
        <Navbar.Link
          href={collapseItems.download}
          css={{
            '&:hover': {
              color: 'var(--nextui-colors-successLightContrast)',
            },
            '@media (max-width: 770px)': {
              display: 'none',
            },
          }}
        >
          Download
        </Navbar.Link>
        <Navbar.Link
          href={collapseItems.api}
          css={{
            '&:hover': {
              color: 'var(--nextui-colors-successLightContrast)',
            },
            '@media (max-width: 770px)': {
              display: 'none',
            },
          }}
        >
          API
        </Navbar.Link>
        <Navbar.Link
          href={collapseItems.submit}
          css={{
            '&:hover': {
              color: 'var(--nextui-colors-successLightContrast)',
            },
            '@media (max-width: 770px)': {
              display: 'none',
            },
          }}
        >
          Submit
        </Navbar.Link>

        <Dropdown placement='bottom-right'>
          <Navbar.Item>
            <Dropdown.Trigger>
              <Avatar
                bordered
                as='button'
                color='success'
                size='md'
                icon={<UserIcon />}
              />
            </Dropdown.Trigger>
          </Navbar.Item>
          {user.data.isAuth ? <SignedUserMenu username={user.data.username} /> : <UnsignedUserMenu />}
        </Dropdown>
      </Navbar.Content>

      <Navbar.Collapse
        disableAnimation
        css={{
          'ul': {
            height: '100%',
            overflow: 'hidden',
            '@xsMax': {
              px: 'var(--nextui-space-6)',
            },
          },
          '@media (min-width: 770px)': {
            display: 'none',
          },
        }}
      >
        <SearchInput marginBottom='$lg' />
        {Object.entries(collapseItems).map((arr, idx) => (
          <Navbar.CollapseItem
            key={idx + 1}
            activeColor='success'
            isActive={arr[0] === 'submit'}
            css={{
              color: arr[0] === 'submit' ? '$success' : '',
            }}
          >
            <Link
              color='inherit'
              href={arr[1]}
              css={{
                minWidth: '100%',
                fs: '$base',
                ta: 'center',
                display: 'inline',
              }}
            >
              {arr[0][0].toUpperCase() + arr[0].slice(1, arr[0].length)}
            </Link>
          </Navbar.CollapseItem>
        ))}
      </Navbar.Collapse>

    </Navbar>
  );
}

export default AppNavbar;
