package com.ruoyi.web.controller.factory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.SysCustomerGoodsDefault;
import com.ruoyi.system.domain.SysOutboundRecords;
import com.ruoyi.system.domain.SysReturnDebts;
import com.ruoyi.system.service.ISysCustomerGoodsDefaultService;
import com.ruoyi.system.service.ISysReturnDebtsService;
import com.ruoyi.web.resp.SysCustomerResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;
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
@RequestMapping("/system/customer")
public class SysCustomerController extends BaseController {
    private String prefix = "system/customer";

    @Autowired
    private ISysCustomerService sysCustomerService;

    @Autowired
    private ISysCustomerGoodsDefaultService sysCustomerGoodsDefaultService;

    @Autowired
    private ISysReturnDebtsService sysReturnDebtsService;

    @RequiresPermissions("system:customer:view")
    @GetMapping()
    public String customer() {
        return prefix + "/customer";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCustomer sysCustomer) {
        startPage();
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        List<SysCustomerResp> sysCustomerResps = list.stream().map(item -> {
            SysCustomerResp sysCustomerResp = new SysCustomerResp();
            BeanUtils.copyProperties(item, sysCustomerResp);
            sysCustomerResp.setDebtsAll(item.getDebts() + 25 * item.getUnderFrameNew());
            return sysCustomerResp;

        }).collect(Collectors.toList());
        return getDataTable(sysCustomerResps);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:customer:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCustomer sysCustomer) {
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        ExcelUtil<SysCustomer> util = new ExcelUtil<SysCustomer>(SysCustomer.class);
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
    @RequiresPermissions("system:customer:add")
    @Log(title = "新增客户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addSave(@RequestParam Map<String, Object> input) {
        SysCustomer sysCustomer = new SysCustomer();
        sysCustomer.setName(input.get("name").toString());
        sysCustomer.setPhone(input.get("phone").toString());
        sysCustomer.setDebts(new Double(input.get("debts").toString()));
        sysCustomer.setUnderFrameNew(new Long(input.get("underFrameNew").toString()));
        sysCustomer.setUnderFrameOld(new Long(input.get("underFrameOld").toString()));
        sysCustomerService.insertSysCustomer(sysCustomer);

        input.keySet().forEach(item -> {
            if (item.startsWith("good_")) {
                SysCustomerGoodsDefault sysCustomerGoodsDefault = new SysCustomerGoodsDefault();
                sysCustomerGoodsDefault.setCustomerId(sysCustomer.getId());
                sysCustomerGoodsDefault.setGoodsId(new Long(item.substring(5)));
                sysCustomerGoodsDefault.setDefaultPrice(new Double(input.get(item).toString()));
                sysCustomerGoodsDefaultService.insertSysCustomerGoodsDefault(sysCustomerGoodsDefault);
            }
        });

        return toAjax(true);
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:customer:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(id);
        SysCustomerGoodsDefault query = new SysCustomerGoodsDefault();
        query.setCustomerId(sysCustomer.getId());
        List<SysCustomerGoodsDefault> goodsDefaults = sysCustomerGoodsDefaultService.selectSysCustomerGoodsDefaultList(query);
        Map<Long, Double> goodsMap = goodsDefaults.stream().collect(Collectors.toMap(SysCustomerGoodsDefault::getGoodsId, SysCustomerGoodsDefault::getDefaultPrice));
        mmap.put("sysCustomer", sysCustomer);
        mmap.put("goodsMap", goodsMap);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:customer:edit")
    @Log(title = "编辑客户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult editSave(@RequestParam Map<String, Object> input) {
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(new Long(input.get("id").toString()));

        sysCustomer.setName(input.get("name").toString());
        sysCustomer.setPhone(input.get("phone").toString());
        sysCustomer.setDebts(new Double(input.get("debts").toString()));
        sysCustomer.setUnderFrameOld(new Long(input.get("underFrameOld").toString()));
        sysCustomer.setUnderFrameNew(new Long(input.get("underFrameNew").toString()));

        input.keySet().forEach(item -> {
            if (item.startsWith("good_")) {
                SysCustomerGoodsDefault sysCustomerGoodsDefault = new SysCustomerGoodsDefault();
                sysCustomerGoodsDefault.setCustomerId(sysCustomer.getId());
                sysCustomerGoodsDefault.setGoodsId(new Long(item.substring(5)));
                sysCustomerGoodsDefault.setDefaultPrice(new Double(input.get(item).toString()));
                sysCustomerGoodsDefaultService.updateSysCustomerGoodsDefault(sysCustomerGoodsDefault);
            }
        });

        return toAjax(sysCustomerService.updateSysCustomer(sysCustomer));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:customer:remove")
    @Log(title = "删除客户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysCustomerService.deleteSysCustomerByIds(ids));
    }


    @RequiresPermissions("system:customer:edit")
    @GetMapping("/returnCase/{id}")
    public String returnCase(@PathVariable("id") Long id, ModelMap mmap) {
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(id);
        mmap.put("sysCustomer", sysCustomer);
        return prefix + "/returnCase";
    }

    @RequiresPermissions("system:customer:edit")
    @Log(title = "还框", businessType = BusinessType.UPDATE)
    @PostMapping("/returnCase")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult returnCase(@RequestParam Map<String, Object> input) {
        Long sysCustomerId = new Long(input.get("sysCustomerId").toString());
        Long returnCaseNew = new Long(input.get("returnCaseNew").toString());
        Long returnCaseOld = new Long(input.get("returnCaseOld").toString());
        sysCustomerService.returnCase(sysCustomerId, returnCaseNew, returnCaseOld);
        return toAjax(1);
    }

    @RequiresPermissions("system:customer:edit")
    @GetMapping("/returnDebts/{id}")
    public String returnDebts(@PathVariable("id") Long id, ModelMap mmap) {
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(id);
        mmap.put("sysCustomer", sysCustomer);
        return prefix + "/returnDebts";
    }

    @RequiresPermissions("system:customer:edit")
    @Log(title = "还款", businessType = BusinessType.UPDATE)
    @PostMapping("/returnDebts")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult returnDebts(@RequestParam Map<String, Object> input) {
        //生成还款记录
        Long sysCustomerId = new Long(input.get("sysCustomerId").toString());
        String origin = input.get("origin").toString();
        BigDecimal returnDebts = BigDecimal.valueOf(new Double(input.get("returnDebts").toString()));
        String comment = input.get("comment").toString();
        sysCustomerService.returnDebts(sysCustomerId, returnDebts);
        SysReturnDebts sysReturnDebts = new SysReturnDebts();
        sysReturnDebts.setCustomerId(sysCustomerId);
        sysReturnDebts.setAmount(returnDebts);
        sysReturnDebts.setOrigin(origin);
        sysReturnDebts.setComment(comment);
        sysReturnDebts.setTimestamp(System.currentTimeMillis());
        sysReturnDebtsService.insertSysReturnDebts(sysReturnDebts);
        return toAjax(1);
    }
}
