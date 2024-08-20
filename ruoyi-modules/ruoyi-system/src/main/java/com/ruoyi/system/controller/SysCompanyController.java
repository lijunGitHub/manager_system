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
import com.ruoyi.system.domain.SysCompany;
import com.ruoyi.system.service.ISysCompanyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 公司信息Controller
 * 
 * @author ijun
 * @date 2024-08-03
 */
@RestController
@RequestMapping("/company")
public class SysCompanyController extends BaseController
{
    @Autowired
    private ISysCompanyService sysCompanyService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询公司信息列表
     */
    @RequiresPermissions("system:company:list")
    @GetMapping("/list")
    public TableDataInfo list(SysCompany sysCompany)
    {
        startPage();
        sysCompany.setUserId(SecurityUtils.getUserId());
        SysUser sysUser = sysUserService.selectUserById(SecurityUtils.getUserId());
        sysCompany.setDeptId(sysUser.getDeptId());
        List<SysCompany> list = sysCompanyService.selectSysCompanyList(sysCompany);
        return getDataTable(list);
    }


    @RequiresPermissions("system:company:getCompanyName")
    @GetMapping("/getCompanyName")
    public AjaxResult getCompanyName(SysCompany sysCompany)
    {
        startPage();
        return AjaxResult.success(sysCompanyService.selectSysCompany(sysCompany));
    }

    /**
     * 导出公司信息列表
     */
    @RequiresPermissions("system:company:export")
    @Log(title = "公司信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCompany sysCompany)
    {
        List<SysCompany> list = sysCompanyService.selectSysCompanyList(sysCompany);
        ExcelUtil<SysCompany> util = new ExcelUtil<SysCompany>(SysCompany.class);
        util.exportExcel(response, list, "公司信息数据");
    }

    /**
     * 获取公司信息详细信息
     */
    @RequiresPermissions("system:company:query")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return success(sysCompanyService.selectSysCompanyByCompanyId(companyId));
    }

    /**
     * 新增公司信息
     */
    @RequiresPermissions("system:company:add")
    @Log(title = "公司信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCompany sysCompany)
    {
        sysCompany.setUserId(SecurityUtils.getUserId());
        SysUser sysUser = sysUserService.selectUserById(SecurityUtils.getUserId());
        sysCompany.setDeptId(sysUser.getDeptId());
        return toAjax(sysCompanyService.insertSysCompany(sysCompany));
    }

    /**
     * 修改公司信息
     */
    @RequiresPermissions("system:company:edit")
    @Log(title = "公司信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCompany sysCompany)
    {
        return toAjax(sysCompanyService.updateSysCompany(sysCompany));
    }

    /**
     * 删除公司信息
     */
    @RequiresPermissions("system:company:remove")
    @Log(title = "公司信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(sysCompanyService.deleteSysCompanyByCompanyIds(companyIds));
    }
}
