package com.cowin.apis.service.impl;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.AuthenticationRequest;
import com.cowin.apis.models.AuthenticationResponse;
import com.cowin.apis.models.OTPRequest;
import com.cowin.apis.models.OTPResponse;
import com.cowin.apis.service.CoWinAuthenticationService;
import com.cowin.apis.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class implements CoWinAuthenticationService methods
 * @author navneetprabhakar
 */
@Service
@Log4j2
public class CoWinAuthenticationServiceImpl implements CoWinAuthenticationService {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private CowinProperties cowinProperties;

    private static final ObjectMapper mapper=new ObjectMapper();

    @Override
    public AuthenticationResponse generateOtp(AuthenticationRequest request) {
        try{
            return restUtils.restPostCall(cowinProperties.getBaseUrl()+cowinProperties.getGenerateOtp(), null,
                    null, request, AuthenticationResponse.class);
        }catch (Exception e){
            log.error("An error occurred while generating OTP from CoWin Services:",e);
            throw new SystemException("An error occurred while generating OTP from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Override
    public OTPResponse confirmOtp(OTPRequest request) {
        try{
            return restUtils.restPostCall(cowinProperties.getBaseUrl()+cowinProperties.getGenerateOtp(), null,
                    null, request, OTPResponse.class);
        }catch (Exception e){
            log.error("An error occurred while confirming OTP from CoWin Services:",e);
            throw new SystemException("An error occurred while confirming OTP from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
