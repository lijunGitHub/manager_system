import request from '@/utils/request'

// 查询监控中心管理列表
export function listCenter(query) {
  return request({
    url: '/system/center/list',
    method: 'get',
    params: query
  })
}

// 查询监控中心管理详细
export function getCenter(id) {
  return request({
    url: '/system/center/' + id,
    method: 'get'
  })
}

// 新增监控中心管理
export function addCenter(data) {
  return request({
    url: '/system/center',
    method: 'post',
    data: data
  })
}

// 修改监控中心管理
export function updateCenter(data) {
  return request({
    url: '/system/center',
    method: 'put',
    data: data
  })
}

// 删除监控中心管理
export function delCenter(id) {
  return request({
    url: '/system/center/' + id,
    method: 'delete'
  })
}


 // 查询所有顶级父级
export function getTopParent() {
  return request({
    url: '/system/center/getTopParent/',
    method: 'get'
  })
}

//根据ID查询所有子集
export function getSubById(id) {
  return request({
    url: '/system/center/getSubById/' +id,
    method: 'get'
  })
}
//根据ID查询所有子父集
export function getParentById(id) {
  return request({
    url: '/system/center/getParentById/' +id,
    method: 'get'
  })
}

//查询所有id和name
export function selectSysMonitorCenterName(query) {
  return request({
    url: '/system/center/selectSysMonitorCenterName',
    method: 'get',
    params:query
  })
}