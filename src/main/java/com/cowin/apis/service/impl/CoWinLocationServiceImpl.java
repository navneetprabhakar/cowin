package com.cowin.apis.service.impl;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.AuthenticationResponse;
import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.StatesAPIResponse;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class implements CoWinLocationService methods
 * @author navneetprabhakar
 */
@Service
@Log4j2
public class CoWinLocationServiceImpl implements CoWinLocationService {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private CowinProperties cowinProperties;

    private static final ObjectMapper mapper= new ObjectMapper();

    @Override
    public StatesAPIResponse allStates() {
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getLocationStates(), null, null, StatesAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting All States from CoWin Services:",e);
            throw new SystemException("An error occurred while getting All States from CoWin Services",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public DistrictAPIResponse findDistrictsByStateId(String stateId) {
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getLocationDistrict()+"/"+stateId, null, null, DistrictAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting All District by State id from CoWin Services:",e);
            throw new SystemException("An error occurred while getting All District by State id from CoWin Services",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
