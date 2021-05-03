package com.cowin.apis.controller;

import com.cowin.apis.models.AuthenticationRequest;
import com.cowin.apis.models.AuthenticationResponse;
import com.cowin.apis.models.OTPRequest;
import com.cowin.apis.models.OTPResponse;
import com.cowin.apis.service.CoWinAuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller interacts with CoWin Authentication services
 * @author navneetprabhakar
 */
@RestController
@RequestMapping("v1/authentication")
@Api(value = "CoWin Authentication services controller")
public class CoWinAuthenticationController {

    @Autowired
    private CoWinAuthenticationService coWinAuthenticationService;

    /**
     * This API call generates OTP for CoWin App Registration
     * @param request : @{@link AuthenticationRequest}
     * @return response: @{@link AuthenticationResponse}
     */
    @ApiOperation(value = "This API call generates OTP for CoWin App Registration")
    @PostMapping(value = "generateOtp", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse generateOtp(@RequestBody AuthenticationRequest request){
        return coWinAuthenticationService.generateOtp(request);
    }

    /**
     * This API call confirms OTP for CoWin App Registration
     * @param request : @{@link OTPRequest}
     * @return response: @{@link OTPResponse}
     */
    @ApiOperation(value = "This API call confirms OTP for CoWin App Registration")
    @PostMapping(value = "confirmOtp", produces = MediaType.APPLICATION_JSON_VALUE)
    public OTPResponse confirmOtp(@RequestBody OTPRequest request){
        return coWinAuthenticationService.confirmOtp(request);
    }
}
