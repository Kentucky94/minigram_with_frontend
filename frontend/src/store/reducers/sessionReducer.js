import {AUTHENTICATION_SUCCESS} from "../actions/sessionActions";

const initialState = {
    token: null
};

const sessionReducer = (state = initialState, action) => {
    switch (action.type) {
        case AUTHENTICATION_SUCCESS:
            return {...state, token: action.payload.token};
        default:
            return state;
    }
};

export default sessionReducer;