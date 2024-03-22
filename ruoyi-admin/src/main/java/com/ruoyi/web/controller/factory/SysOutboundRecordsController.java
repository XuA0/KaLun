package com.ruoyi.web.controller.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.domain.SysOutboundGoods;
import com.ruoyi.system.service.ISysCustomerService;
import com.ruoyi.system.service.ISysGoodsService;
import com.ruoyi.system.service.ISysOutboundGoodsService;
import com.ruoyi.web.resp.SysCustomerResp;
import com.ruoyi.web.resp.SysOutboundRecordResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
public class SysOutboundRecordsController extends BaseController {
    private String prefix = "system/outBoundRecords";

    @Autowired
    private ISysOutboundRecordsService sysOutboundRecordsService;

    @Autowired
    private ISysOutboundGoodsService sysOutboundGoodsService;

    @Autowired
    private ISysCustomerService sysCustomerService;

    @Autowired
    private ISysGoodsService sysGoodsService;

    @RequiresPermissions("system:outBoundRecords:view")
    @GetMapping()
    public String records() {
        return prefix + "/outBoundRecords";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundRecords:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOutboundRecords sysOutboundRecords) {
        startPage();
        List<SysOutboundRecords> list = sysOutboundRecordsService.selectSysOutboundRecordsList(sysOutboundRecords);
        List<SysOutboundRecordResp> resp = list.stream().map(item -> {
            SysOutboundRecordResp sysOutboundRecordResp = new SysOutboundRecordResp();
            BeanUtils.copyProperties(item, sysOutboundRecordResp);
            SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(item.getCustomerId());
            List<SysOutboundGoods> sysOutboundGoodsList = sysOutboundGoodsService.selectSysOutboundGoodsListByOutBoundId(item.getId());
            StringBuilder builder = new StringBuilder("商品  单价  数量  金额 <br>");
            sysOutboundGoodsList.forEach(outboundGoods -> {
                SysGoods sysGoods = sysGoodsService.selectSysGoodsById(outboundGoods.getGoodsId());
                builder.append(sysGoods.getName()).append(" ")
                        .append(outboundGoods.getPrice()).append(" ")
                        .append(outboundGoods.getCount()).append(" ")
                        .append(outboundGoods.getPriceTotal()).append("</br>");
            });
            StringBuilder returnBuilder = new StringBuilder("商品  单价  数量  金额 <br>");
            sysOutboundRecordResp.setCustomerName(sysCustomer.getName());
            sysOutboundRecordResp.setGoodListString(builder.toString());
            sysOutboundRecordResp.setCaseCountString("新：" + item.getCaseCountNew() + "</br>旧：" + item.getCaseCountOld());
            sysOutboundRecordResp.setReturnCaseString("新：" + item.getReturnCaseNew() + "</br>旧：" + item.getReturnCaseOld());
            sysOutboundRecordResp.setReturnGoodString(returnBuilder.toString());
            return sysOutboundRecordResp;
        }).collect(Collectors.toList());

        return getDataTable(resp);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:outBoundRecords:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOutboundRecords sysOutboundRecords) {
        List<SysOutboundRecords> list = sysOutboundRecordsService.selectSysOutboundRecordsList(sysOutboundRecords);
        ExcelUtil<SysOutboundRecords> util = new ExcelUtil<SysOutboundRecords>(SysOutboundRecords.class);
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
    @RequiresPermissions("system:outBoundRecords:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult addSave(@RequestParam Map<String, Object> input) {
        //插入出库记录
        Long customerId = new Long(input.get("customerId").toString());
        Long caseCountOld = new Long(input.get("caseCountOld").toString());
        Long caseCountNew = new Long(input.get("caseCountNew").toString());
        String comment = input.get("comment").toString();
        String day = input.get("day").toString();
        SysOutboundRecords sysOutboundRecords = new SysOutboundRecords();
        sysOutboundRecords.setCaseCountNew(caseCountNew);
        sysOutboundRecords.setCaseCountOld(caseCountOld);
        sysOutboundRecords.setDay(day);
        sysOutboundRecords.setComment(comment);
        sysOutboundRecords.setTimestamp(System.currentTimeMillis());
        sysOutboundRecords.setCustomerId(customerId);
        sysOutboundRecordsService.insertSysOutboundRecords(sysOutboundRecords);
        Long id = sysOutboundRecords.getId();

        //生成商品出库记录
        input.keySet().forEach(key -> {
            if (key.startsWith("good_number_")) {
                Long goodId = new Long(key.substring(12));
                Double price = new Double(input.get("good_price_" + goodId).toString());
                Long number = new Long(input.get("good_number_" + goodId).toString());
                if (number == 0) {
                    return;
                }
                Double total = price * number;
                SysOutboundGoods sysOutboundGoods = new SysOutboundGoods();
                sysOutboundGoods.setOutboundId(id);
                sysOutboundGoods.setGoodsId(goodId);
                sysOutboundGoods.setCount(number);
                sysOutboundGoods.setPrice(price);
                sysOutboundGoods.setPriceTotal(total);
                sysOutboundGoodsService.insertSysOutboundGoods(sysOutboundGoods);
            }
        });
        return toAjax(1);
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
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
    public AjaxResult editSave(SysOutboundRecords sysOutboundRecords) {
        return toAjax(sysOutboundRecordsService.updateSysOutboundRecords(sysOutboundRecords));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:outBoundRecords:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysOutboundRecordsService.deleteSysOutboundRecordsByIds(ids));
    }
}
