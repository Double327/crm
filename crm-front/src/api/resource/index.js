import request from '@/axios';

export function getResource() {
    return request({
        url: '/resource/getResource',
        method: 'get'
    })
}
