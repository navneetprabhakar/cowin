package com.cowin.apis.service.impl;

import com.cowin.apis.data.models.Appointments;
import com.cowin.apis.data.models.Session;
import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.service.TwitterService;
import com.cowin.apis.utils.TwitterUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import twitter4j.Twitter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Log4j2
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private Twitter twitter;

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    @Autowired
    private TwitterUtils twitterUtils;

    @Override
    public String postCenterStatus(Integer pincode) {
        try{
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            AppointmentSessionResponse sessionResponse=coWinAppointmentService.findAppointmentByPincode(pincode, sdf.format(new Date()));
            if(!CollectionUtils.isEmpty(sessionResponse.getSessions())){
                for(Appointments session:sessionResponse.getSessions()){
                    String tweet=twitterUtils.prepareTweetByAppointment(session);
                    twitter.updateStatus(tweet);
                }
            }
            return "Done";
        }catch (Exception e){
            log.error("An error occurred in posting tweet about pincode:"+pincode, e);
        }
        return null;
    }

}
