package com.abc.notification;

import com.abc.transaction.TransactionService;
import com.abc.transaction.TransactionEntity;
import com.abc.template.EmailBillDto;
import com.abc.template.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Autowired
    SendEmailService sendEmailService;

    @Autowired
    TransactionService transactionService;

    public void sendNotificationByTransactionId(Long transactionId) throws Exception{

        TransactionEntity transaction = transactionService.getTransactionById(transactionId);
        EmailBillDto emailBillDto = transactionEntity2EmailBillDto(transaction);
        String html = emailTemplateService.getHtml(emailBillDto);
        sendEmailService.sendEmailAsync("natapong.saratham@gmail.com",transaction.getEmail(), "จ่ายบิลออมเงิน (ชำระสำเร็จ)", html);

    }

    public EmailBillDto transactionEntity2EmailBillDto(TransactionEntity transaction) {
        EmailBillDto emailBillDto = new EmailBillDto();
        emailBillDto.setFirstname(transaction.getAccountName());
        emailBillDto.setCurrentDateTime(transaction.getCurrentDateTime());
        emailBillDto.setDepositAccountNo(transaction.getDepositAccountNo());
        emailBillDto.setBillTitle(transaction.getMercDesc());
        emailBillDto.setBillAmount(transaction.getBillAmount());
        emailBillDto.setBillTotalAmount(transaction.getBillTotalAmount());
        emailBillDto.setFeeAmount(transaction.getFeeAmount());
        emailBillDto.setSavingAccountNo(transaction.getSavingAccountNo());
        emailBillDto.setSavingAmount(transaction.getSavingAmount());
//        emailBillDto.setSavingPerMonth(transaction.getSavingPerMonth());
//        emailBillDto.setSavingPerMonthAmt(transaction.getSavingPerMonthAmt());
//        emailBillDto.setSavingPerMonthBalance(transaction.getSavingPerMonthBalance());
//        emailBillDto.setSavingPerMonthCurrentDateTime(transaction.getSavingPerMonthCurrentDateTime());
        emailBillDto.setFirstname(transaction.getAccountName());
//        emailBillDto.setSavingTotalBalance(transaction.getSavingTotalBalance());
        emailBillDto.setTransactionNo(String.valueOf(transaction.getTransactionId()));
        return emailBillDto;
    }
}
