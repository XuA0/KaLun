package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysReturnGoods;

/**
 * 退菜Mapper接口
 *
 * @author ruoyi
 * @date 2024-03-23
 */
public interface SysReturnGoodsMapper
{
    /**
     * 查询退菜
     *
     * @param outboundId 退菜主键
     * @return 退菜
     */
    public SysReturnGoods selectSysReturnGoodsByOutboundId(Long outboundId);

    /**
     * 查询退菜列表
     *
     * @param sysReturnGoods 退菜
     * @return 退菜集合
     */
    public List<SysReturnGoods> selectSysReturnGoodsList(SysReturnGoods sysReturnGoods);

    /**
     * 新增退菜
     *
     * @param sysReturnGoods 退菜
     * @return 结果
     */
    public int insertSysReturnGoods(SysReturnGoods sysReturnGoods);

    /**
     * 修改退菜
     *
     * @param sysReturnGoods 退菜
     * @return 结果
     */
    public int updateSysReturnGoods(SysReturnGoods sysReturnGoods);

    /**
     * 删除退菜
     *
     * @param outboundId 退菜主键
     * @return 结果
     */
    public int deleteSysReturnGoodsByOutboundId(Long outboundId);

    /**
     * 批量删除退菜
     *
     * @param outboundIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysReturnGoodsByOutboundIds(String[] outboundIds);
}
