import React from 'react';
import ReactDOM from 'react-dom';
import {createStore, combineReducers, applyMiddleware, compose} from "redux";
import {Provider} from 'react-redux';
import thunk from "redux-thunk";
import postsReducer from "./store/reducers/postsReducer";
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import sessionReducer from "./store/reducers/sessionReducer";
import {loadFromLocalStorage, localStorageMiddleware} from "./store/localStorage";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const reducers = combineReducers({
    posts: postsReducer,
    session: sessionReducer
});

const middleware = [
    thunk,
    localStorageMiddleware
];

export const store = createStore(reducers, loadFromLocalStorage(), composeEnhancers(applyMiddleware(...middleware)));

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
