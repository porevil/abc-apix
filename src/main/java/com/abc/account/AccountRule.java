package com.abc.account;

public class AccountRule {
    private String ruleId;
    private String ruleDesc;
    private int limit;
    private int roundUpLevel;
    private String depositAccountNo;

    public String getRuleId() {
        return ruleId;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public int getLimit() {
        return limit;
    }

    public int getRoundUpLevel() {
        return roundUpLevel;
    }

    public String getDepositAccountNo() {
        return depositAccountNo;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setRoundUpLevel(int roundUpLevel) {
        this.roundUpLevel = roundUpLevel;
    }

    public void setDepositAccountNo(String depositAccountNo) {
        this.depositAccountNo = depositAccountNo;
    }
}
