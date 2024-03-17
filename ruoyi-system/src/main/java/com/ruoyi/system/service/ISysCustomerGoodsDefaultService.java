package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCustomerGoodsDefault;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public interface ISysCustomerGoodsDefaultService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysCustomerGoodsDefault selectSysCustomerGoodsDefaultByCustomerId(Long customerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysCustomerGoodsDefault> selectSysCustomerGoodsDefaultList(SysCustomerGoodsDefault sysCustomerGoodsDefault);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 结果
     */
    public int insertSysCustomerGoodsDefault(SysCustomerGoodsDefault sysCustomerGoodsDefault);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCustomerGoodsDefault 【请填写功能名称】
     * @return 结果
     */
    public int updateSysCustomerGoodsDefault(SysCustomerGoodsDefault sysCustomerGoodsDefault);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysCustomerGoodsDefaultByCustomerIds(String customerIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param customerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysCustomerGoodsDefaultByCustomerId(Long customerId);
}
