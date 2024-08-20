package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.SysSafetyHonors;
import com.ruoyi.system.service.ISysSafetyHonorsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 安全荣誉管理Controller
 *
 * @author lijun
 * @date 2024-08-06
 */
@RestController
@RequestMapping("/honors")
public class SysSafetyHonorsController extends BaseController
{
    @Autowired
    private ISysSafetyHonorsService sysSafetyHonorsService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询安全荣誉管理列表
     */
    @RequiresPermissions("system:honors:list")
    @GetMapping("/list")
    public TableDataInfo list(SysSafetyHonors sysSafetyHonors)
    {
        startPage();
        List<SysSafetyHonors> list = sysSafetyHonorsService.selectSysSafetyHonorsList(sysSafetyHonors);
        return getDataTable(list);
    }

    /**
     * 导出安全荣誉管理列表
     */
    @RequiresPermissions("system:honors:export")
    @Log(title = "安全荣誉管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSafetyHonors sysSafetyHonors)
    {
        List<SysSafetyHonors> list = sysSafetyHonorsService.selectSysSafetyHonorsList(sysSafetyHonors);
        ExcelUtil<SysSafetyHonors> util = new ExcelUtil<SysSafetyHonors>(SysSafetyHonors.class);
        util.exportExcel(response, list, "安全荣誉管理数据");
    }

    /**
     * 获取安全荣誉管理详细信息
     */
    @RequiresPermissions("system:honors:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysSafetyHonorsService.selectSysSafetyHonorsById(id));
    }

    /**
     * 新增安全荣誉管理
     */
    @RequiresPermissions("system:honors:add")
    @Log(title = "安全荣誉管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSafetyHonors sysSafetyHonors)
    {

        sysSafetyHonors.setUserId(SecurityUtils.getUserId());
        SysUser sysUser = sysUserService.selectUserById(SecurityUtils.getUserId());
        sysSafetyHonors.setDeptId(sysUser.getDeptId());
        return toAjax(sysSafetyHonorsService.insertSysSafetyHonors(sysSafetyHonors));
    }

    /**
     * 修改安全荣誉管理
     */
    @RequiresPermissions("system:honors:edit")
    @Log(title = "安全荣誉管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSafetyHonors sysSafetyHonors)
    {
        return toAjax(sysSafetyHonorsService.updateSysSafetyHonors(sysSafetyHonors));
    }

    /**
     * 删除安全荣誉管理
     */
    @RequiresPermissions("system:honors:remove")
    @Log(title = "安全荣誉管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysSafetyHonorsService.deleteSysSafetyHonorsByIds(ids));
    }
}
