import {AUTHENTICATION_SUCCESS} from "../actions/usersActions";

const initialState = {
    user: null
};

const sessionReducer = (state = initialState, action) => {
    switch (action.type) {
        case AUTHENTICATION_SUCCESS:
            return {...state, user: action.payload.user};
        default:
            return state;
    }
};

export default sessionReducer;