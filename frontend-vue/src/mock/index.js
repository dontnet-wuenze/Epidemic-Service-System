import Mock from 'mockjs'

// 接口地址
Mock.mock('http://localhost:8080/api/user/login', (req) => {
    return {
        token: 'wuenze',
    }
})

Mock.mock('http://localhost:8080/api/user/code', (req) => {
    return {
        name: '李白',
        department: "软件工程",
        grade : '本科生',
        code: 1
    }
})
