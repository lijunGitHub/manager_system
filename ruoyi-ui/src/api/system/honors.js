import request from '@/utils/request'

// 查询安全荣誉管理列表
export function listHonors(query) {
  return request({
    url: '/system/honors/list',
    method: 'get',
    params: query
  })
}

// 查询安全荣誉管理详细
export function getHonors(id) {
  return request({
    url: '/system/honors/' + id,
    method: 'get'
  })
}

// 新增安全荣誉管理
export function addHonors(data) {
  return request({
    url: '/system/honors',
    method: 'post',
    data: data
  })
}

// 修改安全荣誉管理
export function updateHonors(data) {
  return request({
    url: '/system/honors',
    method: 'put',
    data: data
  })
}

// 删除安全荣誉管理
export function delHonors(id) {
  return request({
    url: '/system/honors/' + id,
    method: 'delete'
  })
}
