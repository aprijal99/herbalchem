import {FC} from 'react';
import type { AppProps } from 'next/app';
import {NextUIProvider} from '@nextui-org/react';
import {Provider} from 'react-redux';
import '../styles/globals.css';
import AppLayout from '../components/AppLayout';
import {wrapper} from '../store';

const App: FC<AppProps> = ({ Component, ...rest }) => {
  const { store, props } = wrapper.useWrappedStore(rest);

  return (
    <Provider store={store}>
      <NextUIProvider>
        <AppLayout>
          <Component {...props.pageProps} />
        </AppLayout>
      </NextUIProvider>
    </Provider>
  );
}

export default App;