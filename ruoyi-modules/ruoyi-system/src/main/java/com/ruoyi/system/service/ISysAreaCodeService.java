package com.ruoyi.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.system.domain.SysAreaCode;

/**
 * 行政区划查询Service接口
 *
 * @author lijun
 * @date 2024-08-14
 */
public interface ISysAreaCodeService
{
    /**
     * 查询行政区划查询
     *
     * @param id 行政区划查询主键
     * @return 行政区划查询
     */
    public SysAreaCode selectSysAreaCodeById(String id);


    public JSONArray searchSubByCode(String id);

    public JSONArray searchParentByCode(String areaCode);



    /**
     * 查询行政区划查询列表
     *
     * @param sysAreaCode 行政区划查询
     * @return 行政区划查询集合
     */
    public List<SysAreaCode> selectSysAreaCodeList(SysAreaCode sysAreaCode);

    /**
     * 新增行政区划查询
     *
     * @param sysAreaCode 行政区划查询
     * @return 结果
     */
    public int insertSysAreaCode(SysAreaCode sysAreaCode);

    /**
     * 修改行政区划查询
     *
     * @param sysAreaCode 行政区划查询
     * @return 结果
     */
    public int updateSysAreaCode(SysAreaCode sysAreaCode);

    /**
     * 批量删除行政区划查询
     *
     * @param ids 需要删除的行政区划查询主键集合
     * @return 结果
     */
    public int deleteSysAreaCodeByIds(String[] ids);

    /**
     * 删除行政区划查询信息
     *
     * @param id 行政区划查询主键
     * @return 结果
     */
    public int deleteSysAreaCodeById(String id);
}
