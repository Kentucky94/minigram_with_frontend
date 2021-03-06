import axiosOrders from "../../axiosOrders";

export const REGISTER_USER_SUCCESS = "REGISTER_USER_SUCCESS";
export const AUTHENTICATION_SUCCESS = "AUTHENTICATION_SUCCESS";

const authenticationSuccess = (user) => ({type: AUTHENTICATION_SUCCESS, payload: {user}});



export const registerUser = userData => {
    return async dispatch => {
        const newUser = await axiosOrders.post("/users/register", userData,{headers: {ContentType: "application/json"}});

        console.log(newUser);
    }
};

export const authenticate = (authenticationDetails) => {
    return async dispatch => {
        try {
            const response = await axiosOrders.post("/users/authenticate", authenticationDetails);

            dispatch(authenticationSuccess(response.data))
        } catch (e) {
            console.log(e);
        }
    }
};