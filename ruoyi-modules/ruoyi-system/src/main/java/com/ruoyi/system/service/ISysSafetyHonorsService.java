package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysSafetyHonors;

/**
 * 安全荣誉管理Service接口
 * 
 * @author lijun
 * @date 2024-08-06
 */
public interface ISysSafetyHonorsService 
{
    /**
     * 查询安全荣誉管理
     * 
     * @param id 安全荣誉管理主键
     * @return 安全荣誉管理
     */
    public SysSafetyHonors selectSysSafetyHonorsById(Long id);

    /**
     * 查询安全荣誉管理列表
     * 
     * @param sysSafetyHonors 安全荣誉管理
     * @return 安全荣誉管理集合
     */
    public List<SysSafetyHonors> selectSysSafetyHonorsList(SysSafetyHonors sysSafetyHonors);

    /**
     * 新增安全荣誉管理
     * 
     * @param sysSafetyHonors 安全荣誉管理
     * @return 结果
     */
    public int insertSysSafetyHonors(SysSafetyHonors sysSafetyHonors);

    /**
     * 修改安全荣誉管理
     * 
     * @param sysSafetyHonors 安全荣誉管理
     * @return 结果
     */
    public int updateSysSafetyHonors(SysSafetyHonors sysSafetyHonors);

    /**
     * 批量删除安全荣誉管理
     * 
     * @param ids 需要删除的安全荣誉管理主键集合
     * @return 结果
     */
    public int deleteSysSafetyHonorsByIds(Long[] ids);

    /**
     * 删除安全荣誉管理信息
     * 
     * @param id 安全荣誉管理主键
     * @return 结果
     */
    public int deleteSysSafetyHonorsById(Long id);
}
