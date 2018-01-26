package com.abc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.math.BigDecimal;
import java.text.*;
import java.util.*;


@Service
public class EmailTemplateService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    private static final String[] MONTHS = {
            "\u0e21\u0e01\u0e23\u0e32\u0e04\u0e21"
            , "\u0e01\u0e38\u0e21\u0e20\u0e32\u0e1e\u0e31\u0e19\u0e18\u0e4c"
            , "\u0e21\u0e35\u0e19\u0e32\u0e04\u0e21"
            , "\u0e40\u0e21\u0e29\u0e32\u0e22\u0e19"
            , "\u0e1e\u0e24\u0e29\u0e20\u0e32\u0e04\u0e21"
            , "\u0e21\u0e34\u0e16\u0e38\u0e19\u0e32\u0e22\u0e19"
            , "\u0e01\u0e23\u0e01\u0e0e\u0e32\u0e04\u0e21"
            , "\u0e2a\u0e34\u0e07\u0e2b\u0e32\u0e04\u0e21"
            , "\u0e01\u0e31\u0e19\u0e22\u0e32\u0e22\u0e19"
            , "\u0e15\u0e38\u0e25\u0e32\u0e04\u0e21"
            , "\u0e1e\u0e24\u0e28\u0e08\u0e34\u0e01\u0e32\u0e22\u0e19"
            , "\u0e18\u0e31\u0e19\u0e27\u0e32\u0e04\u0e21"};
    private static final NumberFormat formatter = new DecimalFormat("#,##0.00");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");
    private static final Locale localeTh = new Locale("th", "TH");

    public String getHtml(EmailBillDto emailBillDto){

        Map model = new HashMap();
        model.put("firstname", emailBillDto.getFirstname());
        model.put("lastname", emailBillDto.getLastname());
        model.put("currentDateTime", getDateTimeThaiName(emailBillDto.getCurrentDateTime()));
        model.put("transactionNo", emailBillDto.getTransactionNo());
        model.put("depositAccountNo", emailBillDto.getDepositAccountNo());
        model.put("billTitle", emailBillDto.getBillTitle());
        model.put("billAmount", getNumberFormatStr(emailBillDto.getBillAmount()));
        model.put("billTotalAmount", getNumberFormatStr(emailBillDto.getBillTotalAmount()));
        model.put("feeAmount", getFeeName(emailBillDto.getFeeAmount()));
        model.put("savingAccountNo", emailBillDto.getSavingAccountNo());
        model.put("savingAmount", getNumberFormatStr(emailBillDto.getSavingAmount()));


        Context context = new Context();
        context.setVariables(model);
        return templateEngine.process("email-template", context);
    }

    public String getFeeName(BigDecimal feeNum){

        if(BigDecimal.ZERO.compareTo(feeNum) == 0){
            return "\u0e1f\u0e23\u0e35";//Is Free text
        }else{
            return getNumberFormatStr(feeNum);
        }
    }

    public String getDateTimeThaiName(Date date){
        Calendar cal = Calendar.getInstance(localeTh);
        cal.setTime(date);

        return String.format("%s %s \u0e1e.\u0e28. %s %s \u0e19.", cal.get(Calendar.DATE), getMonthThaiName(cal.get(Calendar.MONTH)), cal.get(Calendar.YEAR), sdfDate.format(date));
    }

    private String getMonthThaiName(int monthCelender){
        return MONTHS[monthCelender];
    }

    private String getNumberFormatStr(BigDecimal amount){
        return formatter.format(amount);
    }

}
