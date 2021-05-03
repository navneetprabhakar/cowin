package com.cowin.apis.controller;

import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.StatesAPIResponse;
import com.cowin.apis.service.CoWinLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller interacts with CoWin Location services
 * @author navneetprabhakar
 */
@RestController
@RequestMapping("v1/location")
public class CoWinLocationController {

    @Autowired
    private CoWinLocationService coWinLocationService;

    /**
     * This API fetches all States from Cowin public APIs
     * @return @{@link StatesAPIResponse}
     */
    @GetMapping("/states")
    public StatesAPIResponse allStates(){
        return coWinLocationService.allStates();
    }

    /**
     * This API finds all districts by state Id
     * @param stateId : State Id
     * @return @{@link DistrictAPIResponse}
     */
    public DistrictAPIResponse findDistrictsByStateId(@RequestParam(name = "state_id") String stateId){
        return coWinLocationService.findDistrictsByStateId(stateId);
    }
}
