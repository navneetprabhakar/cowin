package com.cowin.apis.service.impl;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.AuthenticationRequest;
import com.cowin.apis.models.AuthenticationResponse;
import com.cowin.apis.models.OTPRequest;
import com.cowin.apis.models.OTPResponse;
import com.cowin.apis.service.CoWinAuthenticationService;
import com.cowin.apis.utils.RestUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import java.util.Arrays;

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

    private static final HttpHeaders headers;
    static{
        headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51");
    }

    @Override
    public AuthenticationResponse generateOtp(AuthenticationRequest request) {
        try{
            return restUtils.restPostCall(cowinProperties.getBaseUrl()+cowinProperties.getGenerateOtp(), headers,
                    null, request, AuthenticationResponse.class);
        }catch (Exception e){
            log.error("An error occurred while generating OTP from CoWin Services:",e);
            throw new SystemException("An error occurred while generating OTP from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Override
    public OTPResponse confirmOtp(OTPRequest request) {
        try{
            return restUtils.restPostCall(cowinProperties.getBaseUrl()+cowinProperties.getGenerateOtp(), headers,
                    null, request, OTPResponse.class);
        }catch (Exception e){
            log.error("An error occurred while confirming OTP from CoWin Services:",e);
            throw new SystemException("An error occurred while confirming OTP from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
