import {Input} from '@nextui-org/react';

const FormInput = (
  {
    type = 'text',
    label = '',
    placeholder = '',
    css = {}
  }: {
    type?: string,
    label?: string,
    placeholder?: string,
    css?: {
      [n: string]: any,
    }
  }
) => {
  return (
    <Input
      type={type}
      animated={false}
      shadow={false}
      bordered
      color='success'
      label={label}
      placeholder={placeholder}
      fullWidth
      css={{
        'label': {
          color: '$default',
          fs: '$md',
          p: '0',
        },
        ...css,
      }}
    />
  );
}

export default FormInput;