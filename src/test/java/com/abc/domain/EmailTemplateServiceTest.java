package com.abc.domain;

import com.abc.template.EmailBillDto;
import com.abc.template.EmailTemplateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailTemplateServiceTest {

    @Autowired
    private EmailTemplateService emailTemplateService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void isShouldNotEmpty(){
        EmailBillDto emailBillDto = new EmailBillDto();

        Calendar currentCal = Calendar.getInstance(new Locale("th", "TH"));
        currentCal.set(2561, 0, 24, 15, 49); //24/01/2561 15:49 15:49 น.

        Calendar savingCal = Calendar.getInstance(new Locale("th", "TH"));
        savingCal.set(2561, 0, 24, 15, 49); //24/01/2561 15:49 15:49 น.

        emailBillDto.setFirstname("\u0e28\u0e23\u0e35\u0e40\u0e23\u0e37\u0e2d\u0e19");
        emailBillDto.setLastname("\u0e21\u0e31\u0e48\u0e19\u0e04\u0e07");
        emailBillDto.setCurrentDateTime(currentCal.getTime());
        emailBillDto.setTransactionNo("00001");
        emailBillDto.setDepositAccountNo("123-456-789-1");
        emailBillDto.setBillTitle("\u0e01\u0e32\u0e23\u0e44\u0e1f\u0e1f\u0e49\u0e32\u0e19\u0e04\u0e23\u0e2b\u0e25\u0e27\u0e07");
        emailBillDto.setBillAmount(BigDecimal.valueOf(1380.00));
        emailBillDto.setBillTotalAmount(BigDecimal.valueOf(1400));
        emailBillDto.setFeeAmount(BigDecimal.ZERO);
        emailBillDto.setSavingAccountNo("987-654-321-0");
        emailBillDto.setSavingAmount(BigDecimal.valueOf(20));
        emailBillDto.setSavingPerMonth(savingCal.getTime());
        emailBillDto.setSavingPerMonthAmt(BigDecimal.valueOf(20));
        emailBillDto.setSavingPerMonthCurrentDateTime(savingCal.getTime());
        emailBillDto.setSavingPerMonthBalance(BigDecimal.valueOf(4080));
        emailBillDto.setSavingTotalBalance(BigDecimal.valueOf(5020));

        String htmlStr = emailTemplateService.getHtml(emailBillDto);
        logger.debug("htmlStr[" + htmlStr + "]");

        Assert.assertNotNull(htmlStr);
    }

    @Test
    public void isShouldZeroFeeText(){
        String actual = emailTemplateService.getFeeName(BigDecimal.ZERO);
        String expected = "\u0e1f\u0e23\u0e35";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isShouldFeeTextFormat(){
        String actual = emailTemplateService.getFeeName(BigDecimal.valueOf(12356.25));
        String expected = "12,356.25";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isShouldDateTextThaiFormat24_01_2561(){
        Calendar cal = Calendar.getInstance(new Locale("th", "TH"));
        cal.set(2561, 0, 24, 15, 49); //24/01/2561 15:49 15:49 น.

        try {
            String actual = emailTemplateService.getDateTimeThaiName(cal.getTime());
            String expected = "24 \u0e21\u0e01\u0e23\u0e32\u0e04\u0e21 \u0e1e.\u0e28. 2561 15:49 \u0e19.";
            Assert.assertEquals(expected, actual);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
