import {styled, Text} from '@nextui-org/react';

const TitleContainerFlex = styled('div', {
  display: 'flex',
  justifyContent: 'left',
  alignItems: 'stretch',
})

export const CompoundTitle = ({ title, date }: { title: string, date: string }) => {
  let createdAt = new Date(Date.parse(date));
  const options: Intl.DateTimeFormatOptions = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  };

  return (
    <>
      <Text
        size='$4xl'
        weight='medium'
        css={{
          lh: '$sm',
          pb: '$sm',
          '@xsMin': {
            fs: '$5xl',
          },
        }}
      >
        {title}
      </Text>
      <Text
        css={{
          pb: '$xl',
          color: '$gray800',
        }}
      >
        Published on {createdAt.toLocaleDateString('en-US', options)}
      </Text>
    </>
  );
}

export const SectionTitle = ({ number, title }: { number: string, title: string }) => {
  return (
    <TitleContainerFlex
      css={{
        mb: '$lg',
      }}
    >
      <Text
        weight='medium'
        color='white'
        css={{
          fs: '$2xl',
          ta: 'center',
          bgColor: '$success',
          width: '2em',
          borderBottom: '5px solid $success',
          btrr: '$xs',
          bblr: '$xs',
          btlr: '$xs',
          alignContent: 'center',
          '@xsMin': {
            fs: '$3xl',
          },
        }}
      >
        {number}
      </Text>
      <Text
        weight='medium'
        css={{
          fs: '$2xl',
          px: '$5',
          flexGrow: '1',
          borderBottom: '5px solid $success',
          '@xsMin': {
            fs: '$3xl',
            flexGrow: '0',
          },
        }}
      >
        {title}
      </Text>
    </TitleContainerFlex>
  );
}

export const SectionSubTitle = ({ subTitle }: { subTitle: string }) => {
  return (
    <Text
      weight='medium'
      css={{
        fs: '$xl',
        borderBottom: '3px solid $gray300',
        '@xsMin': {
          fs: '$2xl'
        }
      }}
    >
      {subTitle}
    </Text>
  );
}