import request from '@/utils/request'

// 查询行政区划查询列表
export function listCode(query) {
  return request({
    url: '/system/code/list',
    method: 'get',
    params: query
  })
}

// 查询行政区划查询详细
export function getCode(id) {
  return request({
    url: '/system/code/' + id,
    method: 'get'
  })
}

// // 新增行政区划查询
// export function addCode(data) {
//   return request({
//     url: '/system/code',
//     method: 'post',
//     data: data
//   })
// }
//
// // 修改行政区划查询
// export function updateCode(data) {
//   return request({
//     url: '/system/code',
//     method: 'put',
//     data: data
//   })
// }
//
// // 删除行政区划查询
// export function delCode(id) {
//   return request({
//     url: '/system/code/' + id,
//     method: 'delete'
//   })
// }
