import {Container, Link, Text} from '@nextui-org/react';

const AppFooter = () => {
  return (
    <Container
      lg
      css={{
        '@xsMax': {
          px: 'var(--nextui-space-6)'
        },
        py: '$lg',
      }}
    >
      <Text css={{ ta: 'center' }}>
        Created by <Link color='success' href='https://github.com/aprijal99'>Aprijal Ghiyas Setiawan</Link>
      </Text>
    </Container>
  );
}

export default AppFooter;