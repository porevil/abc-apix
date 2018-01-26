package com.abc.payment;

import com.abc.bill.BillInfoDto;

public class PaymentInfoDto {

    private String responseCode;
    private String responseDesc;
    private String accountId;
    private String accountName;
    private String email;
    private String mobileNo;
    private Double accountBalance;
    private String savingAccountNo;
    private Integer limit;
    private Double depositAmt;
    private Double remainDepositAmt;
    private BillInfoDto billInfo;
    private String debitAccountNo;
    private Double debitAccountBalance;
    private String payableStatus;
    private String payableReason;
    private Double savingPerMonthAmt;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getSavingAccountNo() {
        return savingAccountNo;
    }

    public void setSavingAccountNo(String savingAccountNo) {
        this.savingAccountNo = savingAccountNo;
    }

    public Double getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(Double depositAmt) {
        this.depositAmt = depositAmt;
    }

    public Double getRemainDepositAmt() {
        return remainDepositAmt;
    }

    public void setRemainDepositAmt(Double remainDepositAmt) {
        this.remainDepositAmt = remainDepositAmt;
    }

    public BillInfoDto getBillInfo() {
        return billInfo;
    }

    public void setBillInfo(BillInfoDto billInfo) {
        this.billInfo = billInfo;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(String debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }

    public Double getDebitAccountBalance() {
        return debitAccountBalance;
    }

    public void setDebitAccountBalance(Double debitAccountBalance) {
        this.debitAccountBalance = debitAccountBalance;
    }

    public String getPayableStatus() {
        return payableStatus;
    }

    public void setPayableStatus(String payableStatus) {
        this.payableStatus = payableStatus;
    }

    public String getPayableReason() {
        return payableReason;
    }

    public void setPayableReason(String payableReason) {
        this.payableReason = payableReason;
    }

    public Double getSavingPerMonthAmt() {
        return savingPerMonthAmt;
    }

    public void setSavingPerMonthAmt(Double savingPerMonthAmt) {
        this.savingPerMonthAmt = savingPerMonthAmt;
    }
}
