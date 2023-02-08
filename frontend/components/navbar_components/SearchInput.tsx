import {Input, styled} from '@nextui-org/react';
import {SearchIcon} from './SearchIcon';
import keyPressEnterEvent from '../../functions/keyPressEnterEvent';

type SearchInputProps = {
  marginBottom?: string,
}

const SearchInput = ({ marginBottom = '0px' }: SearchInputProps) => {
  const cssStyles = {
    w: '100%',
    '& .nextui-input-content--left': {
      h: '100%',
      ml: '$4',
      dflex: 'center',
    },
    mb: marginBottom,
  }

  return (
    <form className='form' method='GET' action='/search'>
      <Input
        name='query'
        aria-label='Input file for searching compounds'
        animated={false}
        clearable={true}
        contentLeftStyling={false}
        contentLeft={
          <SearchIcon fill='var(--nextui-colors-accents6)' size={16} />
        }
        status='success'
        placeholder='Search Compounds'
        onKeyDown={keyPressEnterEvent}
        css={cssStyles}
      />
    </form>
  );
}

export default SearchInput;
