import {GridRow, SectionContainer, SummaryGridColumnLeft, SummaryGridColumnRight} from './util/LayoutUtil';
import {SectionTitle} from './util/TitleUtil';
import {Container, Spacer, Grid} from '@nextui-org/react';

type SummaryProps = {
  cid: number,
  mf: string,
  synonym: string,
  mw: number,
  ca: string,
  ua: string,
}

const SummarySection = ({ cid, mf, synonym, mw, ca, ua }: SummaryProps) => {
  let createdAt = new Date(Date.parse(ca));
  let updatedAt = new Date(Date.parse(ua));

  return (
    <SectionContainer>
      <SectionTitle number='1' title='Compound Summary' />
      <GridRow border='borderBottom'>
        <SummaryGridColumnLeft>HerbalChem Cid</SummaryGridColumnLeft>
        <Spacer x={1} />
        <SummaryGridColumnRight xs>{cid}</SummaryGridColumnRight>
      </GridRow>

      <GridRow border='borderBottom'>
        <SummaryGridColumnLeft>Molecular Formula</SummaryGridColumnLeft>
        <Spacer x={1} />
        <SummaryGridColumnRight
          xs
          alignItems='alignItemsEnd'
          dangerouslySetInnerHTML={{
            __html: mf.split('')
              .map(ltr => /\d+/.test(ltr) ? '<sub>'+ltr+'</sub>' : ltr)
              .join('')
          }}
        />
      </GridRow>

      <GridRow border='borderBottom'>
        <SummaryGridColumnLeft>Synonym</SummaryGridColumnLeft>
        <Spacer x={1} />
        <SummaryGridColumnRight xs>{synonym}</SummaryGridColumnRight>
      </GridRow>

      <GridRow border='borderBottom'>
        <SummaryGridColumnLeft>Molecular Weight</SummaryGridColumnLeft>
        <Spacer x={1} />
        <SummaryGridColumnRight xs>{mw} g/mol</SummaryGridColumnRight>
      </GridRow>

      <GridRow>
        <SummaryGridColumnLeft>Dates</SummaryGridColumnLeft>
        <Spacer x={1} />
        <SummaryGridColumnRight xs>
          <Container fluid={true} gap={0}>
            <Grid.Container>
              <Grid css={{ width: '110px' }}>Modified</Grid>
              <Grid>Created</Grid>
            </Grid.Container>
            <Grid.Container>
              <Grid css={{ width: '110px' }}>{createdAt.toLocaleDateString()}</Grid>
              <Grid>{updatedAt.toLocaleDateString()}</Grid>
            </Grid.Container>
          </Container>
        </SummaryGridColumnRight>
      </GridRow>
    </SectionContainer>
  );
}

export default SummarySection;