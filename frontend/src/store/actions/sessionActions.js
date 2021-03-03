import axiosOrders from "../../axiosOrders";

export const AUTHENTICATION_SUCCESS = "AUTHENTICATION_SUCCESS";

const authenticationSuccess = (token) => ({type: AUTHENTICATION_SUCCESS, payload: {token}});

export const authenticate = (authenticationDetails) => {
    return async dispatch => {
        try {
            const response = await axiosOrders.post("/authenticate", authenticationDetails);

            dispatch(authenticationSuccess(response.data.jwt))
        } catch (e) {
            console.log(e);
        }
    }
};