package com.ruoyi.web.controller.factory;

import java.text.DateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;
import com.ruoyi.web.resp.SysReturnDebtResp;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
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
import com.ruoyi.system.domain.SysReturnDebts;
import com.ruoyi.system.service.ISysReturnDebtsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2024-03-25
 */
@Controller
@RequestMapping("/system/returnDebts")
public class SysReturnDebtsController extends BaseController {
    private String prefix = "system/returnDebts";

    @Autowired
    private ISysReturnDebtsService sysReturnDebtsService;

    @Autowired
    private ISysCustomerService sysCustomerService;

    @RequiresPermissions("system:debts:view")
    @GetMapping()
    public String debts() {
        return prefix + "/debts";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:debts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysReturnDebts sysReturnDebts) {
        startPage();
        List<SysReturnDebts> list = sysReturnDebtsService.selectSysReturnDebtsList(sysReturnDebts);
        List<SysReturnDebtResp> sysReturnDebtResps = list.stream().map(item -> {
            SysReturnDebtResp sysReturnDebtResp = new SysReturnDebtResp();
            BeanUtils.copyProperties(item, sysReturnDebtResp);
            SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(item.getCustomerId());
            sysReturnDebtResp.setCustomerName(sysCustomer.getName());
            sysReturnDebtResp.setDay(DateFormatUtils.format(item.getTimestamp(), "yyyy-MM-dd HH:mm:ss"));
            return sysReturnDebtResp;
        }).collect(Collectors.toList());
        return getDataTable(sysReturnDebtResps);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:debts:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysReturnDebts sysReturnDebts) {
        List<SysReturnDebts> list = sysReturnDebtsService.selectSysReturnDebtsList(sysReturnDebts);
        ExcelUtil<SysReturnDebts> util = new ExcelUtil<SysReturnDebts>(SysReturnDebts.class);
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
    @RequiresPermissions("system:debts:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysReturnDebts sysReturnDebts) {
        return toAjax(sysReturnDebtsService.insertSysReturnDebts(sysReturnDebts));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:debts:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SysReturnDebts sysReturnDebts = sysReturnDebtsService.selectSysReturnDebtsById(id);
        mmap.put("sysReturnDebts", sysReturnDebts);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:debts:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysReturnDebts sysReturnDebts) {
        return toAjax(sysReturnDebtsService.updateSysReturnDebts(sysReturnDebts));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:debts:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysReturnDebtsService.deleteSysReturnDebtsByIds(ids));
    }
}
