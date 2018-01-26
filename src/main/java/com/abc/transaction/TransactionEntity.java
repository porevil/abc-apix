package com.abc.transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "CURRENT_DATE_TIME")
    private Date currentDateTime;
    @Column(name = "DEPOSIT_ACCOUNT_NO")
    private String depositAccountNo;
    @Column(name = "BILL_AMOUNT")
    private BigDecimal billAmount;
    @Column(name = "BILL_TOTAL_AMOUNT")
    private BigDecimal billTotalAmount;
    @Column(name = "FEE_AMOUNT")
    private BigDecimal feeAmount;
    @Column(name = "SAVING_ACCOUNT_NO")
    private String savingAccountNo;
    @Column(name = "SAVING_AMOUNT")
    private BigDecimal savingAmount;
//    @Column(name = "SAVING_PER_MONTH")
//    private Date savingPerMonth;
    @Column(name = "SAVING_PER_MONTH_AMT")
    private BigDecimal savingPerMonthAmt;
//    @Column(name = "SAVING_PER_MONTH_CURRENT_DATETIME")
//    private Date savingPerMonthCurrentDateTime;
//    @Column(name = "SAVING_PER_MONTH_BALANCE")
//    private BigDecimal savingPerMonthBalance;
//    @Column(name = "SAVING_TOTAL_BALANCE")
//    private BigDecimal savingTotalBalance;

    @Column(name = "ACCOUNT_ID")
    private String accountId;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BILL_REF_NO")
    private String billRefNo;
    @Column(name = "MERC_DESC")
    private String mercDesc;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getDepositAccountNo() {
        return depositAccountNo;
    }

    public void setDepositAccountNo(String depositAccountNo) {
        this.depositAccountNo = depositAccountNo;
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

//    public Date getSavingPerMonth() {
//        return savingPerMonth;
//    }
//
//    public void setSavingPerMonth(Date savingPerMonth) {
//        this.savingPerMonth = savingPerMonth;
//    }

    public BigDecimal getSavingPerMonthAmt() {
        return savingPerMonthAmt;
    }

    public void setSavingPerMonthAmt(BigDecimal savingPerMonthAmt) {
        this.savingPerMonthAmt = savingPerMonthAmt;
    }

//    public Date getSavingPerMonthCurrentDateTime() {
//        return savingPerMonthCurrentDateTime;
//    }
//
//    public void setSavingPerMonthCurrentDateTime(Date savingPerMonthCurrentDateTime) {
//        this.savingPerMonthCurrentDateTime = savingPerMonthCurrentDateTime;
//    }
//
//    public BigDecimal getSavingPerMonthBalance() {
//        return savingPerMonthBalance;
//    }
//
//    public void setSavingPerMonthBalance(BigDecimal savingPerMonthBalance) {
//        this.savingPerMonthBalance = savingPerMonthBalance;
//    }
//
//    public BigDecimal getSavingTotalBalance() {
//        return savingTotalBalance;
//    }
//
//    public void setSavingTotalBalance(BigDecimal savingTotalBalance) {
//        this.savingTotalBalance = savingTotalBalance;
//    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillRefNo() {
        return billRefNo;
    }

    public void setBillRefNo(String billRefNo) {
        this.billRefNo = billRefNo;
    }

    public String getMercDesc() {
        return mercDesc;
    }

    public void setMercDesc(String mercDesc) {
        this.mercDesc = mercDesc;
    }
}
