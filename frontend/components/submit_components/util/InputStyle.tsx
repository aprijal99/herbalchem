export const fileInputStyle = {
  'input': {
    height: 'initial',
    my: '0px !important',
    ml: '0px !important',
    pl: '0px',
  },
  'input::file-selector-button': {
    color: 'var(--nextui--inputPlaceholderColor)',
    fontWeight: '$bold',
    bgColor: 'var(--nextui-colors-accents2)',
    border: 'none',
    height: '50px',
    px: '16px',
    mr: '10px',
  },
  '& .nextui-input-wrapper': {
    overflow: 'hidden',
  },
}