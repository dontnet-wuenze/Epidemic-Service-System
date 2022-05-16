import Mock from 'mockjs'

// 接口地址
Mock.mock('http://localhost:8080/api/user/login', (req) => {
    return {
        token: 'wuenze',
    }
})
