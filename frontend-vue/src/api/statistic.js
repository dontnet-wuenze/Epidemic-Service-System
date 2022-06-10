import request from '@/utils/request'

export function unattendList() {
    return request({
        url: '/statistic/unattendlist',
        method: 'get',
    })
}

export function attendNum() {
    return request({
        url: '/statistic/attendnum',
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
