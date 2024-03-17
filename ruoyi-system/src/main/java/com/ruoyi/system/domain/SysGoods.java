package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_goods
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public class SysGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 多少数量用一个框 */
    @Excel(name = "多少数量用一个框")
    private Long caseRatio;

    /** 默认价格 */
    @Excel(name = "默认价格")
    private Long defaultPrice;

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
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setCaseRatio(Long caseRatio) 
    {
        this.caseRatio = caseRatio;
    }

    public Long getCaseRatio() 
    {
        return caseRatio;
    }
    public void setDefaultPrice(Long defaultPrice) 
    {
        this.defaultPrice = defaultPrice;
    }

    public Long getDefaultPrice() 
    {
        return defaultPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("unit", getUnit())
            .append("caseRatio", getCaseRatio())
            .append("defaultPrice", getDefaultPrice())
            .toString();
    }
}
