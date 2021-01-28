import axios from "axios";
import config from "./config";

const axiosOrders = axios.create({
    baseURL: config.host,
});

export default axiosOrders;