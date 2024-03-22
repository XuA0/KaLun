package com.ruoyi.web.resp;

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
public class SysCustomerResp {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;


    @Excel(name = "累计欠框（新）")
    private Long underFrameNew;

    @Excel(name = "累计欠框（旧）")
    private Long underFrameOld;

    public Long getUnderFrameNew() {
        return underFrameNew;
    }

    public void setUnderFrameNew(Long underFrameNew) {
        this.underFrameNew = underFrameNew;
    }

    public Long getUnderFrameOld() {
        return underFrameOld;
    }

    public void setUnderFrameOld(Long underFrameOld) {
        this.underFrameOld = underFrameOld;
    }

    /**
     * 累计欠款
     */
    @Excel(name = "累计欠款")
    private Double debts;

    @Excel(name = "累计欠款（含新框）")
    private Double debtsAll;

    public Double getDebtsAll() {
        return debtsAll;
    }

    public void setDebtsAll(Double debtsAll) {
        this.debtsAll = debtsAll;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setDebts(Double debts) {
        this.debts = debts;
    }

    public Double getDebts() {
        return debts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("underFrameNew", getUnderFrameNew())
                .append("underFrameOld", getUnderFrameOld())
                .append("debts", getDebts())
                .toString();
    }
}
