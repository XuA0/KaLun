package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysReturnDebtsMapper;
import com.ruoyi.system.domain.SysReturnDebts;
import com.ruoyi.system.service.ISysReturnDebtsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-25
 */
@Service
public class SysReturnDebtsServiceImpl implements ISysReturnDebtsService
{
    @Autowired
    private SysReturnDebtsMapper sysReturnDebtsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysReturnDebts selectSysReturnDebtsById(Long id)
    {
        return sysReturnDebtsMapper.selectSysReturnDebtsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysReturnDebts 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysReturnDebts> selectSysReturnDebtsList(SysReturnDebts sysReturnDebts)
    {
        return sysReturnDebtsMapper.selectSysReturnDebtsList(sysReturnDebts);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysReturnDebts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysReturnDebts(SysReturnDebts sysReturnDebts)
    {
        return sysReturnDebtsMapper.insertSysReturnDebts(sysReturnDebts);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysReturnDebts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysReturnDebts(SysReturnDebts sysReturnDebts)
    {
        return sysReturnDebtsMapper.updateSysReturnDebts(sysReturnDebts);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysReturnDebtsByIds(String ids)
    {
        return sysReturnDebtsMapper.deleteSysReturnDebtsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysReturnDebtsById(Long id)
    {
        return sysReturnDebtsMapper.deleteSysReturnDebtsById(id);
    }
}
