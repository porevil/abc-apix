package com.abc.transaction;

import com.abc.bill.BillInfoService;
import com.abc.account.AccountInfoService;
import com.abc.notification.NotificationService;
import com.abc.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionApiController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    BillInfoService billInfoService;

    @Autowired
    AccountInfoService accountService;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity saveTransaction(@RequestBody TransactionEntity transaction) throws Exception{

        Long transactionId = transactionService.saveTransaction(transaction);

        boolean  response;
        response = billInfoService.updateBillPay(transaction.getBillRefNo());
        if(response){
            response = accountService.saveAccountBalance(transaction.getSavingAccountNo(),transaction.getSavingAmount().doubleValue());
        }
        if(response){
            response = accountService.debitAccountBalance(transaction.getDepositAccountNo(),-transaction.getBillTotalAmount().doubleValue());
        }
        if(response) {
            notificationService.sendNotificationByTransactionId(transactionId);
        }
        return sendRestResponse(transactionId, response);
    }

    public ResponseEntity sendRestResponse(Long transactionId, boolean response) {
        RestResponse restResponse = new RestResponse();
        restResponse.setTransactionId(transactionId);
        if(response) {
            restResponse.setResponseDesc("Save account balance success");
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        }else{
            restResponse.setResponseDesc("Save account balance fail");
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
