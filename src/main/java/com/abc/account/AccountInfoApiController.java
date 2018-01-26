package com.abc.account;

import com.abc.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountInfoApiController {
    @Autowired
    AccountInfoService accountService;

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity getAccountInfo(@PathVariable(value="accountId", required=true) int accountId) {
        AccountInfoModel responseModel = accountService.findByAccountId(accountId);
        return new ResponseEntity<AccountInfoModel>(responseModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/rules/{ruleId}", method = RequestMethod.GET)
    public ResponseEntity getAccountInfo(@PathVariable(value="accountId", required=true) int accountId
            , @PathVariable(value="ruleId", required=true) String ruleId) {
        AccountInfoModel responseModel = accountService.findByAccountIdAndRuleId(accountId, ruleId);
        return new ResponseEntity<AccountInfoModel>(responseModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/ping", method = RequestMethod.GET)
    public ResponseEntity ping(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return new ResponseEntity<String>("Hello Account Info Service", HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/saving", method = RequestMethod.POST)
    public ResponseEntity saveAccountBalance(@RequestBody AccountInfoModel input,HttpServletRequest request){
        RestResponse restResponse = new RestResponse();
        boolean  response = accountService.saveAccountBalance(input.getSavingAccountNo(),input.getAccountBalance());
        if(response) {
            restResponse.setResponseDesc("Update balance success");
            return new ResponseEntity<>(restResponse, HttpStatus.OK);
        }else{
            restResponse.setResponseDesc("Update balance fail");
            return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
