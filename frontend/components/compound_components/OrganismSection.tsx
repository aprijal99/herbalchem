import {Link, Table} from '@nextui-org/react';
import {SectionContainer} from './util/LayoutUtil';
import {SectionTitle} from './util/TitleUtil';

type OrganismProps = {
  family: string,
  species: string,
  subspecies: string,
  reference: string,
}

const OrganismSection = ({ family, species, subspecies, reference }: OrganismProps) => {
  return (
    <SectionContainer>
      <SectionTitle number='5' title='Organisms' />
      <Table
        lined
        compact
        bordered
        headerLined
        shadow={false}
        css={{ px: '0' }}
        containerCss={{ br: '$xs' }}
        aria-label='Table of organism section'
      >
        <Table.Header>
          <Table.Column>Family</Table.Column>
          <Table.Column>Species</Table.Column>
          <Table.Column>Subspecies</Table.Column>
          <Table.Column>Literature</Table.Column>
        </Table.Header>
        <Table.Body>
          <Table.Row>
            <Table.Cell>{family}</Table.Cell>
            <Table.Cell>{species}</Table.Cell>
            <Table.Cell>{subspecies == null ? '-' : subspecies}</Table.Cell>
            <Table.Cell>
              <Link target='_blank' href={reference} css={{ color: 'black' }}>
                {reference.substring(19)}
              </Link>
            </Table.Cell>
          </Table.Row>
        </Table.Body>
      </Table>
    </SectionContainer>
  );
}

export default OrganismSection;