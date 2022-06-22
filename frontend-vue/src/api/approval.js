import request from '@/utils/request'

export function get_apply_id() {
    return request({
      url: 'apply/get_apply_id',
      method: 'get'
    })
  }

export function stu_leave_submit(data) {
  return request({
    url: 'apply/stu_leave_form',
    method: 'post',
    data: data
  })
}

export function staff_leave_submit(data) {
  return request({
    url: '/user/staff_leave_form',
    method: 'post',
    data: data
  })
}

export function stu_passphrase_submit(data) {
    return request({
      url: '/apply/stu_passphrase_form',
      method: 'post',
      data: data
    })
  }

export function staff_passphrase_submit(data) {
  return request({
    url: '/apply/staff_passphrase_form',
    method: 'post',
    data: data
  })
}

export function get_application_log() {
  return request({
    url: '/apply/get_application_log',
    method: 'get'
  })
}

export function get_form_approval_list() {
  return request({
    url: '/apply/get_form_approval_list',
    method: 'get'
  })
}

export function get_stu_passphrase_form(id) {
  return request({
    url: '/apply/get_stu_passphrase_form',
    method: 'post',
    data: id
  })
}

export function get_staff_passphrase_form(id) {
  return request({
    url: '/apply/get_staff_passphrase_form',
    method: 'post',
    data: id
  })
}
