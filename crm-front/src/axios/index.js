import axios from "axios";

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    timeout: 10000
});



service.interceptors.response.use(res => {
    console.log(res.data);
    return res.data;
})

export default service;

