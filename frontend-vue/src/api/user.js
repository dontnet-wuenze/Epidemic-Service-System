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
    data: {
      id: id
    }
  })
}
