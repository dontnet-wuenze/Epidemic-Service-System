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

Mock.mock('http://localhost:8080/api/apply/get_apply_id', 'get', (req,res) => {
  return {
    id: "1145141919810",
    name: "Lingsing",
    staff_id: "3210205257"
  }
})

Mock.mock('http://localhost:8080/api/apply/get_application_log', 'get', (req,res) => {
  return {
    tabledata: [{
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-27 9:12:35',
      application_type: '离校申请',
      audit_status: '通过'
    }, {
      applicant: '张三',
      application_time: '2020-6-2 11:42:54',
      application_type: '返校申请',
      audit_status: '辅导员审核',
    }, {
      applicant: '张三',
      application_time: '2020-6-7 13:43:46',
      application_type: '返校申请',
      audit_status: '通过'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核',
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核',
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }, {
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '离校申请',
      audit_status: '辅导员审核'
    }]
  }
})

Mock.mock('http://localhost:8080/api/apply/get_form_approval_list', 'get', (req,res) => {
  return {
    tabledata: [{
      id: '114514',
      applicant: '张三',
      application_time: '2020-5-23 12:05:07',
      application_type: '学生通行码申请',
      approval_status: '等待审批'
    }, {
      id: '114514',
      applicant: '李四',
      application_time: '2020-5-23 12:05:05',
      application_type: '学生通行码申请',
      approval_status: '已完成审批'
    }, {
      id: '114514',
      applicant: '王五',
      application_time: '2020-5-23 12:05:07',
      application_type: '教职工通行码申请',
      approval_status: '等待审批'
    }, {
      id: '114514',
      applicant: '赵六',
      application_time: '2020-5-23 12:05:07',
      application_type: '教职工通行码申请',
      approval_status: '已完成审批'
    }]
  }
})

Mock.mock('http://localhost:8080/api/apply/get_stu_passphrase_form', 'get', (req,res) => {
  return {
    id: '2564798',
    date: '2022-6-8',
    name: 'lingsing',
    st_id: '319465789',
    telenum: '457895621',
    email: '123@qq.com',
    institute: '光华法学院',
    campus: '紫金港校区',
    in_residence: 'true',
    address: '1',
    parent_name: '1',
    parent_tele: '1',
    fever: 'false',
    contact_patient: 'true',
    abroad: 'false',
    contact_abroad: 'false',
    roommate: 'true',
    macao: 'false',
    high_risk: 'false',
    medium_risk: 'false',
    control_area: 'false',
    prevent_area: 'false',
    certificate: '33015468795168',
    health_code: '绿码',
    route_star: 'false',
    vaccine: 'false',
    remark: '',
    location:['山西省','太原市','市辖区'],
    return_date: '2022-6-12',
    return_period: '上午',
    vehicle_kind: 'others',
    vehicle: '自行车',
    arrive_date: '',
    arrive_time: '',
    transport_num: '',
    arrive_port: '',
    promise: 'true'
  }
})