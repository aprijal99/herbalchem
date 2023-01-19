import {Container, Grid, styled} from '@nextui-org/react';
import {ReactNode} from 'react';

export const SectionContainer = ({ children }: { children: ReactNode }) => {
  return (
    <Container
      fluid
      gap={0}
      css={{
        mb: '$xl',
      }}
    >
      {children}
    </Container>
  );
}

export const GridRow = styled(Grid.Container, {
  p: '$5',
  variants: {
    border: {
      borderBottom: {
        borderBottom: '1px solid $gray300',
      },
    },
  },
})

export const SummaryGridColumnLeft = styled(Grid, {
  fontWeight: '$semibold',
  color: '$gray900',
  minWidth: '250px',
})

export const SummaryGridColumnRight = styled(Grid, {
  '@xsMax': {
    flexBasis: '100% !important',
    pl: '$5',
    pt: '$5',
  },
  variants: {
    alignItems: {
      alignItemsEnd: {
        alignItems: 'end',
      },
    },
  },
})

export const NameIdentifierGridColumnTitle = styled(Grid, {
  fs: '$lg',
  fontWeight: '$medium',
  '@xsMin': {
    fs: '$xl',
    pl: '$5',
  },
});

export const NameIdentifierGridColumnContent = styled(Grid, {
  pl: '$5',
  pt: '$5',
  '@xsMin': {
    pl: '30px',
  },
});