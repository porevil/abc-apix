package com.abc.template;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmailBillDto implements Serializable{

    private String firstname;
    private String lastname;
    private Date currentDateTime;
    private String transactionNo;
    private String depositAccountNo;
    private String billTitle;
    private BigDecimal billAmount;
    private BigDecimal billTotalAmount;
    private BigDecimal feeAmount;
    private String savingAccountNo;
    private BigDecimal savingAmount;
    private Date savingPerMonth;
    private BigDecimal savingPerMonthAmt;
    private BigDecimal savingPerMonthBalance;
    private Date savingPerMonthCurrentDateTime;
    private BigDecimal savingTotalBalance;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getDepositAccountNo() {
        return depositAccountNo;
    }

    public void setDepositAccountNo(String depositAccountNo) {
        this.depositAccountNo = depositAccountNo;
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getBillTotalAmount() {
        return billTotalAmount;
    }

    public void setBillTotalAmount(BigDecimal billTotalAmount) {
        this.billTotalAmount = billTotalAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getSavingAccountNo() {
        return savingAccountNo;
    }

    public void setSavingAccountNo(String savingAccountNo) {
        this.savingAccountNo = savingAccountNo;
    }

    public BigDecimal getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(BigDecimal savingAmount) {
        this.savingAmount = savingAmount;
    }

    public Date getSavingPerMonth() {
        return savingPerMonth;
    }

    public void setSavingPerMonth(Date savingPerMonth) {
        this.savingPerMonth = savingPerMonth;
    }

    public BigDecimal getSavingPerMonthAmt() {
        return savingPerMonthAmt;
    }

    public void setSavingPerMonthAmt(BigDecimal savingPerMonthAmt) {
        this.savingPerMonthAmt = savingPerMonthAmt;
    }

    public Date getSavingPerMonthCurrentDateTime() {
        return savingPerMonthCurrentDateTime;
    }

    public void setSavingPerMonthCurrentDateTime(Date savingPerMonthCurrentDateTime) {
        this.savingPerMonthCurrentDateTime = savingPerMonthCurrentDateTime;
    }

    public BigDecimal getSavingPerMonthBalance() {
        return savingPerMonthBalance;
    }

    public void setSavingPerMonthBalance(BigDecimal savingPerMonthBalance) {
        this.savingPerMonthBalance = savingPerMonthBalance;
    }

    public BigDecimal getSavingTotalBalance() {
        return savingTotalBalance;
    }

    public void setSavingTotalBalance(BigDecimal savingTotalBalance) {
        this.savingTotalBalance = savingTotalBalance;
    }

}
