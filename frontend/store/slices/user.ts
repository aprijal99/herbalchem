import {createAction, createSlice} from '@reduxjs/toolkit';
import {HYDRATE} from 'next-redux-wrapper';
import {AppState} from '../index';

const APP_HYDRATE = createAction<AppState>(HYDRATE);

export const UserSlice = createSlice({
  name: 'user',
  initialState: {
    data: {},
  },
  reducers: {
    setUserData: (state, action) => {
      state.data = action.payload;
    }
  },
  extraReducers: builder => {
    builder.addCase(APP_HYDRATE, (state, action) => {
      state.data = action.payload.user.data;
    })
  },
});

export const { setUserData } = UserSlice.actions;
export const selectUser = (state: AppState) => state.user;

export default UserSlice.reducer;