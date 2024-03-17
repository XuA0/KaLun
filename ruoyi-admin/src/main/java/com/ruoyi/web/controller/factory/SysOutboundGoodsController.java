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
import com.ruoyi.system.domain.SysOutboundGoods;
import com.ruoyi.system.service.ISysOutboundGoodsService;
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
@RequestMapping("/system/outBoundGoods")
public class SysOutboundGoodsController extends BaseController
{
    private String prefix = "system/outBoundGoods";

    @Autowired
    private ISysOutboundGoodsService sysOutboundGoodsService;

    @RequiresPermissions("system:outBoundGoods:view")
    @GetMapping()
    public String outBoundGoods()
    {
        return prefix + "/outBoundGoods";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundGoods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOutboundGoods sysOutboundGoods)
    {
        startPage();
        List<SysOutboundGoods> list = sysOutboundGoodsService.selectSysOutboundGoodsList(sysOutboundGoods);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundGoods:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOutboundGoods sysOutboundGoods)
    {
        List<SysOutboundGoods> list = sysOutboundGoodsService.selectSysOutboundGoodsList(sysOutboundGoods);
        ExcelUtil<SysOutboundGoods> util = new ExcelUtil<SysOutboundGoods>(SysOutboundGoods.class);
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
    @RequiresPermissions("system:outBoundGoods:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysOutboundGoods sysOutboundGoods)
    {
        return toAjax(sysOutboundGoodsService.insertSysOutboundGoods(sysOutboundGoods));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundGoods:edit")
    @GetMapping("/edit/{outboundId}")
    public String edit(@PathVariable("outboundId") Long outboundId, ModelMap mmap)
    {
        SysOutboundGoods sysOutboundGoods = sysOutboundGoodsService.selectSysOutboundGoodsByOutboundId(outboundId);
        mmap.put("sysOutboundGoods", sysOutboundGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundGoods:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysOutboundGoods sysOutboundGoods)
    {
        return toAjax(sysOutboundGoodsService.updateSysOutboundGoods(sysOutboundGoods));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundGoods:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysOutboundGoodsService.deleteSysOutboundGoodsByOutboundIds(ids));
    }
}
