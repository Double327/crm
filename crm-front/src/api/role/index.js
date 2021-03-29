import request from '@/axios';

export function getRoleList() {
    return request({
        url: '/role/getAll',
        method: 'get'
    })
}
