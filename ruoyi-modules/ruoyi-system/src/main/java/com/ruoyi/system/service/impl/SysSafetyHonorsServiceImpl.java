package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSafetyHonorsMapper;
import com.ruoyi.system.domain.SysSafetyHonors;
import com.ruoyi.system.service.ISysSafetyHonorsService;

/**
 * 安全荣誉管理Service业务层处理
 *
 * @author lijun
 * @date 2024-08-06
 */
@Service
public class SysSafetyHonorsServiceImpl implements ISysSafetyHonorsService
{
    @Autowired
    private SysSafetyHonorsMapper sysSafetyHonorsMapper;

    /**
     * 查询安全荣誉管理
     *
     * @param id 安全荣誉管理主键
     * @return 安全荣誉管理
     */
    @Override
    public SysSafetyHonors selectSysSafetyHonorsById(Long id)
    {
        return sysSafetyHonorsMapper.selectSysSafetyHonorsById(id);
    }

    /**
     * 查询安全荣誉管理列表
     *
     * @param sysSafetyHonors 安全荣誉管理
     * @return 安全荣誉管理
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysSafetyHonors> selectSysSafetyHonorsList(SysSafetyHonors sysSafetyHonors)
    {
        return sysSafetyHonorsMapper.selectSysSafetyHonorsList(sysSafetyHonors);
    }

    /**
     * 新增安全荣誉管理
     *
     * @param sysSafetyHonors 安全荣誉管理
     * @return 结果
     */
    @Override
    public int insertSysSafetyHonors(SysSafetyHonors sysSafetyHonors)
    {
        sysSafetyHonors.setCreateTime(DateUtils.getNowDate());
        return sysSafetyHonorsMapper.insertSysSafetyHonors(sysSafetyHonors);
    }

    /**
     * 修改安全荣誉管理
     *
     * @param sysSafetyHonors 安全荣誉管理
     * @return 结果
     */
    @Override
    public int updateSysSafetyHonors(SysSafetyHonors sysSafetyHonors)
    {
        sysSafetyHonors.setUpdateTime(DateUtils.getNowDate());
        return sysSafetyHonorsMapper.updateSysSafetyHonors(sysSafetyHonors);
    }

    /**
     * 批量删除安全荣誉管理
     *
     * @param ids 需要删除的安全荣誉管理主键
     * @return 结果
     */
    @Override
    public int deleteSysSafetyHonorsByIds(Long[] ids)
    {
        return sysSafetyHonorsMapper.deleteSysSafetyHonorsByIds(ids);
    }

    /**
     * 删除安全荣誉管理信息
     *
     * @param id 安全荣誉管理主键
     * @return 结果
     */
    @Override
    public int deleteSysSafetyHonorsById(Long id)
    {
        return sysSafetyHonorsMapper.deleteSysSafetyHonorsById(id);
    }
}
