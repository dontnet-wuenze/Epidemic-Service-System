// index.js
import Vue from 'vue';
import Vuex from 'vuex';
import {userLogin, userValidate} from '@/axios/api.js';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        username: '',
    },
    mutations: {
        setUsername(state, username){
            state.username = username;
        }
    },
    actions: {
        async login({commit}, username){
            const res = await userLogin(username);
            if (res.code === 1) { // 登录失败
                return Promise.reject(res);
            }
            // 登录成功后将接口返回的token保存在本地
            localStorage.setItem('token', res.token);
            // 将用户名保存在vuex中
            commit('setUsername', username);
        },
        async validate({commit}) {
            // 调用userValidate时，会将
            const res = await userValidate();
            if (res.code === 1) { // 此时用户校验失败
                return Promise.reject(res);
            }
            // 如果校验成功，重新保存token和username
            localStorage.setItem('token', res.token);
            commit('setUsername', res.username);
        }
    }
});
