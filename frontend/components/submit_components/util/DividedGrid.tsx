import {ReactNode} from 'react';
import {Grid} from '@nextui-org/react';

const DividedGrid = ({ children, col }: { children: ReactNode, col: string }) => {
  return (
    <Grid
      css={{
        flexBasis: '100%',
        '@xsMin': {
          flexBasis: col,
        },
      }}
    >
      {children}
    </Grid>
  );
}

export default DividedGrid;