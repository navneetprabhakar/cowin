package com.cowin.apis.service.impl;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.StatesAPIResponse;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import java.util.Arrays;

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

    private static final HttpHeaders headers;
    static{
        headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51");
    }

    @Override
    public StatesAPIResponse allStates() {
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getLocationStates(), headers, null, StatesAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting All States from CoWin Services:",e);
            throw new SystemException("An error occurred while getting All States from CoWin Services",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public DistrictAPIResponse findDistrictsByStateId(String stateId) {
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getLocationDistrict()+"/"+stateId, headers, null, DistrictAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting All District by State id from CoWin Services:",e);
            throw new SystemException("An error occurred while getting All District by State id from CoWin Services",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
