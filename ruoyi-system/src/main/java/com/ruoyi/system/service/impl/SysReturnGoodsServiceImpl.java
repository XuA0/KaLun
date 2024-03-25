package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysOutboundGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysReturnGoodsMapper;
import com.ruoyi.system.domain.SysReturnGoods;
import com.ruoyi.system.service.ISysReturnGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 退菜Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-23
 */
@Service
public class SysReturnGoodsServiceImpl implements ISysReturnGoodsService
{
    @Autowired
    private SysReturnGoodsMapper sysReturnGoodsMapper;

    /**
     * 查询退菜
     *
     * @param outboundId 退菜主键
     * @return 退菜
     */
    @Override
    public SysReturnGoods selectSysReturnGoodsByOutboundId(Long outboundId)
    {
        return sysReturnGoodsMapper.selectSysReturnGoodsByOutboundId(outboundId);
    }

    /**
     * 查询退菜列表
     *
     * @param sysReturnGoods 退菜
     * @return 退菜
     */
    @Override
    public List<SysReturnGoods> selectSysReturnGoodsList(SysReturnGoods sysReturnGoods)
    {
        return sysReturnGoodsMapper.selectSysReturnGoodsList(sysReturnGoods);
    }

    /**
     * 新增退菜
     *
     * @param sysReturnGoods 退菜
     * @return 结果
     */
    @Override
    public int insertSysReturnGoods(SysReturnGoods sysReturnGoods)
    {
        return sysReturnGoodsMapper.insertSysReturnGoods(sysReturnGoods);
    }

    /**
     * 修改退菜
     *
     * @param sysReturnGoods 退菜
     * @return 结果
     */
    @Override
    public int updateSysReturnGoods(SysReturnGoods sysReturnGoods)
    {
        return sysReturnGoodsMapper.updateSysReturnGoods(sysReturnGoods);
    }

    /**
     * 批量删除退菜
     *
     * @param outboundIds 需要删除的退菜主键
     * @return 结果
     */
    @Override
    public int deleteSysReturnGoodsByOutboundIds(String outboundIds)
    {
        return sysReturnGoodsMapper.deleteSysReturnGoodsByOutboundIds(Convert.toStrArray(outboundIds));
    }

    /**
     * 删除退菜信息
     *
     * @param outboundId 退菜主键
     * @return 结果
     */
    @Override
    public int deleteSysReturnGoodsByOutboundId(Long outboundId)
    {
        return sysReturnGoodsMapper.deleteSysReturnGoodsByOutboundId(outboundId);
    }

    @Override
    public List<SysReturnGoods> selectSysReturnGoodsListByOutBoundId(Long id) {
        SysReturnGoods sysReturnGoods = new SysReturnGoods();
        sysReturnGoods.setOutboundId(id);
        return this.selectSysReturnGoodsList(sysReturnGoods);
    }
}
