package com.owen.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PkgOrderMasterEntity implements Serializable {
    private String pkgorderno;

    private String verno;

    private Date orderdate;

    private Byte saleschannel;

    private Integer salesorg;

    private Integer custmemberid;

    private String custmembername;

    private Integer packageid;

    private String packagename;

    private Byte orderstatus;

    private String orderby;

    private BigDecimal totalamount;

    private BigDecimal receivedamount;

    private Integer adultqty;

    private Integer childqty;

    private Integer babyqty;

    private String currency;

    private Date lastcfmcustomertime;

    private Byte deliverytpe;

    private Integer motoid;

    private String fromip;

    private Date startdate;

    private Date enddate;

    private String remark;

    private String modifiedby;

    private Date modifieddate;

    private BigDecimal totaldiscount;

    private BigDecimal totalservicefee;

    private BigDecimal totalpenalty;

    private BigDecimal stampdutyrate;

    private String takenby;

    private Date takendate;

    private Integer methodofpaymentcode;

    private String packagecode;

    private Integer departurecityid;

    private Integer arrivalcityid;

    private BigDecimal refundedamount;

    private Byte producttype;

    private Byte subprodtype;

    private Byte operationtype;

    private BigDecimal promodiscount;

    private String promocode;

    private Boolean isdraft;

    private String outflightno;

    private String inflightno;

    private String pnr;

    private Boolean isreceipted;

    private Byte preferentialtype;

    private Boolean isrealtimeconfirm;

    private Long orderotherflagtype;

    private Integer agentid;

    private BigDecimal promotiondiscount;

    private String clientid;

    private BigDecimal raworderamount;

    private Boolean isdynamicproduct;

    private Byte resourcetype;

    private Date holdauthtime;

    private Integer orderautoflag;

    private static final long serialVersionUID = 1L;

    public String getPkgorderno() {
        return pkgorderno;
    }

    public void setPkgorderno(String pkgorderno) {
        this.pkgorderno = pkgorderno == null ? null : pkgorderno.trim();
    }

    public String getVerno() {
        return verno;
    }

    public void setVerno(String verno) {
        this.verno = verno == null ? null : verno.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Byte getSaleschannel() {
        return saleschannel;
    }

    public void setSaleschannel(Byte saleschannel) {
        this.saleschannel = saleschannel;
    }

    public Integer getSalesorg() {
        return salesorg;
    }

    public void setSalesorg(Integer salesorg) {
        this.salesorg = salesorg;
    }

    public Integer getCustmemberid() {
        return custmemberid;
    }

    public void setCustmemberid(Integer custmemberid) {
        this.custmemberid = custmemberid;
    }

    public String getCustmembername() {
        return custmembername;
    }

    public void setCustmembername(String custmembername) {
        this.custmembername = custmembername == null ? null : custmembername.trim();
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename == null ? null : packagename.trim();
    }

    public Byte getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Byte orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby == null ? null : orderby.trim();
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getReceivedamount() {
        return receivedamount;
    }

    public void setReceivedamount(BigDecimal receivedamount) {
        this.receivedamount = receivedamount;
    }

    public Integer getAdultqty() {
        return adultqty;
    }

    public void setAdultqty(Integer adultqty) {
        this.adultqty = adultqty;
    }

    public Integer getChildqty() {
        return childqty;
    }

    public void setChildqty(Integer childqty) {
        this.childqty = childqty;
    }

    public Integer getBabyqty() {
        return babyqty;
    }

    public void setBabyqty(Integer babyqty) {
        this.babyqty = babyqty;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Date getLastcfmcustomertime() {
        return lastcfmcustomertime;
    }

    public void setLastcfmcustomertime(Date lastcfmcustomertime) {
        this.lastcfmcustomertime = lastcfmcustomertime;
    }

    public Byte getDeliverytpe() {
        return deliverytpe;
    }

    public void setDeliverytpe(Byte deliverytpe) {
        this.deliverytpe = deliverytpe;
    }

    public Integer getMotoid() {
        return motoid;
    }

    public void setMotoid(Integer motoid) {
        this.motoid = motoid;
    }

    public String getFromip() {
        return fromip;
    }

    public void setFromip(String fromip) {
        this.fromip = fromip == null ? null : fromip.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public BigDecimal getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(BigDecimal totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public BigDecimal getTotalservicefee() {
        return totalservicefee;
    }

    public void setTotalservicefee(BigDecimal totalservicefee) {
        this.totalservicefee = totalservicefee;
    }

    public BigDecimal getTotalpenalty() {
        return totalpenalty;
    }

    public void setTotalpenalty(BigDecimal totalpenalty) {
        this.totalpenalty = totalpenalty;
    }

    public BigDecimal getStampdutyrate() {
        return stampdutyrate;
    }

    public void setStampdutyrate(BigDecimal stampdutyrate) {
        this.stampdutyrate = stampdutyrate;
    }

    public String getTakenby() {
        return takenby;
    }

    public void setTakenby(String takenby) {
        this.takenby = takenby == null ? null : takenby.trim();
    }

    public Date getTakendate() {
        return takendate;
    }

    public void setTakendate(Date takendate) {
        this.takendate = takendate;
    }

    public Integer getMethodofpaymentcode() {
        return methodofpaymentcode;
    }

    public void setMethodofpaymentcode(Integer methodofpaymentcode) {
        this.methodofpaymentcode = methodofpaymentcode;
    }

    public String getPackagecode() {
        return packagecode;
    }

    public void setPackagecode(String packagecode) {
        this.packagecode = packagecode == null ? null : packagecode.trim();
    }

    public Integer getDeparturecityid() {
        return departurecityid;
    }

    public void setDeparturecityid(Integer departurecityid) {
        this.departurecityid = departurecityid;
    }

    public Integer getArrivalcityid() {
        return arrivalcityid;
    }

    public void setArrivalcityid(Integer arrivalcityid) {
        this.arrivalcityid = arrivalcityid;
    }

    public BigDecimal getRefundedamount() {
        return refundedamount;
    }

    public void setRefundedamount(BigDecimal refundedamount) {
        this.refundedamount = refundedamount;
    }

    public Byte getProducttype() {
        return producttype;
    }

    public void setProducttype(Byte producttype) {
        this.producttype = producttype;
    }

    public Byte getSubprodtype() {
        return subprodtype;
    }

    public void setSubprodtype(Byte subprodtype) {
        this.subprodtype = subprodtype;
    }

    public Byte getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(Byte operationtype) {
        this.operationtype = operationtype;
    }

    public BigDecimal getPromodiscount() {
        return promodiscount;
    }

    public void setPromodiscount(BigDecimal promodiscount) {
        this.promodiscount = promodiscount;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode == null ? null : promocode.trim();
    }

    public Boolean getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(Boolean isdraft) {
        this.isdraft = isdraft;
    }

    public String getOutflightno() {
        return outflightno;
    }

    public void setOutflightno(String outflightno) {
        this.outflightno = outflightno == null ? null : outflightno.trim();
    }

    public String getInflightno() {
        return inflightno;
    }

    public void setInflightno(String inflightno) {
        this.inflightno = inflightno == null ? null : inflightno.trim();
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr == null ? null : pnr.trim();
    }

    public Boolean getIsreceipted() {
        return isreceipted;
    }

    public void setIsreceipted(Boolean isreceipted) {
        this.isreceipted = isreceipted;
    }

    public Byte getPreferentialtype() {
        return preferentialtype;
    }

    public void setPreferentialtype(Byte preferentialtype) {
        this.preferentialtype = preferentialtype;
    }

    public Boolean getIsrealtimeconfirm() {
        return isrealtimeconfirm;
    }

    public void setIsrealtimeconfirm(Boolean isrealtimeconfirm) {
        this.isrealtimeconfirm = isrealtimeconfirm;
    }

    public Long getOrderotherflagtype() {
        return orderotherflagtype;
    }

    public void setOrderotherflagtype(Long orderotherflagtype) {
        this.orderotherflagtype = orderotherflagtype;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public BigDecimal getPromotiondiscount() {
        return promotiondiscount;
    }

    public void setPromotiondiscount(BigDecimal promotiondiscount) {
        this.promotiondiscount = promotiondiscount;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public BigDecimal getRaworderamount() {
        return raworderamount;
    }

    public void setRaworderamount(BigDecimal raworderamount) {
        this.raworderamount = raworderamount;
    }

    public Boolean getIsdynamicproduct() {
        return isdynamicproduct;
    }

    public void setIsdynamicproduct(Boolean isdynamicproduct) {
        this.isdynamicproduct = isdynamicproduct;
    }

    public Byte getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(Byte resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Date getHoldauthtime() {
        return holdauthtime;
    }

    public void setHoldauthtime(Date holdauthtime) {
        this.holdauthtime = holdauthtime;
    }

    public Integer getOrderautoflag() {
        return orderautoflag;
    }

    public void setOrderautoflag(Integer orderautoflag) {
        this.orderautoflag = orderautoflag;
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
        PkgOrderMasterEntity other = (PkgOrderMasterEntity) that;
        return (this.getPkgorderno() == null ? other.getPkgorderno() == null : this.getPkgorderno().equals(other.getPkgorderno()))
            && (this.getVerno() == null ? other.getVerno() == null : this.getVerno().equals(other.getVerno()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getSaleschannel() == null ? other.getSaleschannel() == null : this.getSaleschannel().equals(other.getSaleschannel()))
            && (this.getSalesorg() == null ? other.getSalesorg() == null : this.getSalesorg().equals(other.getSalesorg()))
            && (this.getCustmemberid() == null ? other.getCustmemberid() == null : this.getCustmemberid().equals(other.getCustmemberid()))
            && (this.getCustmembername() == null ? other.getCustmembername() == null : this.getCustmembername().equals(other.getCustmembername()))
            && (this.getPackageid() == null ? other.getPackageid() == null : this.getPackageid().equals(other.getPackageid()))
            && (this.getPackagename() == null ? other.getPackagename() == null : this.getPackagename().equals(other.getPackagename()))
            && (this.getOrderstatus() == null ? other.getOrderstatus() == null : this.getOrderstatus().equals(other.getOrderstatus()))
            && (this.getOrderby() == null ? other.getOrderby() == null : this.getOrderby().equals(other.getOrderby()))
            && (this.getTotalamount() == null ? other.getTotalamount() == null : this.getTotalamount().equals(other.getTotalamount()))
            && (this.getReceivedamount() == null ? other.getReceivedamount() == null : this.getReceivedamount().equals(other.getReceivedamount()))
            && (this.getAdultqty() == null ? other.getAdultqty() == null : this.getAdultqty().equals(other.getAdultqty()))
            && (this.getChildqty() == null ? other.getChildqty() == null : this.getChildqty().equals(other.getChildqty()))
            && (this.getBabyqty() == null ? other.getBabyqty() == null : this.getBabyqty().equals(other.getBabyqty()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getLastcfmcustomertime() == null ? other.getLastcfmcustomertime() == null : this.getLastcfmcustomertime().equals(other.getLastcfmcustomertime()))
            && (this.getDeliverytpe() == null ? other.getDeliverytpe() == null : this.getDeliverytpe().equals(other.getDeliverytpe()))
            && (this.getMotoid() == null ? other.getMotoid() == null : this.getMotoid().equals(other.getMotoid()))
            && (this.getFromip() == null ? other.getFromip() == null : this.getFromip().equals(other.getFromip()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
            && (this.getModifieddate() == null ? other.getModifieddate() == null : this.getModifieddate().equals(other.getModifieddate()))
            && (this.getTotaldiscount() == null ? other.getTotaldiscount() == null : this.getTotaldiscount().equals(other.getTotaldiscount()))
            && (this.getTotalservicefee() == null ? other.getTotalservicefee() == null : this.getTotalservicefee().equals(other.getTotalservicefee()))
            && (this.getTotalpenalty() == null ? other.getTotalpenalty() == null : this.getTotalpenalty().equals(other.getTotalpenalty()))
            && (this.getStampdutyrate() == null ? other.getStampdutyrate() == null : this.getStampdutyrate().equals(other.getStampdutyrate()))
            && (this.getTakenby() == null ? other.getTakenby() == null : this.getTakenby().equals(other.getTakenby()))
            && (this.getTakendate() == null ? other.getTakendate() == null : this.getTakendate().equals(other.getTakendate()))
            && (this.getMethodofpaymentcode() == null ? other.getMethodofpaymentcode() == null : this.getMethodofpaymentcode().equals(other.getMethodofpaymentcode()))
            && (this.getPackagecode() == null ? other.getPackagecode() == null : this.getPackagecode().equals(other.getPackagecode()))
            && (this.getDeparturecityid() == null ? other.getDeparturecityid() == null : this.getDeparturecityid().equals(other.getDeparturecityid()))
            && (this.getArrivalcityid() == null ? other.getArrivalcityid() == null : this.getArrivalcityid().equals(other.getArrivalcityid()))
            && (this.getRefundedamount() == null ? other.getRefundedamount() == null : this.getRefundedamount().equals(other.getRefundedamount()))
            && (this.getProducttype() == null ? other.getProducttype() == null : this.getProducttype().equals(other.getProducttype()))
            && (this.getSubprodtype() == null ? other.getSubprodtype() == null : this.getSubprodtype().equals(other.getSubprodtype()))
            && (this.getOperationtype() == null ? other.getOperationtype() == null : this.getOperationtype().equals(other.getOperationtype()))
            && (this.getPromodiscount() == null ? other.getPromodiscount() == null : this.getPromodiscount().equals(other.getPromodiscount()))
            && (this.getPromocode() == null ? other.getPromocode() == null : this.getPromocode().equals(other.getPromocode()))
            && (this.getIsdraft() == null ? other.getIsdraft() == null : this.getIsdraft().equals(other.getIsdraft()))
            && (this.getOutflightno() == null ? other.getOutflightno() == null : this.getOutflightno().equals(other.getOutflightno()))
            && (this.getInflightno() == null ? other.getInflightno() == null : this.getInflightno().equals(other.getInflightno()))
            && (this.getPnr() == null ? other.getPnr() == null : this.getPnr().equals(other.getPnr()))
            && (this.getIsreceipted() == null ? other.getIsreceipted() == null : this.getIsreceipted().equals(other.getIsreceipted()))
            && (this.getPreferentialtype() == null ? other.getPreferentialtype() == null : this.getPreferentialtype().equals(other.getPreferentialtype()))
            && (this.getIsrealtimeconfirm() == null ? other.getIsrealtimeconfirm() == null : this.getIsrealtimeconfirm().equals(other.getIsrealtimeconfirm()))
            && (this.getOrderotherflagtype() == null ? other.getOrderotherflagtype() == null : this.getOrderotherflagtype().equals(other.getOrderotherflagtype()))
            && (this.getAgentid() == null ? other.getAgentid() == null : this.getAgentid().equals(other.getAgentid()))
            && (this.getPromotiondiscount() == null ? other.getPromotiondiscount() == null : this.getPromotiondiscount().equals(other.getPromotiondiscount()))
            && (this.getClientid() == null ? other.getClientid() == null : this.getClientid().equals(other.getClientid()))
            && (this.getRaworderamount() == null ? other.getRaworderamount() == null : this.getRaworderamount().equals(other.getRaworderamount()))
            && (this.getIsdynamicproduct() == null ? other.getIsdynamicproduct() == null : this.getIsdynamicproduct().equals(other.getIsdynamicproduct()))
            && (this.getResourcetype() == null ? other.getResourcetype() == null : this.getResourcetype().equals(other.getResourcetype()))
            && (this.getHoldauthtime() == null ? other.getHoldauthtime() == null : this.getHoldauthtime().equals(other.getHoldauthtime()))
            && (this.getOrderautoflag() == null ? other.getOrderautoflag() == null : this.getOrderautoflag().equals(other.getOrderautoflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkgorderno() == null) ? 0 : getPkgorderno().hashCode());
        result = prime * result + ((getVerno() == null) ? 0 : getVerno().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getSaleschannel() == null) ? 0 : getSaleschannel().hashCode());
        result = prime * result + ((getSalesorg() == null) ? 0 : getSalesorg().hashCode());
        result = prime * result + ((getCustmemberid() == null) ? 0 : getCustmemberid().hashCode());
        result = prime * result + ((getCustmembername() == null) ? 0 : getCustmembername().hashCode());
        result = prime * result + ((getPackageid() == null) ? 0 : getPackageid().hashCode());
        result = prime * result + ((getPackagename() == null) ? 0 : getPackagename().hashCode());
        result = prime * result + ((getOrderstatus() == null) ? 0 : getOrderstatus().hashCode());
        result = prime * result + ((getOrderby() == null) ? 0 : getOrderby().hashCode());
        result = prime * result + ((getTotalamount() == null) ? 0 : getTotalamount().hashCode());
        result = prime * result + ((getReceivedamount() == null) ? 0 : getReceivedamount().hashCode());
        result = prime * result + ((getAdultqty() == null) ? 0 : getAdultqty().hashCode());
        result = prime * result + ((getChildqty() == null) ? 0 : getChildqty().hashCode());
        result = prime * result + ((getBabyqty() == null) ? 0 : getBabyqty().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getLastcfmcustomertime() == null) ? 0 : getLastcfmcustomertime().hashCode());
        result = prime * result + ((getDeliverytpe() == null) ? 0 : getDeliverytpe().hashCode());
        result = prime * result + ((getMotoid() == null) ? 0 : getMotoid().hashCode());
        result = prime * result + ((getFromip() == null) ? 0 : getFromip().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
        result = prime * result + ((getModifieddate() == null) ? 0 : getModifieddate().hashCode());
        result = prime * result + ((getTotaldiscount() == null) ? 0 : getTotaldiscount().hashCode());
        result = prime * result + ((getTotalservicefee() == null) ? 0 : getTotalservicefee().hashCode());
        result = prime * result + ((getTotalpenalty() == null) ? 0 : getTotalpenalty().hashCode());
        result = prime * result + ((getStampdutyrate() == null) ? 0 : getStampdutyrate().hashCode());
        result = prime * result + ((getTakenby() == null) ? 0 : getTakenby().hashCode());
        result = prime * result + ((getTakendate() == null) ? 0 : getTakendate().hashCode());
        result = prime * result + ((getMethodofpaymentcode() == null) ? 0 : getMethodofpaymentcode().hashCode());
        result = prime * result + ((getPackagecode() == null) ? 0 : getPackagecode().hashCode());
        result = prime * result + ((getDeparturecityid() == null) ? 0 : getDeparturecityid().hashCode());
        result = prime * result + ((getArrivalcityid() == null) ? 0 : getArrivalcityid().hashCode());
        result = prime * result + ((getRefundedamount() == null) ? 0 : getRefundedamount().hashCode());
        result = prime * result + ((getProducttype() == null) ? 0 : getProducttype().hashCode());
        result = prime * result + ((getSubprodtype() == null) ? 0 : getSubprodtype().hashCode());
        result = prime * result + ((getOperationtype() == null) ? 0 : getOperationtype().hashCode());
        result = prime * result + ((getPromodiscount() == null) ? 0 : getPromodiscount().hashCode());
        result = prime * result + ((getPromocode() == null) ? 0 : getPromocode().hashCode());
        result = prime * result + ((getIsdraft() == null) ? 0 : getIsdraft().hashCode());
        result = prime * result + ((getOutflightno() == null) ? 0 : getOutflightno().hashCode());
        result = prime * result + ((getInflightno() == null) ? 0 : getInflightno().hashCode());
        result = prime * result + ((getPnr() == null) ? 0 : getPnr().hashCode());
        result = prime * result + ((getIsreceipted() == null) ? 0 : getIsreceipted().hashCode());
        result = prime * result + ((getPreferentialtype() == null) ? 0 : getPreferentialtype().hashCode());
        result = prime * result + ((getIsrealtimeconfirm() == null) ? 0 : getIsrealtimeconfirm().hashCode());
        result = prime * result + ((getOrderotherflagtype() == null) ? 0 : getOrderotherflagtype().hashCode());
        result = prime * result + ((getAgentid() == null) ? 0 : getAgentid().hashCode());
        result = prime * result + ((getPromotiondiscount() == null) ? 0 : getPromotiondiscount().hashCode());
        result = prime * result + ((getClientid() == null) ? 0 : getClientid().hashCode());
        result = prime * result + ((getRaworderamount() == null) ? 0 : getRaworderamount().hashCode());
        result = prime * result + ((getIsdynamicproduct() == null) ? 0 : getIsdynamicproduct().hashCode());
        result = prime * result + ((getResourcetype() == null) ? 0 : getResourcetype().hashCode());
        result = prime * result + ((getHoldauthtime() == null) ? 0 : getHoldauthtime().hashCode());
        result = prime * result + ((getOrderautoflag() == null) ? 0 : getOrderautoflag().hashCode());
        return result;
    }
}