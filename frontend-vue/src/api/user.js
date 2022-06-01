import request from '@/utils/request'

export function userLogin(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data: data
  })
}

export function userCode(id) {
  return request({
    url: '/user/code',
    method: 'get',
  })
}

export function userAttendSubmit(data) {
  return request({
    url: '/user/attend',
    method: 'post',
    data: data
  })
}

export function userAttendGet() {
  return request({
    url: '/user/attend',
    method: 'get'
  })
}

/**           用户注册             **/
export function userSignUp(data) {
  return request({
    url: '/user/signup',
    method: 'post',
    data: data
  })
}

export function userList() {
  return request({
    url: '/user/userlist',
    method: 'get'
  })
}

