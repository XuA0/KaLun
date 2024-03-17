package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_outbound_records
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public class SysOutboundRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 顾客id */
    @Excel(name = "顾客id")
    private Long customerId;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long timestamp;

    /** 日期 */
    @Excel(name = "日期")
    private String day;

    /** 用框数量 */
    @Excel(name = "用框数量")
    private Long caseCount;

    /** 货款 */
    @Excel(name = "货款")
    private Long priceTotal;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setTimestamp(Long timestamp) 
    {
        this.timestamp = timestamp;
    }

    public Long getTimestamp() 
    {
        return timestamp;
    }
    public void setDay(String day) 
    {
        this.day = day;
    }

    public String getDay() 
    {
        return day;
    }
    public void setCaseCount(Long caseCount) 
    {
        this.caseCount = caseCount;
    }

    public Long getCaseCount() 
    {
        return caseCount;
    }
    public void setPriceTotal(Long priceTotal) 
    {
        this.priceTotal = priceTotal;
    }

    public Long getPriceTotal() 
    {
        return priceTotal;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerId", getCustomerId())
            .append("timestamp", getTimestamp())
            .append("day", getDay())
            .append("caseCount", getCaseCount())
            .append("priceTotal", getPriceTotal())
            .append("comment", getComment())
            .toString();
    }
}
