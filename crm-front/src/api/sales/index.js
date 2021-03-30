import request from '@/axios';


export function findAllUser() {
    return request({
        url: '/SalesPlan/findAllPlans',
        method: 'get',
    })
}
export function start(id) {
    return request({
        url: '/SalesPlan/start/'+id,
        method: 'put',
        data: id
    })
}

export function lose(id) {
    return request({
        url: '/SalesPlan/lose/'+id,
        method: 'put',
        data: id
    })
}
export function success(id) {
    return request({
        url: '/SalesPlan/success/'+id,
        method: 'put',
        data: id
    })
}
