import axios from "axios";
import config from "./config";
import {store} from './index'

const axiosOrders = axios.create({
    baseURL: config.host,
});

axiosOrders.interceptors.request.use(config => {
    try {
        config.headers.ContentType = 'application/json';
        const user = store.getState().users.user;

        if (user) {
            config.headers.Authorization = `Token ${user.token}`;
            // config.headers.Authorization = `Token faketoken`;
        }
    } catch (e) {
        console.log(e);
    }

    return config;
});

export default axiosOrders;