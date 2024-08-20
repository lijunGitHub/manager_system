package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysAreaCode;

/**
 * 行政区划查询Mapper接口
 *
 * @author lijun
 * @date 2024-08-14
 */
public interface SysAreaCodeMapper
{
    /**
     * 查询行政区划查询
     *
     * @param id 行政区划查询主键
     * @return 行政区划查询
     */
    public SysAreaCode selectSysAreaCodeById(String id);

    /**
     * 查询行政区划查询列表
     *
     * @param sysAreaCode 行政区划查询
     * @return 行政区划查询集合
     */
    public List<SysAreaCode> selectSysAreaCodeList(SysAreaCode sysAreaCode);



    public List<SysAreaCode> searchSubByCode(String id);

    public List<SysAreaCode> searchParentByCode(String areaCode);

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
     * 删除行政区划查询
     *
     * @param id 行政区划查询主键
     * @return 结果
     */
    public int deleteSysAreaCodeById(String id);

    /**
     * 批量删除行政区划查询
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysAreaCodeByIds(String[] ids);
}
