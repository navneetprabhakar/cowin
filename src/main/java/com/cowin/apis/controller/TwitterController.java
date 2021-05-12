package com.cowin.apis.controller;

import com.cowin.apis.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("postByPincode")
    public String postByPincode(@RequestParam(name = "pincode") Integer pincode){
        return twitterService.postCenterStatus(pincode);
    }
}
