package com.abc.bill;

import java.math.BigDecimal;

public class BillInfoDto {

    private String billRefNo;
    private String mercCode;
    private String mercDesc;
    private Double billAmt;
    private String payStatus;

    public String getBillRefNo() {
        return billRefNo;
    }

    public void setBillRefNo(String billRefNo) {
        this.billRefNo = billRefNo;
    }

    public String getMercCode() {
        return mercCode;
    }

    public void setMercCode(String mercCode) {
        this.mercCode = mercCode;
    }

    public String getMercDesc() {
        return mercDesc;
    }

    public void setMercDesc(String mercDesc) {
        this.mercDesc = mercDesc;
    }

    public Double getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(Double billAmt) {
        this.billAmt = billAmt;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }
}
