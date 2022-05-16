import vueRouter from 'vue-router'
import Vue from 'vue';
import {Message} from "element-ui";
import store from '@/store'

Vue.use(vueRouter)

// 引入组件
const routeList=[
    {
        path:'/',
        //component:()=>import('../views/indexPage/index.vue')
        redirect: '/index'
    }, {
        path:'/',
        name: 'header',
        meta: {
            title: '首页头部'
        },
        component:()=>import('../views/heaader/header.vue'),
        children:[
            {
                path:'/index',
                name: 'index',
                meta: {
                    title: "首页"
                },
                component:()=>import('../views/indexPage/index.vue')
            },

            // 核酸检测模块
            {
                path:'/nucleic/appointment',
                name: 'nucleicAppointment',
                meta: {
                    title: "核酸检测预约"
                },
                component:()=>import('../views/nucleic/appointment.vue')
            },
            {
                path:'/nucleic/result',
                name: 'nucleicResult',
                meta: {
                    title: "核酸检测结果"
                },
                component:()=>import('../views/nucleic/result.vue')
            },
            {
                path:'/nucleic/upload',
                name: 'nucleicUpload',
                meta: {
                    title: "核酸结果上传"
                },
                component:()=>import('../views/nucleic/upload.vue')
            },

            // 审批交互模块
            {
                path: '/approval/Student_Leave_Report',
                name: 'Student_Leave_Report',
                meta: {
                    title: "学生离校报备"
                },
                component:()=>import('../views/approval/Student_Leave_Report.vue')
            },

            // 健康打卡模块
            {
                path: '/health/passcode',
                name: 'healthPasscode',
                meta: {
                    title: "通行码"
                },
                component:()=>import('../views/health/passcode.vue')
            },
            {
                path: '/health/statistic',
                name: 'healthStatistic',
                meta: {
                    title: "打卡统计"
                },
                component:()=>import('../views/health/statistic.vue')
            },
            {
                path: '/health/attend',
                name: 'healthAttend',
                meta: {
                    title: "健康打卡"
                },
                component:()=>import('../views/health/attend.vue')
            },
            // 疫情监控模块
            {
                path: '/monitor/whole_school',
                name: 'wholeschool',
                meta: {
                    title: "全校核酸检测扫码统计"
                },
                component:()=>import('../views/monitor/whole_school.vue')
            },
            {
                path: '/monitor/Undergraduate',
                name: 'Undergraduate',
                meta: {
                    title: "本科生核酸情况统计"
                },
                component:()=>import('../views/monitor/Undergraduate.vue')
            },
            {
                path: '/monitor/in_school',
                name: 'in_school',
                meta: {
                    title: "在校人数分析"
                },
                component:()=>import('../views/monitor/in_school.vue')
            },

            // 登录页面
            {
                path:'/login',
                name: 'login',
                component:()=>import('../views/login/index.vue')
            }
        ]
    },
];

const route = new vueRouter({
    routes:routeList
})

// 无需登录可以跳转的页面
const whiteList = ['/', '/index', '/login', '/404', '/401', '/403', '/500', '/register', '/reset', '/reset/:token', '/reset/:token/:email'];

route.beforeEach((to,from,next)=>{
    let localToken = localStorage.getItem('token')
    console.log('localtoken before router', localToken)
    // 白名单直接跳转
    if(whiteList.indexOf(to.path)>-1) {
        if(localToken && to.path === '/login') {
            Message('已登录,自动跳转')
            next('/index')
        } else {
            next()
        }
    } else if(localToken) {
        next()
    } else {
        Message({
            showClose: true,
            message: '请先登录',
            type: 'warning'
        });
        next('/login')
    }
})
// 导出
export default route;
