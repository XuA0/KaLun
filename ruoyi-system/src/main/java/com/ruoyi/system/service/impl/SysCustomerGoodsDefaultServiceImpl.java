package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCustomerGoodsDefaultMapper;
import com.ruoyi.system.domain.SysCustomerGoodsDefault;
import com.ruoyi.system.service.ISysCustomerGoodsDefaultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
@Service
public class SysCustomerGoodsDefaultServiceImpl implements ISysCustomerGoodsDefaultService 
{
    @Autowired
    private SysCustomerGoodsDefaultMapper sysCustomerGoodsDefaultMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysCustomerGoodsDefault selectSysCustomerGoodsDefaultByCustomerId(Long customerId)
    {
        return sysCustomerGoodsDefaultMapper.selectSysCustomerGoodsDefaultByCustomerId(customerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysCustomerGoodsDefault> selectSysCustomerGoodsDefaultList(SysCustomerGoodsDefault sysCustomerGoodsDefault)
    {
        return sysCustomerGoodsDefaultMapper.selectSysCustomerGoodsDefaultList(sysCustomerGoodsDefault);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysCustomerGoodsDefault(SysCustomerGoodsDefault sysCustomerGoodsDefault)
    {
        return sysCustomerGoodsDefaultMapper.insertSysCustomerGoodsDefault(sysCustomerGoodsDefault);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysCustomerGoodsDefault(SysCustomerGoodsDefault sysCustomerGoodsDefault)
    {
        return sysCustomerGoodsDefaultMapper.updateSysCustomerGoodsDefault(sysCustomerGoodsDefault);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerGoodsDefaultByCustomerIds(String customerIds)
    {
        return sysCustomerGoodsDefaultMapper.deleteSysCustomerGoodsDefaultByCustomerIds(Convert.toStrArray(customerIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysCustomerGoodsDefaultByCustomerId(Long customerId)
    {
        return sysCustomerGoodsDefaultMapper.deleteSysCustomerGoodsDefaultByCustomerId(customerId);
    }
}
