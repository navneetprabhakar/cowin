package com.cowin.apis.service.impl;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.exception.SystemException;
import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.models.CalendarAPIResponse;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class CoWinAppointmentServiceImpl implements CoWinAppointmentService {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private CowinProperties cowinProperties;

    private static final ObjectMapper mapper=new ObjectMapper();

    @Override
    public AppointmentSessionResponse findAppointmentByPincode(Integer pincode, String date) {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("pincode", pincode.toString());
        queryParams.put("date", date);
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getFindByPin(), null, queryParams,AppointmentSessionResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting appointment by pincode from CoWin Services:",e);
            throw new SystemException("An error occurred while getting appointment by pincode from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public AppointmentSessionResponse findAppointmentByDistrict(Integer disctrictId, String date) {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("district_id", disctrictId.toString());
        queryParams.put("date", date);
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getFindByDistrict(), null, queryParams,AppointmentSessionResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting appointment by district id from CoWin Services:",e);
            throw new SystemException("An error occurred while getting appointment by district id from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CalendarAPIResponse findCalendarAppointmentByPin(Integer pincode, String date) {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("pincode", pincode.toString());
        queryParams.put("date", date);
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getCalendarByPin(), null, queryParams,CalendarAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting appointment calendar by pincode from CoWin Services:",e);
            throw new SystemException("An error occurred while getting appointment calendar by pincode from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CalendarAPIResponse findCalendarAppointmentByDistrict(Integer disctrictId, String date) {
        Map<String, String> queryParams=new HashMap<>();
        queryParams.put("district_id", disctrictId.toString());
        queryParams.put("date", date);
        try{
            return restUtils.restGetCall(cowinProperties.getBaseUrl()+cowinProperties.getCalendarByDistrict(), null, queryParams,CalendarAPIResponse.class);
        }catch (Exception e){
            log.error("An error occurred while getting appointment calendar by district id from CoWin Services:",e);
            throw new SystemException("An error occurred while getting appointment calendar by district id from CoWin Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
