import vueRouter from 'vue-router'
import Vue from 'vue';
Vue.use(vueRouter)

// 引入组件
const routeList=[
    {
        path:'/',
        component:()=>import('../views/indexPage/index.vue')
    },
    {
        path:'/login',
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