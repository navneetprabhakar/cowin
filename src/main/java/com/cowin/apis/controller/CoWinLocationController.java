package com.cowin.apis.controller;

import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.StatesAPIResponse;
import com.cowin.apis.service.CoWinLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping(value = "v1/location")
@Api(value = "This controller interacts with CoWin Location services")
public class CoWinLocationController {

    @Autowired
    private CoWinLocationService coWinLocationService;

    /**
     * This API fetches all States from Cowin public APIs
     * @return @{@link StatesAPIResponse}
     */
    @ApiOperation(value = "This API fetches all States from CoWin public APIs")
    @GetMapping("states")
    public StatesAPIResponse allStates(){
        return coWinLocationService.allStates();
    }

    /**
     * This API finds all districts by state Id
     * @param stateId : State Id
     * @return @{@link DistrictAPIResponse}
     */
    @ApiOperation(value = "This API finds all districts by state Id from CoWin public APIs")
    @GetMapping("findDistrictsByStateId")
    public DistrictAPIResponse findDistrictsByStateId(@ApiParam(name = "state_id", type = "String", value = "State Id", example = "1",required = true)
            @RequestParam(name = "state_id") String stateId){
        return coWinLocationService.findDistrictsByStateId(stateId);
    }
}
