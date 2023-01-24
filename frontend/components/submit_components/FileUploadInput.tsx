import {Grid} from '@nextui-org/react';
import FormInput from './util/FormInput';
import DividedGrid from './util/DividedGrid';
import {fileInputStyle} from './util/InputStyle';

const FileUploadInput = () => {
  return (
    <Grid.Container gap={2} css={{ px: '0' }}>
      <Grid xs={12}>
        <FormInput label='Compound Name' placeholder='ex. Aspirin' />
      </Grid>
      <DividedGrid col='50%'>
        <FormInput type='file' label='2D Structure (SDF)' css={fileInputStyle} />
      </DividedGrid>
      <DividedGrid col='50%'>
        <FormInput type='file' label='3D Structure (SDF)' css={fileInputStyle} />
      </DividedGrid>
    </Grid.Container>
  );
}

export default FileUploadInput;