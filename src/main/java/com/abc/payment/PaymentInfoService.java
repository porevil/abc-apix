package com.abc.payment;

import com.abc.account.AccountInfoService;
import com.abc.bill.BillInfoService;
import com.abc.account.AccountInfoModel;
import com.abc.bill.BillInfoDto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoService {

    @Autowired
    BillInfoService billInfoService;

    @Autowired
    AccountInfoService accountInfoService;

    @Autowired
    AccruedMonthlyDepositService accruedMonthlyDepositService;

    public PaymentInfoDto getPaymentInfo(String accountId, String billRefNo) {
        AccountInfoModel accountInfoModel = this.getAccountInfo(accountId);
        BillInfoDto billInfoDto = this.getBillInfo(billRefNo);
        Double accrueAmt = this.getAccruedMonthlyDepositAmount(accountId);

        PaymentInfoDto paymentInfoDto = this.createPaymentInfo(accountInfoModel, billInfoDto, accrueAmt);

        return paymentInfoDto;
    }


    public BigDecimal calculateDepositAmount(BigDecimal billAmt, int roundUp, BigDecimal limit, BigDecimal accrueAmt) {
        BigDecimal deposit = null;

        if (billAmt == null || (billAmt.doubleValue() % roundUp == 0)) {
            return BigDecimal.ZERO;
        }

        BigDecimal roundBillAmt = this.calculateRoundBillAmount(billAmt, roundUp);

        if (accrueAmt.compareTo(limit) > 0) {
            deposit = BigDecimal.ZERO;
        } else  {
            deposit = roundBillAmt.subtract(billAmt);
            BigDecimal newAccrueAmt = accrueAmt.add(deposit);

            if (newAccrueAmt.compareTo(limit) > 0) {
                deposit = limit.subtract(accrueAmt);
            }
        }

        return deposit;
    }

    public BigDecimal calculateRoundBillAmount(BigDecimal billAmt, int roundUp) {
        int scalePrecision = 1;
        int precision = billAmt.precision() - billAmt.scale();
        BigDecimal roundValue = BigDecimal.valueOf(roundUp);

        if (precision > roundValue.precision()) {
            precision = roundValue.precision() - 1;
            scalePrecision = billAmt.precision() - billAmt.scale() - roundValue.precision() + 1;

        } else if (precision <= roundValue.precision()) {
            roundValue = BigDecimal.ONE;
        }

        for (int i=0; i < precision; i++) {
            roundValue = roundValue.multiply(BigDecimal.TEN);
        }

        BigDecimal roundBillAmt = billAmt.divide(roundValue, BigDecimal.ROUND_CEILING).setScale(
                scalePrecision, BigDecimal.ROUND_CEILING).multiply(roundValue);

        return roundBillAmt;
    }

    public BigDecimal calculateRemainDepositAmount(BigDecimal accrueAmt, BigDecimal depositAmt, BigDecimal limit) {
        BigDecimal remainDepositAmount = null;

        remainDepositAmount = limit.subtract(accrueAmt);

        return remainDepositAmount;
    }

    public AccountInfoModel getAccountInfo(String accountId) {
        AccountInfoModel accountInfoModel = accountInfoService.findByAccountId(Integer.valueOf(accountId));

        return accountInfoModel;
    }

    public BillInfoDto getBillInfo(String billRefNo) {
        BillInfoDto billInfoDto = billInfoService.getBillInfo(billRefNo);

        return billInfoDto;
    }

    public Double getAccruedMonthlyDepositAmount(String accountId) {
        Double accrueAmt = 0.00;

        accrueAmt = accruedMonthlyDepositService.getAccruedMonthlyDeposit(accountId, Calendar.JANUARY, Calendar.getInstance(Locale.US).get(Calendar.YEAR));

        return accrueAmt;
    }

    public PaymentInfoDto createPaymentInfo(AccountInfoModel accountInfoModel, BillInfoDto billInfoDto, Double accrueAmt) {
        BigDecimal limit = BigDecimal.valueOf(accountInfoModel.getRules().get(0).getLimit());
        BigDecimal depositAmt = this.calculateDepositAmount(BigDecimal.valueOf(billInfoDto.getBillAmt()),
                accountInfoModel.getRules().get(0).getRoundUpLevel(), limit, BigDecimal.valueOf(accrueAmt));

        PaymentInfoDto paymentInfoDto = new PaymentInfoDto();
        paymentInfoDto.setAccountBalance(Double.valueOf(accountInfoModel.getAccountBalance()));
        paymentInfoDto.setAccountId(String.valueOf(accountInfoModel.getAccountId()));
        paymentInfoDto.setAccountName(accountInfoModel.getAccountName());
        paymentInfoDto.setDepositAmt(depositAmt.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        paymentInfoDto.setSavingAccountNo(accountInfoModel.getSavingAccountNo());
        paymentInfoDto.setEmail(accountInfoModel.getEmail());
        paymentInfoDto.setMobileNo(accountInfoModel.getMobileNo());
        paymentInfoDto.setRemainDepositAmt(this.calculateRemainDepositAmount(BigDecimal.valueOf(accrueAmt),depositAmt,limit).doubleValue());
        paymentInfoDto.setBillInfo(billInfoDto);
        paymentInfoDto.setLimit(accountInfoModel.getRules().get(0).getLimit());
        paymentInfoDto.setDebitAccountBalance(Double.valueOf(accountInfoModel.getDebitAccountBalance()));
        paymentInfoDto.setDebitAccountNo(accountInfoModel.getDebitAccountNo());
        paymentInfoDto.setSavingPerMonthAmt(accrueAmt);
        paymentInfoDto.setResponseCode("0");
        paymentInfoDto.setResponseDesc("Success");

        this.setPayableStatus(accountInfoModel, billInfoDto, paymentInfoDto);

        return paymentInfoDto;
    }

    public void setPayableStatus(AccountInfoModel accountInfoModel, BillInfoDto billInfoDto, PaymentInfoDto paymentInfoDto) {

        if (accountInfoModel.getAccountBalance() >= billInfoDto.getBillAmt().doubleValue() && "N".equals(billInfoDto.getPayStatus())) {
            paymentInfoDto.setPayableStatus("Y");
            paymentInfoDto.setPayableReason("Bill payment is available.");
        } else if ("Y".equals(billInfoDto.getPayStatus())) {
            paymentInfoDto.setPayableStatus("N");
            paymentInfoDto.setPayableReason("This bill is already paid.");
        } else if (accountInfoModel.getAccountBalance() < billInfoDto.getBillAmt().doubleValue()) {
            paymentInfoDto.setPayableStatus("N");
            paymentInfoDto.setPayableReason("Your account balance cannot afford bill payment.");
        }

    }

}
