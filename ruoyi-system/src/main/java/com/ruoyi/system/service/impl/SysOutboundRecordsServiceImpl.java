package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysOutboundRecordsMapper;
import com.ruoyi.system.domain.SysOutboundRecords;
import com.ruoyi.system.service.ISysOutboundRecordsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
@Service
public class SysOutboundRecordsServiceImpl implements ISysOutboundRecordsService 
{
    @Autowired
    private SysOutboundRecordsMapper sysOutboundRecordsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysOutboundRecords selectSysOutboundRecordsById(Long id)
    {
        return sysOutboundRecordsMapper.selectSysOutboundRecordsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysOutboundRecords> selectSysOutboundRecordsList(SysOutboundRecords sysOutboundRecords)
    {
        return sysOutboundRecordsMapper.selectSysOutboundRecordsList(sysOutboundRecords);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysOutboundRecords(SysOutboundRecords sysOutboundRecords)
    {
        return sysOutboundRecordsMapper.insertSysOutboundRecords(sysOutboundRecords);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysOutboundRecords 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysOutboundRecords(SysOutboundRecords sysOutboundRecords)
    {
        return sysOutboundRecordsMapper.updateSysOutboundRecords(sysOutboundRecords);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysOutboundRecordsByIds(String ids)
    {
        return sysOutboundRecordsMapper.deleteSysOutboundRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysOutboundRecordsById(Long id)
    {
        return sysOutboundRecordsMapper.deleteSysOutboundRecordsById(id);
    }
}
