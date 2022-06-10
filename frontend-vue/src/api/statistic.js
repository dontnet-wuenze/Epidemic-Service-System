import request from '@/utils/request'

export function unattendList() {
    return request({
        url: '/monitor/unattendlist',
        method: 'get',
    })
}

export function attendNum() {
    return request({
        url: '/monitor/attendnum',
        method: 'get',
    })
}

export function sendNotice(data) {
    return request({
        url: '/sendnotice',
        method: 'post',
        data : data
    })
}
