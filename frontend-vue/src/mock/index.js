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

Mock.mock('http://localhost:8080/api/user/attend', 'post', (req) => {
    return {
        name: '李白',
        department: "软件工程",
        grade : '本科生',
        code: 1
    }
})

Mock.mock('http://localhost:8080/api/user/attend', 'get', (req, res) => {
    return {
        code: 404,
        status: true,
        id: '3190103333',
        name: '李白',
        campus: '紫金港校区',
        region: '天津市,市辖区,和平区',
        onCampus: true,
        codeStatus: 2,
        fever: true,
        control: true,
        contact: true
    }
})
