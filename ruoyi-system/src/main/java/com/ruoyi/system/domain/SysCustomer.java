package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_customer
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public class SysCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 累计欠框 */
    @Excel(name = "累计欠框")
    private Long underFrame;

    /** 累计欠款 */
    @Excel(name = "累计欠款")
    private Double debts;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setUnderFrame(Long underFrame) 
    {
        this.underFrame = underFrame;
    }

    public Long getUnderFrame() 
    {
        return underFrame;
    }
    public void setDebts(Double debts)
    {
        this.debts = debts;
    }

    public Double getDebts()
    {
        return debts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("underFrame", getUnderFrame())
            .append("debts", getDebts())
            .toString();
    }
}
