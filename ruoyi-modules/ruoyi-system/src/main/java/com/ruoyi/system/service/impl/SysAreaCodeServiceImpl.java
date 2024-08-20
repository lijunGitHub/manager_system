package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAreaCodeMapper;
import com.ruoyi.system.domain.SysAreaCode;
import com.ruoyi.system.service.ISysAreaCodeService;

/**
 * 行政区划查询Service业务层处理
 *
 * @author lijun
 * @date 2024-08-14
 */
@Service
public class SysAreaCodeServiceImpl implements ISysAreaCodeService
{
    @Autowired
    private SysAreaCodeMapper sysAreaCodeMapper;

    /**
     * 查询行政区划查询
     *
     * @param id 行政区划查询主键
     * @return 行政区划查询
     */
    @Override
    public SysAreaCode selectSysAreaCodeById(String id)
    {
        return sysAreaCodeMapper.selectSysAreaCodeById(id);
    }

    @Override
    public JSONArray searchSubByCode(String id) {
        List<SysAreaCode> sysAreaCodes = sysAreaCodeMapper.searchSubByCode(id);
        JSONArray jsonArray = new JSONArray();
        for(SysAreaCode sysAreaCode: sysAreaCodes){
            JSONObject object = new JSONObject();
            object.put("value",sysAreaCode.getAreaCode());
            object.put("label",sysAreaCode.getName());
            jsonArray.add(object);
        }
        return jsonArray;
    }

    @Override
    public JSONArray searchParentByCode(String areaCode) {
        List<SysAreaCode> sysAreaCodes = sysAreaCodeMapper.searchParentByCode(areaCode);
        return buildTree(sysAreaCodes);
    }


    public static JSONArray buildTree(List<SysAreaCode> areaCodes) {
        JSONArray jsonArray = new JSONArray();
        Map<String, Map<String, Object>> treeMap = new HashMap<>();

        for (SysAreaCode areaCode : areaCodes) {
            Map<String, Object> node = new HashMap<>();
            node.put("value", areaCode.getAreaCode());
            node.put("label", areaCode.getName());

            if (areaCode.getParentCode().equals("0")) {
                // 根节点
                jsonArray.add(node);
            } else {
                // 非根节点
                Map<String, Object> parentNode = treeMap.computeIfAbsent(areaCode.getParentCode(), k -> new HashMap<>());
                List<Map<String, Object>> children = (List<Map<String, Object>>) parentNode.computeIfAbsent("children", k -> new JSONArray());
                children.add(node);
            }

            treeMap.put(areaCode.getAreaCode(), node);
        }

        return jsonArray;
    }
    /**
     * 查询行政区划查询列表
     *
     * @param sysAreaCode 行政区划查询
     * @return 行政区划查询
     */
    @Override
    public List<SysAreaCode> selectSysAreaCodeList(SysAreaCode sysAreaCode)
    {
        return sysAreaCodeMapper.selectSysAreaCodeList(sysAreaCode);
    }

    /**
     * 新增行政区划查询
     *
     * @param sysAreaCode 行政区划查询
     * @return 结果
     */
    @Override
    public int insertSysAreaCode(SysAreaCode sysAreaCode)
    {
        return sysAreaCodeMapper.insertSysAreaCode(sysAreaCode);
    }

    /**
     * 修改行政区划查询
     *
     * @param sysAreaCode 行政区划查询
     * @return 结果
     */
    @Override
    public int updateSysAreaCode(SysAreaCode sysAreaCode)
    {
        return sysAreaCodeMapper.updateSysAreaCode(sysAreaCode);
    }

    /**
     * 批量删除行政区划查询
     *
     * @param ids 需要删除的行政区划查询主键
     * @return 结果
     */
    @Override
    public int deleteSysAreaCodeByIds(String[] ids)
    {
        return sysAreaCodeMapper.deleteSysAreaCodeByIds(ids);
    }

    /**
     * 删除行政区划查询信息
     *
     * @param id 行政区划查询主键
     * @return 结果
     */
    @Override
    public int deleteSysAreaCodeById(String id)
    {
        return sysAreaCodeMapper.deleteSysAreaCodeById(id);
    }
}
