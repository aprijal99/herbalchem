import {Input, styled} from '@nextui-org/react';
import {SearchIcon} from './SearchIcon';

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
    <Input
      aria-label='Input file for searching compounds'
      clearable={true}
      contentLeftStyling={false}
      contentLeft={
        <SearchIcon fill='var(--nextui-colors-accents6)' size={16} />
      }
      status='success'
      placeholder='Search Compounds'
      css={cssStyles}
    />
  );
}

export default SearchInput;