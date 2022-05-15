// api.js
import ajax from '@/axios/ajaxRequest.js';
export const userLogin = (username) => ajax.request({url: '/login', method: 'POST', data: {
        username,
    }});
export const userValidate = () => ajax.request({url: '/validate'});
