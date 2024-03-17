package com.ruoyi.system.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGoodsMapper;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.service.ISysGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-17
 */
@Service("SysGoodsServiceImpl")
public class SysGoodsServiceImpl implements ISysGoodsService {
    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysGoods selectSysGoodsById(Long id) {
        return sysGoodsMapper.selectSysGoodsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysGoods 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods) {
        return sysGoodsMapper.selectSysGoodsList(sysGoods);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysGoods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysGoods(SysGoods sysGoods) {
        return sysGoodsMapper.insertSysGoods(sysGoods);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysGoods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysGoods(SysGoods sysGoods) {
        return sysGoodsMapper.updateSysGoods(sysGoods);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysGoodsByIds(String ids) {
        return sysGoodsMapper.deleteSysGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysGoodsById(Long id) {
        return sysGoodsMapper.deleteSysGoodsById(id);
    }
}
