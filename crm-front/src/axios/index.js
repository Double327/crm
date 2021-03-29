import axios from "axios";

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    timeout: 10000
});

service.interceptors.request.use(
    config => {
        const authorization = localStorage.getItem('authorization')
        if (authorization) {
            config.headers.authorization = authorization
        }
        return config
    },
    err => {
        console.log('err:' + err)
        return Promise.reject(err)
    })


service.interceptors.response.use(res => {
    return res.data;
})

export default service;

