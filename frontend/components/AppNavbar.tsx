import {Link, Navbar} from '@nextui-org/react';
import HerbalChemLogo from './navbar_components/HerbalChemLogo';
import SearchInput from './navbar_components/SearchInput';

const AppNavbar = () => {
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
      <Navbar.Brand>
        <HerbalChemLogo />
      </Navbar.Brand>

      <Navbar.Content hideIn='xs'>
        <Navbar.Item>
          <SearchInput />
        </Navbar.Item>
      </Navbar.Content>

      <Navbar.Content activeColor='success' hideIn='xs' gap='15px'>
        <Navbar.Link href={collapseItems.download}>Download</Navbar.Link>
        <Navbar.Link href={collapseItems.api}>API</Navbar.Link>
        <Navbar.Link isActive href={collapseItems.submit} variant='highlight-solid'>Submit</Navbar.Link>
      </Navbar.Content>

      <Navbar.Collapse
        showIn='xs'
        disableAnimation
        css={{
          'ul': {
            height: '100%',
            overflow: 'hidden',
            '@xsMax': {
              px: 'var(--nextui-space-6)',
            },
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
      <Navbar.Toggle showIn='xs' />
    </Navbar>
  );
}

export default AppNavbar;