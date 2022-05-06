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
            {
                path:'/nucleic/result',
                name: 'nucleicResult',
                meta: {
                    title: "核酸检测结果"
                },
                component:()=>import('../views/nucleic/result.vue')
            }
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
