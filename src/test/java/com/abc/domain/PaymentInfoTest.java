package com.abc.domain;

import com.abc.payment.PaymentInfoService;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class PaymentInfoTest {
/*
    @Test
    public void successBillAndSuccessSavings(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDeposit(BigDecimal.valueOf(3869.38),10000,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(130.62).doubleValue(), actual.doubleValue());
    }
*/

    @Test
    public void successBillAndSuccessSavingsCase1(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3869.38),10,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(0.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase2(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3869.38),100,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(30.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase3(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3869.38),1000,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(130.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase4(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3869.38),10000,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(130.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase5(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3869.38),100000,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(130.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase6(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3969.38),100,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(30.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase7(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3969.38),1000,BigDecimal.valueOf(5000), BigDecimal.valueOf(4000));
        assertEquals(BigDecimal.valueOf(30.62).doubleValue(), actual.doubleValue());
    }

    @Test
    public void successBillAndSuccessSavingsCase8(){
        PaymentInfoService paymentInfoService = new PaymentInfoService();
        BigDecimal actual = paymentInfoService.calculateDepositAmount(BigDecimal.valueOf(3900.00),100,BigDecimal.valueOf(5000), BigDecimal.valueOf(4800));
        assertEquals(BigDecimal.valueOf(0).doubleValue(), actual.doubleValue());
    }

}
