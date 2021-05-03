package com.cowin.apis.service;

import com.cowin.apis.models.AuthenticationRequest;
import com.cowin.apis.models.AuthenticationResponse;
import com.cowin.apis.models.OTPRequest;
import com.cowin.apis.models.OTPResponse;

/**
 * This interface manages interaction with CoWin Authentication services
 * @author navneetprabhakar
 */
public interface CoWinAuthenticationService {

    /**
     * This method call generates OTP for CoWin App Registration
     * @param request : @{@link AuthenticationRequest}
     * @return response: @{@link AuthenticationResponse}
     */
    AuthenticationResponse generateOtp(AuthenticationRequest request);

    /**
     * This method call confirms OTP for CoWin App Registration
     * @param request : @{@link OTPRequest}
     * @return response: @{@link OTPResponse}
     */
    OTPResponse confirmOtp(OTPRequest request);
}
