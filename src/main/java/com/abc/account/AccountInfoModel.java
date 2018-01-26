package com.abc.account;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "account_info")
public class AccountInfoModel {
    private double accountBalance;
    private double debitAccountBalance;
    private int accountId;
    private String accountName;
    private String email;
    private String mobileNo;
    private String savingAccountNo;
    private String debitAccountNo;
    private List<AccountRule> rules;

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getSavingAccountNo() {
        return savingAccountNo;
    }

    public List<AccountRule> getRules() {
        return rules;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setSavingAccountNo(String savingAccountNo) {
        this.savingAccountNo = savingAccountNo;
    }

    public void setRules(List<AccountRule> rules) {
        this.rules = rules;
    }

    public double getDebitAccountBalance() {
        return debitAccountBalance;
    }

    public void setDebitAccountBalance(double debitAccountBalance) {
        this.debitAccountBalance = debitAccountBalance;
    }

    public String getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(String debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }
}
