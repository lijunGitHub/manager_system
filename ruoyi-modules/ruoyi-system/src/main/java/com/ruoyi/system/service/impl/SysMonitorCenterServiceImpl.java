package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMonitorCenterMapper;
import com.ruoyi.system.domain.SysMonitorCenter;
import com.ruoyi.system.service.ISysMonitorCenterService;

/**
 * 监控中心管理Service业务层处理
 * 
 * @author lijun
 * @date 2024-08-05
 */
@Service
public class SysMonitorCenterServiceImpl implements ISysMonitorCenterService 
{
    @Autowired
    private SysMonitorCenterMapper sysMonitorCenterMapper;

    /**
     * 查询监控中心管理
     * 
     * @param id 监控中心管理主键
     * @return 监控中心管理
     */
    @Override
    public SysMonitorCenter selectSysMonitorCenterById(Long id)
    {
        return sysMonitorCenterMapper.selectSysMonitorCenterById(id);
    }

    @Override
    public JSONObject selectParentSysMonitorCenterById(Long id) {
        List<SysMonitorCenter> sysMonitorCenters = sysMonitorCenterMapper.selectParentSysMonitorCenterById(id);
        return dealParentList(sysMonitorCenters);
    }

    @Override
    public JSONObject selectSubSysMonitorCenterById(Long id) {
        List<SysMonitorCenter> sysMonitorCenters = sysMonitorCenterMapper.selectSubSysMonitorCenterById(id);
        return transformToNestedJson(sysMonitorCenters);
    }

    /**
     * 查询监控中心管理列表
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 监控中心管理
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysMonitorCenter> selectSysMonitorCenterList(SysMonitorCenter sysMonitorCenter)
    {
        return sysMonitorCenterMapper.selectSysMonitorCenterList(sysMonitorCenter);
    }


    @Override
    public JSONArray selectSysMonitorCenterName(SysMonitorCenter sysMonitorCenter)
    {
        List<SysMonitorCenter> sysMonitorCenters = sysMonitorCenterMapper.selectSysMonitorCenterList(sysMonitorCenter);
        return dealListToJson(sysMonitorCenters);
    }
    public JSONArray dealListToJson(List<SysMonitorCenter> sysCompanies){
        JSONArray result = new JSONArray();

        for(SysMonitorCenter sysMonitorCenter:sysCompanies){
            JSONObject root = new JSONObject();
            root.put("value",sysMonitorCenter.getId());
            root.put("label",sysMonitorCenter.getMonitorCenterName());
            result.add(root);
        }
        return result;
    }

    @Override
    public JSONObject selectSysParentMonitorCenterList() {
        List<SysMonitorCenter> sysMonitorCenters = sysMonitorCenterMapper.selectSysParentMonitorCenterList();
        return transformToNestedJson(sysMonitorCenters);
    }

    public JSONObject transformToNestedJson(List<SysMonitorCenter> data) {
        Map<String, JSONArray> map = new HashMap<>();
        JSONArray root = new JSONArray();
        for (SysMonitorCenter item : data) {
            if (!map.containsKey(item.getMonitorCenterParentId()+"")) {
                map.put(item.getMonitorCenterParentId()+"", new JSONArray());
            }

            JSONObject newItem = new JSONObject();
            newItem.put("label", item.getMonitorCenterName());
            if(item.getMonitorCenterName().equals("顶级监控中心")){
                newItem.put("value", 1);
            }else {
                newItem.put("value", item.getId());
            }
            newItem.put("children", new JSONArray());

            root.add(newItem);

//            } else {
//                JSONArray parent = map.get(item.getParentCode());
//                if (parent != null) {
//                    parent.add(newItem);
//                }
//            }

            System.out.println(newItem.get("children"));
            //存储子项，以便后续查询
            map.put(item.getId()+"", newItem.getJSONArray("children"));
        }


        JSONObject jsonObject =  new JSONObject();
        jsonObject.put("data", root);
        return jsonObject;
    }

    public JSONObject dealParentList( List<SysMonitorCenter> sysAreaCodes){
        JSONObject resultTemp = new JSONObject();
        switch (sysAreaCodes.size()){
            case 5:
                resultTemp.put("value",sysAreaCodes.get(4).getId());
                resultTemp.put("label",sysAreaCodes.get(4).getMonitorCenterName());
                resultTemp.put("children",new JSONArray());
            case 4:
                JSONObject resultTemp4 = new JSONObject();
                resultTemp4.put("value",sysAreaCodes.get(3).getId());
                resultTemp4.put("label",sysAreaCodes.get(3).getMonitorCenterName());
                JSONArray jsonArray = new JSONArray();
                if(sysAreaCodes.size()>=5){
                    jsonArray.add(resultTemp);
                }
                resultTemp4.put("children",jsonArray);
                resultTemp = resultTemp4;
            case 3:
                JSONObject resultTemp3 = new JSONObject();
                resultTemp3.put("value",sysAreaCodes.get(2).getId());
                resultTemp3.put("label",sysAreaCodes.get(2).getMonitorCenterName());
                JSONArray jsonArray2 = new JSONArray();
                if(sysAreaCodes.size()>=4){
                    jsonArray2.add(resultTemp);
                }
                resultTemp3.put("children",jsonArray2);
                resultTemp = resultTemp3;
            case 2:
                JSONObject resultTemp2 = new JSONObject();
                resultTemp2.put("value",sysAreaCodes.get(1).getId());
                resultTemp2.put("label",sysAreaCodes.get(1).getMonitorCenterName());
                JSONArray jsonArray3 = new JSONArray();
                if(sysAreaCodes.size()>=3){
                    jsonArray3.add(resultTemp);
                }
                resultTemp2.put("children",jsonArray3);
                resultTemp = resultTemp2;
            case 1:
                JSONObject resultTemp1 = new JSONObject();
                resultTemp1.put("value",sysAreaCodes.get(0).getId());
                resultTemp1.put("label",sysAreaCodes.get(0).getMonitorCenterName());
                JSONArray jsonArray4 = new JSONArray();
                if(sysAreaCodes.size()>=2){
                    jsonArray4.add(resultTemp);
                }
                resultTemp1.put("children",jsonArray4);
                resultTemp = resultTemp1;
        }
        return resultTemp;
    }

    /**
     * 新增监控中心管理
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 结果
     */
    @Override
    public int insertSysMonitorCenter(SysMonitorCenter sysMonitorCenter)
    {
        sysMonitorCenter.setCreateTime(DateUtils.getNowDate());
        return sysMonitorCenterMapper.insertSysMonitorCenter(sysMonitorCenter);
    }

    /**
     * 修改监控中心管理
     * 
     * @param sysMonitorCenter 监控中心管理
     * @return 结果
     */
    @Override
    public int updateSysMonitorCenter(SysMonitorCenter sysMonitorCenter)
    {
        sysMonitorCenter.setUpdateTime(DateUtils.getNowDate());
        return sysMonitorCenterMapper.updateSysMonitorCenter(sysMonitorCenter);
    }

    /**
     * 批量删除监控中心管理
     * 
     * @param ids 需要删除的监控中心管理主键
     * @return 结果
     */
    @Override
    public int deleteSysMonitorCenterByIds(Long[] ids)
    {
        return sysMonitorCenterMapper.deleteSysMonitorCenterByIds(ids);
    }

    /**
     * 删除监控中心管理信息
     * 
     * @param id 监控中心管理主键
     * @return 结果
     */
    @Override
    public int deleteSysMonitorCenterById(Long id)
    {
        return sysMonitorCenterMapper.deleteSysMonitorCenterById(id);
    }
}
