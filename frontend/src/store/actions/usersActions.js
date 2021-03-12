import axiosOrders from "../../axiosOrders";
import {push} from 'connected-react-router';

export const REGISTER_USER_SUCCESS = "REGISTER_USER_SUCCESS";
export const AUTHENTICATION_SUCCESS = "AUTHENTICATION_SUCCESS";



const authenticationSuccess = (user) => ({type: AUTHENTICATION_SUCCESS, payload: {user}});

export const registerUser = userData => {
    return async dispatch => {
        try {
            await axiosOrders.post("/users/register", userData,{headers: {ContentType: "application/json"}});

            dispatch(push('/'));
        } catch (e) {
            console.log(e);
        }
    }
};

export const authenticate = (authenticationDetails) => {
    return async dispatch => {
        try {
            const response = await axiosOrders.post("/users/authenticate", authenticationDetails);

            dispatch(authenticationSuccess(response.data));
            dispatch(push('/'));
        } catch (e) {
            console.log(e);
        }
    }
};