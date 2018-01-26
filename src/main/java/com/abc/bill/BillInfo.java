package com.abc.bill;

/**
 * Created by cadet on 1/23/2018 AD.
 */

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bill_info")
public class BillInfo {

    private String billId;
    private String billRefNo;
    private String mercCode;
    private String mercDesc;
    private String billAmt;
    private String dueDate;
    private String lastPayDate;
    private String payStatus;


    public String getBillRefNo(){
      return  billRefNo;
    }
    public void setBillRefNo(String billRefNo){

     this.billRefNo = billRefNo;
    }
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public String getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(String billAmt) {
        this.billAmt = billAmt;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(String lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}

