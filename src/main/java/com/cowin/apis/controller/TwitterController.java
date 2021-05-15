package com.cowin.apis.controller;

import com.cowin.apis.models.ResponseModel;
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
    public ResponseModel postByPincode(@RequestParam(name = "pincode") Integer pincode){
        return twitterService.postPincodeStatus(pincode);
    }

    @GetMapping("postDistrictStatus")
    public ResponseModel postDistrictStatus(@RequestParam(name = "districtId") Integer districtId){
        return twitterService.postDistrictStatus(districtId);
    }

    @GetMapping("postStateStatus")
    public ResponseModel postStateStatus(@RequestParam(name = "stateId") String stateId){
        return twitterService.postStateStatus(stateId);
    }

    @GetMapping("postCountryStatus")
    public ResponseModel postCountryStatus(){
        return twitterService.postCountryStatus();
    }
}
