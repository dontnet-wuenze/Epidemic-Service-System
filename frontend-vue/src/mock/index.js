import Mock from 'mockjs'

// 接口地址
Mock.mock('http://localhost:8080/api/user/login', (req) => {
    return {
        token: '3190102297',
        username: '吴恩泽',
        authorization: false
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

Mock.mock('http://localhost:8080/api/sendnotice', 'post', (req, res) => {
    var data = req.body;
    return {
        data: data
    }
})

Mock.mock('http://localhost:8080/api/user/userinfo', 'get', res=> {
    return {
        id: '3190106086',
        name: '刘昌盛',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '1903',
        phone: '19883152043'
    }
})

Mock.mock('http://localhost:8080/api/statistic/unattendlist', 'get', (req, res) => {
    return {
        unattendList: [
            {
                id: '3190102222',
                name: '王小虎',
                grade: '大一',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            },
            {
                id: '3190102222',
                name: '王小虎',
                grade: '大一',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            },
            {
                id: '3190102222',
                name: '王小虎',
                grade: '大一',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            },
            {
                id: '3190102222',
                name: '王小虎',
                grade: '大一',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }
        ]
    }
})

Mock.mock('http://localhost:8080/api/nucleic/appointment', 'post', (req, res) => {
    var data = req.body;
    return {
        success: 1
    }
})

Mock.mock('http://localhost:8080/api/nucleic/appointment', 'get', (req, res) => {
    return {
        form_id: 1234567
    }
})

Mock.mock('http://localhost:8080/api/nucleic/upload', 'post', (req, res) => {
    var data = req.body;
    return {
        success: 1
    }
})

Mock.mock('http://localhost:8080/api/nucleic/result', 'get', (req, res) => {
    return {
        staff_id: '3190101234',
        name: 'ABC',
        user_result: 0,
        result_time: '2022-5-19 14:36:00'
    }
})

Mock.mock('http://localhost:8080/api/user/signup', 'post',(req) => {
    var token = req.header
    return {
        token: token,
    }
})

Mock.mock('http://localhost:8080/api/user/userlist', 'get', (req) => {
    var token = req.header
    return {
        userlist: [
            {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }, {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }, {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }, {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }, {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }, {
                id: '3190102222',
                name: '王小虎',
                department: '计算机科学与技术学院',
                major: '计算机科学与技术',
                class: '计科1901',
                phone: '13888888888'
            }
        ]
    }
})

