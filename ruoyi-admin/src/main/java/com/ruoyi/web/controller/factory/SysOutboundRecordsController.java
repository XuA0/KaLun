package com.ruoyi.web.controller.factory;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysOutboundRecords;
import com.ruoyi.system.service.ISysOutboundRecordsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
@Controller
@RequestMapping("/system/outBoundRecords")
public class SysOutboundRecordsController extends BaseController
{
    private String prefix = "system/outBoundRecords";

    @Autowired
    private ISysOutboundRecordsService sysOutboundRecordsService;

    @RequiresPermissions("system:outBoundRecords:view")
    @GetMapping()
    public String records()
    {
        return prefix + "/outBoundRecords";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundRecords:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOutboundRecords sysOutboundRecords)
    {
        startPage();
        List<SysOutboundRecords> list = sysOutboundRecordsService.selectSysOutboundRecordsList(sysOutboundRecords);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundRecords:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOutboundRecords sysOutboundRecords)
    {
        List<SysOutboundRecords> list = sysOutboundRecordsService.selectSysOutboundRecordsList(sysOutboundRecords);
        ExcelUtil<SysOutboundRecords> util = new ExcelUtil<SysOutboundRecords>(SysOutboundRecords.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysOutboundRecords sysOutboundRecords)
    {
        return toAjax(sysOutboundRecordsService.insertSysOutboundRecords(sysOutboundRecords));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysOutboundRecords sysOutboundRecords = sysOutboundRecordsService.selectSysOutboundRecordsById(id);
        mmap.put("sysOutboundRecords", sysOutboundRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysOutboundRecords sysOutboundRecords)
    {
        return toAjax(sysOutboundRecordsService.updateSysOutboundRecords(sysOutboundRecords));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysOutboundRecordsService.deleteSysOutboundRecordsByIds(ids));
    }
}
