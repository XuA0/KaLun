package com.ruoyi.web.resp;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SysOutboundGoodResp {
    private static final long serialVersionUID = 1L;

    /**
     * 出库记录id
     */
    @Excel(name = "出库记录id")
    private Long outboundId;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long goodsId;

    /**
     * 数量
     */
    @Excel(name = "数量")
    private Long count;

    /**
     * 总价格
     */
    @Excel(name = "总价格")
    private Double priceTotal;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private Double price;

    /**
     * 用框数
     */
    @Excel(name = "用框数")
    private Long caseTotal;

    private String goodName;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setOutboundId(Long outboundId) {
        this.outboundId = outboundId;
    }

    public Long getOutboundId() {
        return outboundId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setCaseTotal(Long caseTotal) {
        this.caseTotal = caseTotal;
    }

    public Long getCaseTotal() {
        return caseTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("outboundId", getOutboundId())
                .append("goodsId", getGoodsId())
                .append("count", getCount())
                .append("priceTotal", getPriceTotal())
                .append("price", getPrice())
                .append("caseTotal", getCaseTotal())
                .toString();
    }
}
