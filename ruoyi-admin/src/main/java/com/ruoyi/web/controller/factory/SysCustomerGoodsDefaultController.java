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
import com.ruoyi.system.domain.SysCustomerGoodsDefault;
import com.ruoyi.system.service.ISysCustomerGoodsDefaultService;
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
@RequestMapping("/system/priceDefault")
public class SysCustomerGoodsDefaultController extends BaseController {
    private String prefix = "system/priceDefault";

    @Autowired
    private ISysCustomerGoodsDefaultService sysCustomerGoodsDefaultService;

    @RequiresPermissions("system:priceDefault:view")
    @GetMapping()
    public String priceDefault() {
        return prefix + "/priceDefault";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:priceDefault:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCustomerGoodsDefault sysCustomerGoodsDefault) {
        startPage();
        List<SysCustomerGoodsDefault> list = sysCustomerGoodsDefaultService.selectSysCustomerGoodsDefaultList(sysCustomerGoodsDefault);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:priceDefault:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCustomerGoodsDefault sysCustomerGoodsDefault) {
        List<SysCustomerGoodsDefault> list = sysCustomerGoodsDefaultService.selectSysCustomerGoodsDefaultList(sysCustomerGoodsDefault);
        ExcelUtil<SysCustomerGoodsDefault> util = new ExcelUtil<SysCustomerGoodsDefault>(SysCustomerGoodsDefault.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:priceDefault:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCustomerGoodsDefault sysCustomerGoodsDefault) {
        return toAjax(sysCustomerGoodsDefaultService.insertSysCustomerGoodsDefault(sysCustomerGoodsDefault));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:priceDefault:edit")
    @GetMapping("/edit/{customerId}")
    public String edit(@PathVariable("customerId") Long customerId, ModelMap mmap) {
        SysCustomerGoodsDefault sysCustomerGoodsDefault = sysCustomerGoodsDefaultService.selectSysCustomerGoodsDefaultByCustomerId(customerId);
        mmap.put("sysCustomerGoodsDefault", sysCustomerGoodsDefault);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:priceDefault:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCustomerGoodsDefault sysCustomerGoodsDefault) {
        return toAjax(sysCustomerGoodsDefaultService.updateSysCustomerGoodsDefault(sysCustomerGoodsDefault));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:priceDefault:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysCustomerGoodsDefaultService.deleteSysCustomerGoodsDefaultByCustomerIds(ids));
    }
}
