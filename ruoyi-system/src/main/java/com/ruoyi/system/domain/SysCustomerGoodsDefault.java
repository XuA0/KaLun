package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_customer_goods_default
 * 
 * @author ruoyi
 * @date 2024-03-17
 */
public class SysCustomerGoodsDefault extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户id */
    @Excel(name = "客户id")
    private Long customerId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsId;

    /** 默认价格 */
    @Excel(name = "默认价格")
    private Long defaultPrice;

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
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
            .append("customerId", getCustomerId())
            .append("goodsId", getGoodsId())
            .append("defaultPrice", getDefaultPrice())
            .toString();
    }
}
