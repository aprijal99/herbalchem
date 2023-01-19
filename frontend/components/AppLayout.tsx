import React from 'react';
import AppFooter from './AppFooter';
import AppNavbar from './AppNavbar';
import Head from 'next/head';

type LayoutProps = {
  children: JSX.Element
}

const AppLayout = ({ children }: LayoutProps) => {
  return (
    <>
      <Head>
        <title>HerbalChem</title>
      </Head>
      <AppNavbar />
      {children}
      <AppFooter />
    </>
  );
}

export default AppLayout;