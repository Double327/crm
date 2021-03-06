import request from '@/axios';

export function saveUser(user) {
    return request({
        url: '/user/',
        method: 'post',
        data: user
    })
}

export function findById(id) {
    return request({
        url: '/user/' + id,
        method: 'get'
    })
}

export function findAllUser() {
    return request({
        url: '/user/findAll',
        method: 'get'
    })
}

export function findAllSales() {
    return request({
        url: '/user/findSalesAll',
        method: 'get'
    })
}


export function changeStatus(user) {
    return request({
        url: '/user/changeStatus',
        method: 'put',
        params: user
    })
}

export function deleteUser(id) {
    return request({
        url: '/user/' + id,
        method: 'delete'
    })
}
