import request from '@/utils/request'

export function userCode(id) {
    return request({
      url: '/user/code',
      method: 'get',
    })
}

export function nucleicAppointment(data){
    return request({
        url: '/nucleic/appointment',
        method: 'post',
        data: 'data'
    })
}

export function nucleicUpload(data){
    return request({
        url: '/nucleic/upload',
        method: 'post',
        data: 'data'
    })
}

export function nucleicGetAppointment(){
    return request({
        url: '/nucleic/appointment',
        method: 'get',
    })
}

export function nucleicResult(){
    return request({
        url: '/nucleic/result',
        method: 'get',
    })
}