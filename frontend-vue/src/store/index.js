// index.js
import Vue from 'vue';
import Vuex from 'vuex';
import {userValidate} from '@/axios/api.js';
import {userLogin} from '@/api/user.js';

Vue.use(Vuex);

export default new Vuex.Store({
    state: localStorage.getItem('state') ? JSON.parse(localStorage.getItem('state')) : {
        username: '',
        authorization: false
    },
    mutations: {
        setUsername(state, username) {
            state.username = username;
        },
        setAuth(state, authorization) {
            state.authorization = authorization;
        }
    },
    actions: {
        async login({commit}, userdata){
            await userLogin(userdata).then(res=> {
                console.log(res);
                // 登录成功后将接口返回的token保存在本地
                localStorage.setItem('token', res.data.token);
                // 将用户名保存在vuex中
                commit('setUsername', res.data.username);
                commit('setAuth', res.data.authorization);
            })
        },
    }
});
