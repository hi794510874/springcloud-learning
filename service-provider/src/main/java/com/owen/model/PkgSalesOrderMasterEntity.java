package com.owen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PkgSalesOrderMasterEntity implements Serializable {
    private Integer salesorderno;

    private Integer ordertype;

    private Integer resourcecategory;

    private String pkgorderno;

    private String orderby;

    private Date orderdate;

    private Integer refsono;

    private String fromip;

    private BigDecimal totalamount;

    private String currency;

    private Boolean iscancelled;

    private Integer cancelid;

    private String limation;

    private String modifiedby;

    private Date modifieddate;

    private Long resourceid;

    private String remark;

    private Boolean iscofirmedimmediately;

    private String resourceremark;

    private String usagenotice;

    private String operationcaution;

    private Short isgiveup;

    private Short resourcefromflag;

    private static final long serialVersionUID = 1L;

    public Integer getSalesorderno() {
        return salesorderno;
    }

    public void setSalesorderno(Integer salesorderno) {
        this.salesorderno = salesorderno;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getResourcecategory() {
        return resourcecategory;
    }

    public void setResourcecategory(Integer resourcecategory) {
        this.resourcecategory = resourcecategory;
    }

    public String getPkgorderno() {
        return pkgorderno;
    }

    public void setPkgorderno(String pkgorderno) {
        this.pkgorderno = pkgorderno == null ? null : pkgorderno.trim();
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby == null ? null : orderby.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getRefsono() {
        return refsono;
    }

    public void setRefsono(Integer refsono) {
        this.refsono = refsono;
    }

    public String getFromip() {
        return fromip;
    }

    public void setFromip(String fromip) {
        this.fromip = fromip == null ? null : fromip.trim();
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Boolean getIscancelled() {
        return iscancelled;
    }

    public void setIscancelled(Boolean iscancelled) {
        this.iscancelled = iscancelled;
    }

    public Integer getCancelid() {
        return cancelid;
    }

    public void setCancelid(Integer cancelid) {
        this.cancelid = cancelid;
    }

    public String getLimation() {
        return limation;
    }

    public void setLimation(String limation) {
        this.limation = limation == null ? null : limation.trim();
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby == null ? null : modifiedby.trim();
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIscofirmedimmediately() {
        return iscofirmedimmediately;
    }

    public void setIscofirmedimmediately(Boolean iscofirmedimmediately) {
        this.iscofirmedimmediately = iscofirmedimmediately;
    }

    public String getResourceremark() {
        return resourceremark;
    }

    public void setResourceremark(String resourceremark) {
        this.resourceremark = resourceremark == null ? null : resourceremark.trim();
    }

    public String getUsagenotice() {
        return usagenotice;
    }

    public void setUsagenotice(String usagenotice) {
        this.usagenotice = usagenotice == null ? null : usagenotice.trim();
    }

    public String getOperationcaution() {
        return operationcaution;
    }

    public void setOperationcaution(String operationcaution) {
        this.operationcaution = operationcaution == null ? null : operationcaution.trim();
    }

    public Short getIsgiveup() {
        return isgiveup;
    }

    public void setIsgiveup(Short isgiveup) {
        this.isgiveup = isgiveup;
    }

    public Short getResourcefromflag() {
        return resourcefromflag;
    }

    public void setResourcefromflag(Short resourcefromflag) {
        this.resourcefromflag = resourcefromflag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PkgSalesOrderMasterEntity other = (PkgSalesOrderMasterEntity) that;
        return (this.getSalesorderno() == null ? other.getSalesorderno() == null : this.getSalesorderno().equals(other.getSalesorderno()))
            && (this.getOrdertype() == null ? other.getOrdertype() == null : this.getOrdertype().equals(other.getOrdertype()))
            && (this.getResourcecategory() == null ? other.getResourcecategory() == null : this.getResourcecategory().equals(other.getResourcecategory()))
            && (this.getPkgorderno() == null ? other.getPkgorderno() == null : this.getPkgorderno().equals(other.getPkgorderno()))
            && (this.getOrderby() == null ? other.getOrderby() == null : this.getOrderby().equals(other.getOrderby()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getRefsono() == null ? other.getRefsono() == null : this.getRefsono().equals(other.getRefsono()))
            && (this.getFromip() == null ? other.getFromip() == null : this.getFromip().equals(other.getFromip()))
            && (this.getTotalamount() == null ? other.getTotalamount() == null : this.getTotalamount().equals(other.getTotalamount()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getIscancelled() == null ? other.getIscancelled() == null : this.getIscancelled().equals(other.getIscancelled()))
            && (this.getCancelid() == null ? other.getCancelid() == null : this.getCancelid().equals(other.getCancelid()))
            && (this.getLimation() == null ? other.getLimation() == null : this.getLimation().equals(other.getLimation()))
            && (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
            && (this.getModifieddate() == null ? other.getModifieddate() == null : this.getModifieddate().equals(other.getModifieddate()))
            && (this.getResourceid() == null ? other.getResourceid() == null : this.getResourceid().equals(other.getResourceid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getIscofirmedimmediately() == null ? other.getIscofirmedimmediately() == null : this.getIscofirmedimmediately().equals(other.getIscofirmedimmediately()))
            && (this.getResourceremark() == null ? other.getResourceremark() == null : this.getResourceremark().equals(other.getResourceremark()))
            && (this.getUsagenotice() == null ? other.getUsagenotice() == null : this.getUsagenotice().equals(other.getUsagenotice()))
            && (this.getOperationcaution() == null ? other.getOperationcaution() == null : this.getOperationcaution().equals(other.getOperationcaution()))
            && (this.getIsgiveup() == null ? other.getIsgiveup() == null : this.getIsgiveup().equals(other.getIsgiveup()))
            && (this.getResourcefromflag() == null ? other.getResourcefromflag() == null : this.getResourcefromflag().equals(other.getResourcefromflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSalesorderno() == null) ? 0 : getSalesorderno().hashCode());
        result = prime * result + ((getOrdertype() == null) ? 0 : getOrdertype().hashCode());
        result = prime * result + ((getResourcecategory() == null) ? 0 : getResourcecategory().hashCode());
        result = prime * result + ((getPkgorderno() == null) ? 0 : getPkgorderno().hashCode());
        result = prime * result + ((getOrderby() == null) ? 0 : getOrderby().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getRefsono() == null) ? 0 : getRefsono().hashCode());
        result = prime * result + ((getFromip() == null) ? 0 : getFromip().hashCode());
        result = prime * result + ((getTotalamount() == null) ? 0 : getTotalamount().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getIscancelled() == null) ? 0 : getIscancelled().hashCode());
        result = prime * result + ((getCancelid() == null) ? 0 : getCancelid().hashCode());
        result = prime * result + ((getLimation() == null) ? 0 : getLimation().hashCode());
        result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
        result = prime * result + ((getModifieddate() == null) ? 0 : getModifieddate().hashCode());
        result = prime * result + ((getResourceid() == null) ? 0 : getResourceid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIscofirmedimmediately() == null) ? 0 : getIscofirmedimmediately().hashCode());
        result = prime * result + ((getResourceremark() == null) ? 0 : getResourceremark().hashCode());
        result = prime * result + ((getUsagenotice() == null) ? 0 : getUsagenotice().hashCode());
        result = prime * result + ((getOperationcaution() == null) ? 0 : getOperationcaution().hashCode());
        result = prime * result + ((getIsgiveup() == null) ? 0 : getIsgiveup().hashCode());
        result = prime * result + ((getResourcefromflag() == null) ? 0 : getResourcefromflag().hashCode());
        return result;
    }
}