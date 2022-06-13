// ajaxResquest.js
import axios from 'axios';

class ajaxRequest {
    constructor(){
        // 根据当前模式自动切换baseURL
        this.baseURL = process.env.NODE_ENV === 'development' ? 'http://localhost:3000' : '/';
        this.timeout = 5000; // 设置请求超时为5s
    }
    request(config){
        const instance = axios.create({
            baseURL: this.baseURL,
            timeout: this.timeout,
        });

        instance.interceptor.request.use((config) => {
            // 将保存在本地的token添加到每次请求的请求头中
            // 这样就可以实现在请求时顺带附加用户的校验信息的需求
            config.headers.Authorization = localStorage.getItem('token');
            return config;
        }, (err) => {
            return Promise.reject(err);
        });
        instance.interceptor.response.use(response => {
            return response.data;
        }, (err) => {
            Promise.reject(err);
        });

        // 将使用request时候需要的参数也添加到instance中
        return instance(config);
    }
}

export default new ajaxRequest();
