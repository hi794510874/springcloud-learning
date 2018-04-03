package com.owen.model;

/**
 * Created by huang_b on 2018/4/3.
 */
public class PkgOrderMasterANDSalesOrderMasterEntity {
    private String pkgorderno;
    private Integer packageid;
    private Integer salesorderno;
    private String fromip;

    public String getPkgorderno() {
        return pkgorderno;
    }

    public void setPkgorderno(String pkgorderno) {
        this.pkgorderno = pkgorderno;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Integer getSalesorderno() {
        return salesorderno;
    }

    public void setSalesorderno(Integer salesorderno) {
        this.salesorderno = salesorderno;
    }

    public String getFromip() {
        return fromip;
    }

    public void setFromip(String fromip) {
        this.fromip = fromip;
    }
}
