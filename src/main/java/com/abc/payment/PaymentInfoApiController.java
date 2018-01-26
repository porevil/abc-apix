package com.abc.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentInfoApiController {

    @Autowired
    PaymentInfoService paymentInfoService;

    @RequestMapping(value = "/payment/getPaymentInfo", method = RequestMethod.GET)
    public ResponseEntity getPaymentInfo(@RequestParam(value="accountId", required=true) String accountId, @RequestParam(value="billRefNo", required=true) String billRefNo) {
        PaymentInfoDto paymentInfoDto = paymentInfoService.getPaymentInfo(accountId, billRefNo);

        return new ResponseEntity<PaymentInfoDto>(paymentInfoDto, HttpStatus.OK);

    }


}
