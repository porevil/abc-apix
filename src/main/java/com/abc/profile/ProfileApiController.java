package com.abc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cadet on 1/24/2018 AD.
 */

@RestController
public class ProfileApiController {



    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/profiles/{userId}", method = RequestMethod.GET)
    public ResponseEntity getAccountInfo(@PathVariable String userId,HttpServletRequest request) {

        Profile responseModel = profileService.getProfileByUserId(userId);
        if(responseModel!=null) {
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(responseModel, HttpStatus.NO_CONTENT);
        }

    }
}
