package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCompanyMapper;
import com.ruoyi.system.domain.SysCompany;
import com.ruoyi.system.service.ISysCompanyService;

/**
 * 公司信息Service业务层处理
 * 
 * @author ijun
 * @date 2024-08-03
 */
@Service
public class SysCompanyServiceImpl implements ISysCompanyService 
{
    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    /**
     * 查询公司信息
     * 
     * @param companyId 公司信息主键
     * @return 公司信息
     */
    @Override
    public SysCompany selectSysCompanyByCompanyId(Long companyId)
    {
        return sysCompanyMapper.selectSysCompanyByCompanyId(companyId);
    }

    @Override
    public JSONArray selectSysCompany(SysCompany sysCompany) {
        List<SysCompany> sysCompanies = sysCompanyMapper.selectSysCompanyList(sysCompany);
        return dealListToJson(sysCompanies);
    }

    public JSONArray dealListToJson(List<SysCompany> sysCompanies){
        JSONArray result = new JSONArray();

        for(SysCompany sysCompany:sysCompanies){
            JSONObject root = new JSONObject();
            root.put("value",sysCompany.getCompanyId());
            root.put("label",sysCompany.getCompanyName());
            result.add(root);
        }
        return result;
    }

    /**
     * 查询公司信息列表
     * 
     * @param sysCompany 公司信息
     * @return 公司信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysCompany> selectSysCompanyList(SysCompany sysCompany)
    {
        return sysCompanyMapper.selectSysCompanyList(sysCompany);
    }

    /**
     * 新增公司信息
     * 
     * @param sysCompany 公司信息
     * @return 结果
     */
    @Override
    public int insertSysCompany(SysCompany sysCompany)
    {
        return sysCompanyMapper.insertSysCompany(sysCompany);
    }

    /**
     * 修改公司信息
     * 
     * @param sysCompany 公司信息
     * @return 结果
     */
    @Override
    public int updateSysCompany(SysCompany sysCompany)
    {
        return sysCompanyMapper.updateSysCompany(sysCompany);
    }

    /**
     * 批量删除公司信息
     * 
     * @param companyIds 需要删除的公司信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCompanyByCompanyIds(Long[] companyIds)
    {
        return sysCompanyMapper.deleteSysCompanyByCompanyIds(companyIds);
    }

    /**
     * 删除公司信息信息
     * 
     * @param companyId 公司信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCompanyByCompanyId(Long companyId)
    {
        return sysCompanyMapper.deleteSysCompanyByCompanyId(companyId);
    }
}
