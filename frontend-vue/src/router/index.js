import vueRouter from 'vue-router'
import Vue from 'vue';
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
        ]
    }, {
        path:'/login',
        name: 'login',
        component:()=>import('../views/login/index.vue')
    }
];

const route = new vueRouter({
    routes:routeList
})

route.beforeEach((to,from,next)=>{
    // 路由前置守卫
    next()
})
// 导出
export default route;
