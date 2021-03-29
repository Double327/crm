import request from '@/axios';

export function getOrganizationOption() {
    return request({
        url: '/organization/getAll',
        method: 'get'
    })
}
