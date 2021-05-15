package com.cowin.apis.service.impl;

import com.cowin.apis.data.models.Districts;
import com.cowin.apis.data.models.States;
import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.ResponseModel;
import com.cowin.apis.models.StatesAPIResponse;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.service.TwitterService;
import com.cowin.apis.utils.TwitterUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements all services of @{@link TwitterService}
 * @author navneetprabhakar
 */
@Service
@Log4j2
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    @Autowired
    private CoWinLocationService coWinLocationService;

    @Autowired
    private TwitterUtils twitterUtils;

    @Override
    public ResponseModel postPincodeStatus(Integer pincode) {
        try{
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            AppointmentSessionResponse sessionResponse=coWinAppointmentService.findAppointmentByPincode(pincode, sdf.format(new Date()));
            twitterUtils.postTweetByAppointmentSessionPincode(sessionResponse,sdf.format(new Date()), pincode);
            return new ResponseModel("Success", "Done");
        }catch (Exception e){
            log.error("An error occurred in posting tweet about pincode:"+pincode, e);
        }
        return new ResponseModel("Failure", "Error occurred");
    }

    @Override
    public ResponseModel postDistrictStatus(Integer districtId) {
        try{
            log.info("Initiating tweet generation for district id:{}",districtId);
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            AppointmentSessionResponse sessionResponse=coWinAppointmentService.findAppointmentByDistrict(districtId, sdf.format(new Date()));
            twitterUtils.postTweetByAppointmentSessionDistrictId(sessionResponse);
            return new ResponseModel("Success", "Done");
        }catch (Exception e){
            log.error("An error occurred in posting tweet about districtId:"+districtId, e);
        }
        return new ResponseModel("Failure", "Error occurred");
    }

    @Override
    public ResponseModel postStateStatus(String stateId) {
        try{
            DistrictAPIResponse districtAPIResponse=coWinLocationService.findDistrictsByStateId(stateId);
            if(!CollectionUtils.isEmpty(districtAPIResponse.getDistricts())){
                for(Districts district:districtAPIResponse.getDistricts()){
                    postDistrictStatus(district.getDistrictId());
                }
            }else{
                return new ResponseModel("Failure", "Invalid state Id.");
            }
        }catch (Exception e){
            log.error("An error occurred in posting tweet about stateId:"+stateId, e);
        }
        return new ResponseModel("Failure", "Error occurred");
    }

    @Override
    public ResponseModel postCountryStatus() {
        try{
            StatesAPIResponse statesAPIResponse=coWinLocationService.allStates();
            if(!CollectionUtils.isEmpty(statesAPIResponse.getStates())){
                for(States state: statesAPIResponse.getStates()){
                    postStateStatus(state.getStateId().toString());
                }
            }else{
                log.info("Unable to fetch State codes from CoWin.");
                return new ResponseModel("Failure", "Unable to fetch State codes from CoWin.");
            }
        }catch(Exception e){
            log.error("An error occurred in posting tweet about country:", e);
        }
        return new ResponseModel("Failure", "Error occurred");
    }

}
