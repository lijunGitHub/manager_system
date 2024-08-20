package com.ruoyi.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.SysMonitorCenter;

/**
 * 监控中心管理Service接口
 * 
 * @author lijun
 * @date 2024-08-05
 */
public interface ISysMonitorCenterService 
{
    /**
     * 查询监控中心管理
     * 
     * @param id 监控中心管理主键
     * @return 监控中心管理
     */
    public SysMonitorCenter selectSysMonitorCenterById(Long id);


    /**
     * 根据id 查询所有上级
     * @param id 监控中心管理主键
     * @return 监控中心管理集合
     */
    public JSONObject selectParentSysMonitorCenterById(Long id);



    /**
     * 根据ID查询所有子集
     *
     * @param id 监控中心管理主键
     * @return 监控中心管理
     */
    public JSONObject selectSubSysMonitorCenterById(Long id);

    /**
     * 查询监控中心管理列表
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 监控中心管理集合
     */
    public List<SysMonitorCenter> selectSysMonitorCenterList(SysMonitorCenter sysMonitorCenter);

    /**
     *  h获取监控中心名称
     * @param sysMonitorCenter []
     * @return []
     */
    public JSONArray selectSysMonitorCenterName(SysMonitorCenter sysMonitorCenter);


    /**
     *
     * @return 查询顶级父级
     */
    public JSONObject selectSysParentMonitorCenterList();

    /**
     * 新增监控中心管理
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 结果
     */
    public int insertSysMonitorCenter(SysMonitorCenter sysMonitorCenter);

    /**
     * 修改监控中心管理
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 结果
     */
    public int updateSysMonitorCenter(SysMonitorCenter sysMonitorCenter);

    /**
     * 批量删除监控中心管理
     * 
     * @param ids 需要删除的监控中心管理主键集合
     * @return 结果
     */
    public int deleteSysMonitorCenterByIds(Long[] ids);

    /**
     * 删除监控中心管理信息
     * 
     * @param id 监控中心管理主键
     * @return 结果
     */
    public int deleteSysMonitorCenterById(Long id);
}
