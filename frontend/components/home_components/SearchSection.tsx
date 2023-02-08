import {Container, Input, Text} from '@nextui-org/react';
import keyPressEnterEvent from '../../functions/keyPressEnterEvent';
import {SearchIcon} from '../navbar_components/SearchIcon';

const SearchSection = () => {
  return (
    <Container
      sm
      css={{
        pt: '$3xl',
        pb: '$xl',
        '@xsMax': {
          px: 'var(--nextui-space-6)',
        },
      }}
    >
      <Text
        h1
        weight='medium'
        css={{
          ta: 'center'
        }}
      >
        Explore Compounds
      </Text>
      <Text
        size='$xl'
        weight='light'
        css={{
          ta: 'center'
        }}
      >
        Database of Compounds from Indonesia Herbal Plants
      </Text>
      <form className='form' method='GET' action='/search'>
        <Input
          name='query'
          aria-label='Input file for searching compounds'
          clearable={true}
          size='xl'
          animated={false}
          shadow={false}
          contentRight={
            <SearchIcon fill='var(--nextui-colors-accents6)' size={16} />
          }
          contentRightStyling={false}
          status='success'
          placeholder='Search Compound'
          onKeyDown={keyPressEnterEvent}
          css={{
            w: '100%',
            pt: '$sm',
            '& .nextui-input-content--right': {
              h: '100%',
              mr: '$8',
              ml: '$5',
              dflex: 'center',
            },
            'input': {
              ml: '$8 !important',
            },
          }}
        />
      </form>
    </Container>
  );
}

export default SearchSection;
