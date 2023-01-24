import React from 'react';
import Document, { Html, Head, Main, NextScript, DocumentContext} from 'next/document';
import {CssBaseline} from '@nextui-org/react';

class MyDocument extends Document {
  static async getInitialProps(ctx: DocumentContext) {
    const initialProps = await Document.getInitialProps(ctx);
    return {
      ...initialProps,
      styles: React.Children.toArray([initialProps.styles])
    };
  }

  render() {
    return (
      <Html lang="en">
        <Head>
          {CssBaseline.flush()}

          <script src='/js/ChemDoodleWeb.js'></script>
        </Head>
        <body>
          <Main />
          <NextScript />

          <script src='/js/jquery-3.6.3.min.js'></script>
          <script src='/js/3Dmol-min.js'></script>
        </body>
      </Html>
    );
  }
}

export default MyDocument;
