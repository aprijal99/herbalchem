import {Container, Grid, Text} from '@nextui-org/react';
import {GetServerSideProps, NextPage} from 'next';
import {wrapper} from '../store';
import LoginRegister from '../components/submit_components/LoginRegister';
import FileUploadInput from '../components/submit_components/FileUploadInput';
import NameIdentifierInput from '../components/submit_components/NameIdentifierInput';
import PropertyInput from '../components/submit_components/PropertyInput';
import validateToken from '../functions/validateToken';

interface Props {
  isAuth: boolean,
}

const Submit: NextPage<Props> = ({ isAuth }) => {
  return (
    <Container
      sm
      css={{
        py: '$xl',
        '@xsMax': {
          px: 'var(--nextui-space-6)',
        },
      }}
    >
      <Text h2 css={{ pb: '0' }}>Submit Data</Text>

      {isAuth ?
        (<form>
          <FileUploadInput />
          <NameIdentifierInput />
          <PropertyInput />
        </form>) : (<LoginRegister />)
      }
    </Container>
  );
}

export const getServerSideProps: GetServerSideProps = wrapper.getServerSideProps(validateToken);

export default Submit;
