package com.ruoyi.web.controller.factory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.exception.GlobalException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.web.resp.SysOutboundGoodResp;
import com.ruoyi.web.resp.SysOutboundRecordResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
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
    private ISysReturnGoodsService sysReturnGoodsService;

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
            StringBuilder builder = new StringBuilder("<table class=\"goods\"><tr><td>商品</td><td>单价</td><td>数量</td><td>金额</td></tr>");
            sysOutboundGoodsList.forEach(outboundGoods -> {
                SysGoods sysGoods = sysGoodsService.selectSysGoodsById(outboundGoods.getGoodsId());
                builder.append("<tr><td>")
                        .append(sysGoods.getName()).append("</td><td>")
                        .append(outboundGoods.getPrice()).append("</td><td>")
                        .append(outboundGoods.getCount()).append("</td><td>")
                        .append(outboundGoods.getPriceTotal()).append("</td></tr>");
            });
            builder.append("</table>");

            sysOutboundRecordResp.setCustomerName(sysCustomer.getName());
            sysOutboundRecordResp.setGoodListString(builder.toString());
            sysOutboundRecordResp.setCaseCountString("<table class=\"goods\"><tr><td>新框</td><td>旧框</td></tr>" +
                    "<tr><td>" + item.getCaseCountNew() + "</td><td>" + item.getCaseCountOld() + "</td></tr></table>");
            sysOutboundRecordResp.setReturnCaseString("<table class=\"goods\"><tr><td>新框</td><td>旧框</td></tr>" +
                    "<tr><td>" + item.getReturnCaseNew() + "</td><td>" + item.getReturnCaseOld() + "</td></tr></table>");

            List<SysReturnGoods> sysReturnGoodsList = sysReturnGoodsService.selectSysReturnGoodsListByOutBoundId(item.getId());

            StringBuilder returnBuilder = new StringBuilder("<table class=\"goods\"><tr><td>商品</td><td>单价</td><td>数量</td><td>金额</td></tr>");
            sysReturnGoodsList.forEach(returnGoods -> {
                SysGoods sysGoods = sysGoodsService.selectSysGoodsById(returnGoods.getGoodsId());
                returnBuilder.append("<tr><td>")
                        .append(sysGoods.getName()).append("</td><td>")
                        .append(returnGoods.getPrice()).append("</td><td>")
                        .append(returnGoods.getCount()).append("</td><td>")
                        .append(returnGoods.getPriceTotal()).append("</td></tr>");
            });
            returnBuilder.append("</table>");
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
        BigDecimal priceTotal = new BigDecimal(input.get("priceTotal").toString());
        SysOutboundRecords sysOutboundRecords = new SysOutboundRecords();
        sysOutboundRecords.setCaseCountNew(caseCountNew);
        sysOutboundRecords.setCaseCountOld(caseCountOld);
        sysOutboundRecords.setDay(day);
        sysOutboundRecords.setComment(comment);
        sysOutboundRecords.setTimestamp(System.currentTimeMillis());
        sysOutboundRecords.setCustomerId(customerId);
        sysOutboundRecords.setPriceTotal(priceTotal);
        sysOutboundRecordsService.insertSysOutboundRecords(sysOutboundRecords);
        Long id = sysOutboundRecords.getId();
        sysCustomerService.outBound(customerId, caseCountNew, caseCountOld, priceTotal);

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


    @RequiresPermissions("system:outBoundRecords:edit")
    @GetMapping("/returnCase/{id}")
    public String returnCase(@PathVariable("id") Long id, ModelMap mmap) {
        SysOutboundRecords sysOutboundRecords = sysOutboundRecordsService.selectSysOutboundRecordsById(id);
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(sysOutboundRecords.getCustomerId());
        mmap.put("sysOutboundRecords", sysOutboundRecords);
        mmap.put("sysCustomer", sysCustomer);
        return prefix + "/returnCase";
    }

    @RequiresPermissions("system:outBoundRecords:edit")
    @Log(title = "还框", businessType = BusinessType.UPDATE)
    @PostMapping("/returnCase")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult returnCase(@RequestParam Map<String, Object> input) {
        Long outBoundRecordId = new Long(input.get("outBoundRecordId").toString());
        Long returnCaseNew = new Long(input.get("returnCaseNew").toString());
        Long returnCaseOld = new Long(input.get("returnCaseOld").toString());
        SysOutboundRecords sysOutboundRecords = sysOutboundRecordsService.selectSysOutboundRecordsById(outBoundRecordId);

        if (sysOutboundRecords.getReturnCaseNew() != 0 || sysOutboundRecords.getReturnCaseOld() != 0) {
            throw new GlobalException("一条出库记录退框只能退一次");
        }

        sysOutboundRecords.setReturnCaseNew(returnCaseNew);
        sysOutboundRecords.setReturnCaseOld(returnCaseOld);
        sysOutboundRecordsService.updateSysOutboundRecords(sysOutboundRecords);
        //从用户层面扣除
        sysCustomerService.returnCase(sysOutboundRecords.getCustomerId(), returnCaseNew, returnCaseOld);
        System.out.println(JSON.toJSON(input));
        return toAjax(1);
    }


    @RequiresPermissions("system:outBoundRecords:edit")
    @GetMapping("/returnGoods/{id}")
    public String returnGoods(@PathVariable("id") Long id, ModelMap mmap) {
        SysOutboundRecords sysOutboundRecords = sysOutboundRecordsService.selectSysOutboundRecordsById(id);
        SysCustomer sysCustomer = sysCustomerService.selectSysCustomerById(sysOutboundRecords.getCustomerId());
        List<SysOutboundGoods> sysOutboundGoodsList = sysOutboundGoodsService.selectSysOutboundGoodsListByOutBoundId(sysOutboundRecords.getId());
        List<SysOutboundGoodResp> sysOutboundGoodResps = sysOutboundGoodsList.stream().map(item -> {
            SysOutboundGoodResp sysOutboundGoodResp = new SysOutboundGoodResp();
            BeanUtils.copyProperties(item, sysOutboundGoodResp);
            SysGoods sysGoods = sysGoodsService.selectSysGoodsById(item.getGoodsId());
            if (sysGoods != null) {
                sysOutboundGoodResp.setGoodName(sysGoods.getName());
            }
            return sysOutboundGoodResp;
        }).collect(Collectors.toList());
        mmap.put("sysOutboundRecords", sysOutboundRecords);
        mmap.put("sysCustomer", sysCustomer);
        mmap.put("sysOutboundGoodResps", sysOutboundGoodResps);
        return prefix + "/returnGoods";
    }

    @RequiresPermissions("system:outBoundRecords:edit")
    @Log(title = "还框", businessType = BusinessType.UPDATE)
    @PostMapping("/returnGoods")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult returnGoods(@RequestParam Map<String, Object> input) {
        Long outBoundRecordId = new Long(input.get("outBoundRecordId").toString());
        List<SysReturnGoods> sysReturnGoodsList = sysReturnGoodsService.selectSysReturnGoodsListByOutBoundId(outBoundRecordId);
        if (!CollectionUtils.isEmpty(sysReturnGoodsList)) {
            throw new GlobalException("退菜只能退一次！");
        }

        SysOutboundRecords sysOutboundRecords = sysOutboundRecordsService.selectSysOutboundRecordsById(outBoundRecordId);
        AtomicReference<Double> returnTotal = new AtomicReference<>(0D);
        input.keySet().forEach(key -> {
            if (key.startsWith("good_number_")) {
                Long goodId = new Long(key.substring(12));
                SysOutboundGoods sysOutboundGoods = sysOutboundGoodsService.selectSysOutboundGoodsByOutboundIdAndGoodId(outBoundRecordId, goodId);
                Double price = sysOutboundGoods.getPrice();
                Long number = new Long(input.get("good_number_" + goodId).toString());
                if (number == 0) {
                    return;
                }
                Double total = price * number;
                SysReturnGoods sysReturnGoods = new SysReturnGoods();
                sysReturnGoods.setOutboundId(outBoundRecordId);
                sysReturnGoods.setGoodsId(goodId);
                sysReturnGoods.setCount(number);
                sysReturnGoods.setPrice(price);
                sysReturnGoods.setPriceTotal(total);
                sysReturnGoodsService.insertSysReturnGoods(sysReturnGoods);
                returnTotal.updateAndGet(v -> v + total);
            }
        });
        sysOutboundRecords.setPriceTotal(sysOutboundRecords.getPriceTotal().subtract(BigDecimal.valueOf(returnTotal.get())));
        sysOutboundRecordsService.updateSysOutboundRecords(sysOutboundRecords);
        sysCustomerService.returnGoods(sysOutboundRecords.getCustomerId(),BigDecimal.valueOf(returnTotal.get()));
        System.out.println(JSON.toJSON(input));
        return toAjax(1);
    }
}
