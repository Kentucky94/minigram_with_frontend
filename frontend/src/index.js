import React from 'react';
import ReactDOM from 'react-dom';
import {applyMiddleware, combineReducers, compose, createStore} from "redux";
import {Provider} from 'react-redux';
import thunk from "redux-thunk";
import {ConnectedRouter, routerMiddleware, connectRouter} from "connected-react-router";
import {createBrowserHistory} from "history";

import usersReducer from "./store/reducers/usersReducer";
import postsReducer from "./store/reducers/postsReducer";
import {loadFromLocalStorage, localStorageMiddleware} from "./store/localStorage";
import App from './App';

import './index.css';
import reportWebVitals from './reportWebVitals';


const history = createBrowserHistory();
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const reducers = combineReducers({
    router: connectRouter(history),
    posts: postsReducer,
    users: usersReducer,
});

const middleware = [
    thunk,
    localStorageMiddleware,
    routerMiddleware(history),
];

export const store = createStore(reducers, loadFromLocalStorage(), composeEnhancers(applyMiddleware(...middleware)));

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <App />
            </ConnectedRouter>
        </Provider>,
    </React.StrictMode>,
    document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
