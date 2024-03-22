package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysOutboundGoodsMapper;
import com.ruoyi.system.domain.SysOutboundGoods;
import com.ruoyi.system.service.ISysOutboundGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-17
 */
@Service
public class SysOutboundGoodsServiceImpl implements ISysOutboundGoodsService {
    @Autowired
    private SysOutboundGoodsMapper sysOutboundGoodsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param outboundId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysOutboundGoods selectSysOutboundGoodsByOutboundId(Long outboundId) {
        return sysOutboundGoodsMapper.selectSysOutboundGoodsByOutboundId(outboundId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysOutboundGoods> selectSysOutboundGoodsList(SysOutboundGoods sysOutboundGoods) {
        return sysOutboundGoodsMapper.selectSysOutboundGoodsList(sysOutboundGoods);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysOutboundGoods(SysOutboundGoods sysOutboundGoods) {
        return sysOutboundGoodsMapper.insertSysOutboundGoods(sysOutboundGoods);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysOutboundGoods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysOutboundGoods(SysOutboundGoods sysOutboundGoods) {
        return sysOutboundGoodsMapper.updateSysOutboundGoods(sysOutboundGoods);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param outboundIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysOutboundGoodsByOutboundIds(String outboundIds) {
        return sysOutboundGoodsMapper.deleteSysOutboundGoodsByOutboundIds(Convert.toStrArray(outboundIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param outboundId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysOutboundGoodsByOutboundId(Long outboundId) {
        return sysOutboundGoodsMapper.deleteSysOutboundGoodsByOutboundId(outboundId);
    }

    @Override
    public List<SysOutboundGoods> selectSysOutboundGoodsListByOutBoundId(Long id) {
        SysOutboundGoods sysOutboundGoods = new SysOutboundGoods();
        sysOutboundGoods.setOutboundId(id);
        return this.selectSysOutboundGoodsList(sysOutboundGoods);
    }
}
