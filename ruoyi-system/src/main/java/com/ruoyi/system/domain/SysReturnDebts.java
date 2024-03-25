package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 sys_return_debts
 *
 * @author ruoyi
 * @date 2024-03-25
 */
public class SysReturnDebts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long customerId;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private BigDecimal amount;

    /**
     * 来源
     */
    @Excel(name = "来源")
    private String origin;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Long timestamp;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String comment;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("customerId", getCustomerId())
                .append("amount", getAmount())
                .append("origin", getOrigin())
                .append("timestamp", getTimestamp())
                .append("comment", getComment())
                .toString();
    }
}
