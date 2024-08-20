package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.SysAreaCode;
import com.ruoyi.system.service.ISysAreaCodeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 行政区划查询Controller
 *
 * @author lijun
 * @date 2024-08-14
 */
@RestController
@RequestMapping("/code")
public class SysAreaCodeController extends BaseController
{
    @Autowired
    private ISysAreaCodeService sysAreaCodeService;

    /**
     * 查询行政区划查询列表
     */
    @RequiresPermissions("system:code:list")
    @GetMapping("/list")
    public TableDataInfo list(SysAreaCode sysAreaCode)
    {
        startPage();
        List<SysAreaCode> list = sysAreaCodeService.selectSysAreaCodeList(sysAreaCode);
        return getDataTable(list);
    }

    /**
     * 导出行政区划查询列表
     */
    @RequiresPermissions("system:code:export")
    @Log(title = "行政区划查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysAreaCode sysAreaCode)
    {
        List<SysAreaCode> list = sysAreaCodeService.selectSysAreaCodeList(sysAreaCode);
        ExcelUtil<SysAreaCode> util = new ExcelUtil<SysAreaCode>(SysAreaCode.class);
        util.exportExcel(response, list, "行政区划查询数据");
    }

    /**
     * 获取行政区划查询详细信息
     */
    @RequiresPermissions("system:code:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysAreaCodeService.selectSysAreaCodeById(id));
    }

    /**
     * 获取行政区划查询详细信息
     */
    @RequiresPermissions("system:code:searchSubByCode")
    @GetMapping(value = "/searchSubByCode/{id}")
    public AjaxResult searchSubByCode(@PathVariable("id") String id)
    {
        return success(sysAreaCodeService.searchSubByCode(id));
    }


    /**
     * 获取行政区划查询详细信息
     */
    @RequiresPermissions("system:code:searchParentByCode")
    @GetMapping(value = "/searchParentByCode/{areaCode}")
    public AjaxResult searchParentByCode(@PathVariable("areaCode") String areaCode)
    {
        return success(sysAreaCodeService.searchParentByCode(areaCode));
    }

    /**
     * 新增行政区划查询
     */
    @RequiresPermissions("system:code:add")
    @Log(title = "行政区划查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysAreaCode sysAreaCode)
    {
        return toAjax(sysAreaCodeService.insertSysAreaCode(sysAreaCode));
    }

    /**
     * 修改行政区划查询
     */
    @RequiresPermissions("system:code:edit")
    @Log(title = "行政区划查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAreaCode sysAreaCode)
    {
        return toAjax(sysAreaCodeService.updateSysAreaCode(sysAreaCode));
    }

    /**
     * 删除行政区划查询
     */
    @RequiresPermissions("system:code:remove")
    @Log(title = "行政区划查询", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysAreaCodeService.deleteSysAreaCodeByIds(ids));
    }
}
