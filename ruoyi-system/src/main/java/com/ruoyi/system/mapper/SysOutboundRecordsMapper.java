package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysOutboundRecords;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-03-17
 */
public interface SysOutboundRecordsMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysOutboundRecords selectSysOutboundRecordsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysOutboundRecords> selectSysOutboundRecordsList(SysOutboundRecords sysOutboundRecords);

    /**
     * 新增【请填写功能名称】
     *
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 结果
     */
    public int insertSysOutboundRecords(SysOutboundRecords sysOutboundRecords);

    /**
     * 修改【请填写功能名称】
     *
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 结果
     */
    public int updateSysOutboundRecords(SysOutboundRecords sysOutboundRecords);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysOutboundRecordsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysOutboundRecordsByIds(String[] ids);
}
