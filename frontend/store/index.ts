import {configureStore, ThunkAction} from '@reduxjs/toolkit';
import {createWrapper} from 'next-redux-wrapper';
import {Action} from 'redux';
import userReducer from './slices/user';

const makeStore = () => configureStore({ // https://www.youtube.com/watch?v=pstQ7xyg8p8
  reducer: {
    user: userReducer,
  },
});

export type AppStore = ReturnType<typeof makeStore>;
export type AppState = ReturnType<AppStore['getState']>;
export type AppThunk<ReturnType = void> = ThunkAction<ReturnType, AppState, unknown, Action>;

export const wrapper = createWrapper<AppStore>(makeStore);