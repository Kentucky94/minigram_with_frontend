import {AUTHENTICATION_SUCCESS} from "./actions/usersActions";

const actionsList = [AUTHENTICATION_SUCCESS];

const saveToLocalStorage = state => {
    try {
        const data = JSON.stringify(state);
        localStorage.setItem('state', data);
    } catch (e) {
        console.log('could not save to state');
    }
};

export const loadFromLocalStorage = () => {
    try {
        const data = localStorage.getItem('state');

        if (data === null) {return undefined;}

        console.log('token loaded');
        return JSON.parse(data);
    } catch (e) {
        return undefined;
    }
};

export const localStorageMiddleware = store => next => action => {
    let result = next(action);

    if (actionsList.includes(action.type)) {
        saveToLocalStorage({
            session: {
                token: store.getState().session.token,
            }
        })
    }

    return result;
};