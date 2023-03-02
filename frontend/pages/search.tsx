import {GetServerSideProps, NextPage} from 'next';
import {composeServerSideProps} from 'next-composition';
import {Card, Container, Grid, Link, Text} from '@nextui-org/react';
import {wrapper} from '../store';
import validateToken from '../functions/validateToken';

type HitsType = {
  _index: string,
  _type: string,
  _id: string,
  _score: number,
  _source: {
    _class: string,
    herbalChemCid: number,
    compoundName: string,
    synonym: string,
    molecularFormula: string,
    molecularWeight: number,
    iupacName: string,
    canonicalSmiles: string,
    inchlKey: string,
    inchl: string,
    structure2DUrl: string,
  },
}[];

type PropsType = {
  data: {
    total: number,
    searchResult: HitsType | [],
  },
}

const Result = ({ data }: PropsType) => {
  const options: Intl.DateTimeFormatOptions = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  };

  return (
    <Grid.Container gap={2} css={{ p: '0' }}>
      {data.searchResult.map((res, idx) => (
        <Grid xs={12} key={idx}>
          <Card
            variant='bordered'
            css={{
              br: '0',
            }}
          >
            <Card.Body
              css={{
                p: '$7',
              }}
            >
              <Link href={`/compounds/${res._id}`}>
                <Text h4 color='success'>{res._source.compoundName}; {res._source.synonym}</Text>
              </Link>
              <Text><span style={{ fontWeight: 'bold' }}>HerbalChem CID:</span> {res._source.herbalChemCid}</Text>
              <Text>
                <span style={{ fontWeight: 'bold' }}>MF:</span> {res._source.molecularFormula}
                <span style={{ fontWeight: 'bold', marginLeft: '15px' }}>MW:</span> {res._source.molecularWeight} g/mol
              </Text>
              <Text><span style={{ fontWeight: 'bold' }}>IUPAC Name:</span> {res._source.iupacName}</Text>
              <Text><span style={{ fontWeight: 'bold' }}>Canonical SMILES:</span> {res._source.canonicalSmiles}</Text>
              <Text><span style={{ fontWeight: 'bold' }}>InChl Key:</span> {res._source.inchlKey}</Text>
              <Text><span style={{ fontWeight: 'bold' }}>InChl:</span> {res._source.inchl}</Text>
            </Card.Body>
          </Card>
        </Grid>
      ))}
    </Grid.Container>
  );
}

const Search: NextPage<PropsType> = ({ data }) => {
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
      <Text h2>Search Result</Text>

      {data.total === 0 ? <div>0 result found</div> : <Result data={data} />}
    </Container>
  );
}

const withToken: GetServerSideProps = wrapper.getServerSideProps(validateToken);

const withSearchResult: GetServerSideProps = async (context) => {
  const { query } = context.query;

  const res = await fetch(`http://${process.env.NEXT_PUBLIC_ELASTICSEARCH_SERVICE}/compound_summary/_search`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      'query': {
        'query_string': {
          'query': query,
        }
      }
    }),
  });

  const data: {
    took: number,
    timed_out: boolean,
    _shards: { [n: string]: number },
    hits: {
      total: {
        value: number,
        relation: string,
      },
      max_score: number,
      hits: HitsType,
    },
  } = await res.json();

  let props: PropsType = {
    data: {
      total: 0,
      searchResult: [],
    }
  };

  if (data.hits.total.value > 0) {
    props = {
      data: {
        total: data.hits.total.value,
        searchResult: data.hits.hits,
      }
    }
  }

  return {
    props,
  }
}

export const getServerSideProps = composeServerSideProps({
  use: [withToken, withSearchResult],
})

export default Search;
