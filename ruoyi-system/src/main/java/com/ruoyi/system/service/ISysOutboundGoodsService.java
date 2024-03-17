package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysOutboundGoods;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public interface ISysOutboundGoodsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param outboundId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysOutboundGoods selectSysOutboundGoodsByOutboundId(Long outboundId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysOutboundGoods> selectSysOutboundGoodsList(SysOutboundGoods sysOutboundGoods);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 结果
     */
    public int insertSysOutboundGoods(SysOutboundGoods sysOutboundGoods);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 结果
     */
    public int updateSysOutboundGoods(SysOutboundGoods sysOutboundGoods);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param outboundIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysOutboundGoodsByOutboundIds(String outboundIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param outboundId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysOutboundGoodsByOutboundId(Long outboundId);
}
