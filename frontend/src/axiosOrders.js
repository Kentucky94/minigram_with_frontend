import axios from "axios";
import config from "./config";
import {store} from './index'

const axiosOrders = axios.create({
    baseURL: config.host,
});

axiosOrders.interceptors.request.use(config => {
    try {
        config.headers.ContentType = `application/json`;
        const token = store.getState().session.token;

        if (token) {
            config.headers.Authorization = `Token ${token}`;
        }
    } catch (e) {
        console.log(e);
    }

    return config;
});

export default axiosOrders;