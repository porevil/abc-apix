package com.abc.bill;

import com.abc.bill.BillInfoDto;
import com.abc.bill.BillInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BillInfoApiController {

    @Autowired
    BillInfoService billInfoService;

    @RequestMapping(value = "/bills/{bill_ref_no}", method = RequestMethod.GET)
    public ResponseEntity billInfo(@PathVariable(value="bill_ref_no", required=true) String billRefNo) {
        BillInfoDto dto = getBillInfoDto(billRefNo);
        return new ResponseEntity<BillInfoDto>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/billpay/{bill_ref_no}", method = RequestMethod.GET)
    public ResponseEntity billPay(@PathVariable(value="bill_ref_no", required=true) String billRefNo) {
        billInfoService.updateBillPay(billRefNo);
        BillInfoDto dto = getBillInfoDto(billRefNo);
        return new ResponseEntity<BillInfoDto>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{bill_ref_no}/refund", method = RequestMethod.POST)
    public ResponseEntity refund(@PathVariable(value="bill_ref_no", required=true) String billRefNo) {
        billInfoService.refund(billRefNo);
        BillInfoDto dto = getBillInfoDto(billRefNo);
        return new ResponseEntity<BillInfoDto>(dto, HttpStatus.OK);
    }

    private BillInfoDto getBillInfoDto(@PathVariable(value = "bill_ref_no", required = true) String billRefNo) {
        return billInfoService.getBillInfo(billRefNo);
    }

}
