package com.abc.notification;

import com.abc.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationApiController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ResponseEntity greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return new ResponseEntity<String>("greeting",HttpStatus.OK);
    }

    @RequestMapping(value = "/notification/{transactionId}", method = RequestMethod.GET)
    public ResponseEntity notification(@PathVariable(value="transactionId", required=true) Long transactionId) throws Exception{

        notificationService.sendNotificationByTransactionId(transactionId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
