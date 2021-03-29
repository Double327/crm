import request from '../axios'
/*
* 登录请求
* */
export function getLogin (url, params) {
  return request({
    url: `${url}`,
    method: 'post',
    data: params
  })
}
/*
* 获取验证码
* */
export function getCode () {
  return request({
    url: '/code',
    method: 'get'
  })
}

/*
*
* 注销*/
export function doLoginOut (url) {
  return request({
    url: `${url}`,
    method: 'get'
  })
}
/*
* 文件上传
* */
// export function doFile (url,params) {
//   return request({
//     header: {
//       'Content-Type': 'multipart/form-data'
//     },
//     url: `${url}`,
//     method: 'post',
//     data: {
//       "file": params
//     }
//   })

