package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCustomerMapper;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-17
 */
@Service("SysCustomerServiceImpl")
public class SysCustomerServiceImpl implements ISysCustomerService {
    @Autowired
    private SysCustomerMapper sysCustomerMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysCustomer selectSysCustomerById(Long id) {
        return sysCustomerMapper.selectSysCustomerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysCustomer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer) {
        return sysCustomerMapper.selectSysCustomerList(sysCustomer);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysCustomer(SysCustomer sysCustomer) {
        return sysCustomerMapper.insertSysCustomer(sysCustomer);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysCustomer(SysCustomer sysCustomer) {
        return sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerByIds(String ids) {
        return sysCustomerMapper.deleteSysCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerById(Long id) {
        return sysCustomerMapper.deleteSysCustomerById(id);
    }

    @Override
    public void outBound(Long customerId, Long caseCountNew, Long caseCountOld, BigDecimal priceTotal) {
        SysCustomer sysCustomer = sysCustomerMapper.selectSysCustomerById(customerId);
        sysCustomer.setUnderFrameOld(sysCustomer.getUnderFrameOld() + caseCountOld);
        sysCustomer.setUnderFrameNew(sysCustomer.getUnderFrameNew() + caseCountNew);
        sysCustomer.setDebts(sysCustomer.getDebts() + priceTotal.doubleValue());
        sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    @Override
    public void returnCase(Long customerId, Long caseCountNew, Long caseCountOld) {
        SysCustomer sysCustomer = sysCustomerMapper.selectSysCustomerById(customerId);
        sysCustomer.setUnderFrameOld(sysCustomer.getUnderFrameOld() - caseCountOld);
        sysCustomer.setUnderFrameNew(sysCustomer.getUnderFrameNew() - caseCountNew);
        sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    @Override
    public void returnGoods(Long customerId, BigDecimal priceTotal) {
        SysCustomer sysCustomer = sysCustomerMapper.selectSysCustomerById(customerId);
        sysCustomer.setDebts(sysCustomer.getDebts() - priceTotal.doubleValue());
        sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    @Override
    public void returnDebts(Long customerId, BigDecimal returnDebts) {
        SysCustomer sysCustomer = sysCustomerMapper.selectSysCustomerById(customerId);
        sysCustomer.setDebts(sysCustomer.getDebts() - returnDebts.doubleValue());
        sysCustomerMapper.updateSysCustomer(sysCustomer);
    }
}
