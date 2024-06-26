package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCustomer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
@Mapper
public interface SysCustomerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysCustomer selectSysCustomerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    public int insertSysCustomer(SysCustomer sysCustomer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysCustomer 【请填写功能名称】
     * @return 结果
     */
    public int updateSysCustomer(SysCustomer sysCustomer);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysCustomerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCustomerByIds(String[] ids);
}
