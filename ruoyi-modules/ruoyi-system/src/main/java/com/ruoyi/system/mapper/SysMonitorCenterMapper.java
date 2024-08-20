package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysMonitorCenter;

/**
 * 监控中心管理Mapper接口
 * 
 * @author lijun
 * @date 2024-08-05
 */
public interface SysMonitorCenterMapper 
{
    /**
     * 查询监控中心管理
     * 
     * @param id 监控中心管理主键
     * @return 监控中心管理
     */
    public SysMonitorCenter selectSysMonitorCenterById(Long id);


    /**
     * 根据id查询所有上级
     * @param id 监控中心管理主键
     * @return 监控中心管理集合
     */
    public List<SysMonitorCenter> selectParentSysMonitorCenterById(Long id);

    /**
     * 查询监控中心管理列表
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 监控中心管理集合
     */
    public List<SysMonitorCenter> selectSysMonitorCenterList(SysMonitorCenter sysMonitorCenter);


    /**
     *
     * @return 查询顶级监控中心
     */
    public List<SysMonitorCenter> selectSysParentMonitorCenterList();


    /**
     * 根据父级id查询所有的子集
     *
     * @param id 查询ID
     * @return 监控中心管理集合
     */
    public List<SysMonitorCenter> selectSubSysMonitorCenterById(Long id);

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
     * 删除监控中心管理
     * 
     * @param id 监控中心管理主键
     * @return 结果
     */
    public int deleteSysMonitorCenterById(Long id);

    /**
     * 批量删除监控中心管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMonitorCenterByIds(Long[] ids);
}
