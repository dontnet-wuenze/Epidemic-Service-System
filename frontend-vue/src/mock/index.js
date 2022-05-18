import Mock from 'mockjs'

// 接口地址
Mock.mock('http://localhost:8080/api/user/login', (req) => {
    return {
        token: 'wuenze',
    }
})

Mock.mock('http://localhost:8080/api/user/code', (req) => {
    return {
        name: '李博日',
        department: "计算机科学与技术",
        grade : '研究生',
        code: 2
    }
})
