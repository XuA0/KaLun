package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGoods;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
@Mapper
public interface SysGoodsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysGoods selectSysGoodsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysGoods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysGoods 【请填写功能名称】
     * @return 结果
     */
    public int insertSysGoods(SysGoods sysGoods);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysGoods 【请填写功能名称】
     * @return 结果
     */
    public int updateSysGoods(SysGoods sysGoods);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysGoodsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysGoodsByIds(String[] ids);
}
