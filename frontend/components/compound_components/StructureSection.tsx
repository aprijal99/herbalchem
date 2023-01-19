import {GridRow, SectionContainer} from './util/LayoutUtil';
import {SectionSubTitle, SectionTitle} from './util/TitleUtil';
import {useEffect} from 'react';
import {styled} from '@nextui-org/react';

const Div3DContainer = styled('div', {
  width: '100%',
  height: '300px',
  position: 'relative',
});

const StructureSection = ({ url2d, url3d }: { url2d: string, url3d: string }) => {
  useEffect(() => {
    let draw2DStructure = (url: string) => {
      // Draw 2D Structure
      // @ts-ignore
      jQuery.ajax(url, {
        success: function(sdf: string) {
          // @ts-ignore
          let mol = ChemDoodle.readMOL(sdf);
          mol.scaleToAverageBondLength(24);

          let canvasParent = document.getElementById('canvas2DStructureParent');
          // @ts-ignore
          let canvasParentWidth = canvasParent.offsetWidth - 20;

          // @ts-ignore
          let canvas = new ChemDoodle.TransformCanvas('canvas2DStructure', canvasParentWidth, 300, true);
          canvas.styles.atoms_useJMOLColors = true;
          canvas.styles.bonds_splitColor = false;
          canvas.styles.bonds_width_2D = 3;
          canvas.styles.atoms_display = true;
          canvas.styles.atoms_circles_2D = false;
          canvas.styles.atoms_HBlack_2D = true;
          canvas.styles.bonds_width_2D = .6;
          canvas.styles.bonds_saturationWidthAbs_2D = 5;
          canvas.styles.bonds_hashSpacing_2D = 2.5;
          canvas.styles.atoms_font_size_2D = 15;
          canvas.styles.atoms_displayTerminalCarbonLabels_2D = true;
          canvas.styles.bonds_clearOverlaps_2D = true;

          canvas.loadMolecule(mol);
        }
      });
    }

    draw2DStructure(url2d);

    window.addEventListener('resize', function() {
      draw2DStructure(url2d);
    });

    // Draw 3D Structure
    const createViewer = () => {
      let element = document.getElementById('container3DStructure');
      let config = { backgroundColor: 'white', antialias: true };
      // @ts-ignore
      let viewer = $3Dmol.createViewer( element, config );

      // @ts-ignore
      $3Dmol.get(url3d, function(data){
        viewer.addAsOneMolecule(data, 'sdf');
        viewer.setStyle({},{ stick: {} });
        viewer.zoomTo();
        viewer.render();
      });

      viewer.setStyle({},{ stick: {} });
      viewer.render();
    }

    createViewer();
  }, [url2d, url3d]);

  return (
    <SectionContainer>
      <SectionTitle number='2' title='Structures' />
      <SectionSubTitle subTitle='2D Structure' />
      <GridRow
        id='canvas2DStructureParent'
        css={{
          my: '$5',
          br: '$xs',
          border: 'var(--nextui-borderWeights-normal) solid var(--nextui-colors-border)',
        }}
      >
        <canvas
          id='canvas2DStructure'
          style={{
            border: '0',
            position: 'relative',
          }}
        ></canvas>
      </GridRow>

      <SectionSubTitle subTitle='3D Structure' />
      <GridRow
        css={{
          mt: '$5',
          br: '$xs',
          border: 'var(--nextui-borderWeights-normal) solid var(--nextui-colors-border)',
        }}
      >
        <Div3DContainer id='container3DStructure' />
      </GridRow>
    </SectionContainer>
  );
}

export default StructureSection;