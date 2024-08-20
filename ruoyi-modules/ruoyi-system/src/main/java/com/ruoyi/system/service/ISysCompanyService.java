package com.ruoyi.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.SysCompany;

/**
 * 公司信息Service接口
 * 
 * @author ijun
 * @date 2024-08-03
 */
public interface ISysCompanyService 
{
    /**
     * 查询公司信息
     * 
     * @param companyId 公司信息主键
     * @return 公司信息
     */
    public SysCompany selectSysCompanyByCompanyId(Long companyId);


    /**
     *  获取公司信息
     * @param  sysCompany【】
     * @return 【】
     */
    public JSONArray selectSysCompany(SysCompany sysCompany);

    /**
     * 查询公司信息列表
     * 
     * @param sysCompany 公司信息
     * @return 公司信息集合
     */
    public List<SysCompany> selectSysCompanyList(SysCompany sysCompany);

    /**
     * 新增公司信息
     * 
     * @param sysCompany 公司信息
     * @return 结果
     */
    public int insertSysCompany(SysCompany sysCompany);

    /**
     * 修改公司信息
     * 
     * @param sysCompany 公司信息
     * @return 结果
     */
    public int updateSysCompany(SysCompany sysCompany);

    /**
     * 批量删除公司信息
     * 
     * @param companyIds 需要删除的公司信息主键集合
     * @return 结果
     */
    public int deleteSysCompanyByCompanyIds(Long[] companyIds);

    /**
     * 删除公司信息信息
     * 
     * @param companyId 公司信息主键
     * @return 结果
     */
    public int deleteSysCompanyByCompanyId(Long companyId);
}
