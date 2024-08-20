package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.SysMonitorCenter;
import com.ruoyi.system.service.ISysMonitorCenterService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 监控中心管理Controller
 * 
 * @author lijun
 * @date 2024-08-05
 */
@RestController
@RequestMapping("/center")
public class SysMonitorCenterController extends BaseController
{
    @Autowired
    private ISysMonitorCenterService sysMonitorCenterService;


    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询监控中心管理列表
     */
    @RequiresPermissions("system:center:list")
    @GetMapping("/list")
    public TableDataInfo list(SysMonitorCenter sysMonitorCenter)
    {
        startPage();
        List<SysMonitorCenter> list = sysMonitorCenterService.selectSysMonitorCenterList(sysMonitorCenter);
        return getDataTable(list);
    }



    @RequiresPermissions("system:center:selectSysMonitorCenterName")
    @GetMapping("/selectSysMonitorCenterName")
    public AjaxResult selectSysMonitorCenterName(SysMonitorCenter sysMonitorCenter)
    {
        startPage();
        return AjaxResult.success(sysMonitorCenterService.selectSysMonitorCenterName(sysMonitorCenter));
    }



    @RequiresPermissions("system:center:getParentById")
    @GetMapping(value = "/getParentById/{id}")
    public AjaxResult selectParentSysMonitorCenterById(@PathVariable("id") Long id)
    {
        startPage();
        JSONObject jsonObject = sysMonitorCenterService.selectParentSysMonitorCenterById(id);
        return AjaxResult.success(jsonObject);
    }

    @RequiresPermissions("system:center:getSubById")
    @GetMapping(value = "/getSubById/{id}")
    public AjaxResult selectSubSysMonitorCenterById(@PathVariable("id") Long id)
    {
        return success(sysMonitorCenterService.selectSubSysMonitorCenterById(id));
    }




    /**
     * 查询监控中心管理列表
     */
    @RequiresPermissions("system:center:getTopParent")
    @GetMapping("/getTopParent")
    public AjaxResult getTopParent()
    {
        startPage();
        JSONObject jsonObject = sysMonitorCenterService.selectSysParentMonitorCenterList();
        return AjaxResult.success(jsonObject);
    }

    /**
     * 导出监控中心管理列表
     */
    @RequiresPermissions("system:center:export")
    @Log(title = "监控中心管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMonitorCenter sysMonitorCenter)
    {
        List<SysMonitorCenter> list = sysMonitorCenterService.selectSysMonitorCenterList(sysMonitorCenter);
        ExcelUtil<SysMonitorCenter> util = new ExcelUtil<SysMonitorCenter>(SysMonitorCenter.class);
        util.exportExcel(response, list, "监控中心管理数据");
    }

    /**
     * 获取监控中心管理详细信息
     */
    @RequiresPermissions("system:center:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysMonitorCenterService.selectSysMonitorCenterById(id));
    }

    /**
     * 新增监控中心管理
     */
    @RequiresPermissions("system:center:add")
    @Log(title = "监控中心管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMonitorCenter sysMonitorCenter)
    {

        sysMonitorCenter.setUserId(SecurityUtils.getUserId());
        SysUser sysUser = sysUserService.selectUserById(SecurityUtils.getUserId());
        sysMonitorCenter.setDeptId(sysUser.getDeptId());
        return toAjax(sysMonitorCenterService.insertSysMonitorCenter(sysMonitorCenter));
    }

    /**
     * 修改监控中心管理
     */
    @RequiresPermissions("system:center:edit")
    @Log(title = "监控中心管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMonitorCenter sysMonitorCenter)
    {
        return toAjax(sysMonitorCenterService.updateSysMonitorCenter(sysMonitorCenter));
    }

    /**
     * 删除监控中心管理
     */
    @RequiresPermissions("system:center:remove")
    @Log(title = "监控中心管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysMonitorCenterService.deleteSysMonitorCenterByIds(ids));
    }
}
