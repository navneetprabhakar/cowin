package com.cowin.apis.utils;


import com.cowin.apis.data.models.Appointments;
import com.cowin.apis.models.AppointmentSessionResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import twitter4j.Twitter;

/**
 * This class is for twitter status update utility
 * @author navneetprabhakar
 */
@Component
@Log4j2
public class TwitterUtils {

    @Autowired
    private Twitter twitter;

    /**
     * This method prepares tweet by appointment slots
     * @param appointments
     * @return Twitter Status string
     */
    public String prepareTweetByAppointment(Appointments appointments, String date){
        StringBuilder sb=new StringBuilder();
        sb.append("Pincode:").append(appointments.getPincode()).append(",").append("Date:").append(date).append(",");
        sb.append("Name:").append(appointments.getName()).append(",").append("Address:").append(appointments.getAddress()).append(",");
        sb.append("Vaccine:").append(appointments.getVaccine()).append(",").append("Available Capacity:")
                .append(appointments.getAvailable_capacity()).append(",").append("Slots:");
        for(String slot:appointments.getSlots()){
            sb.append(slot).append(" ");
        }
        sb.append("#CovidVaccine ").append("#VaccinationSlots ").append("#").append(appointments.getDistrictName().replace(" ",""));
        return sb.toString().trim();
    }

    /**
     * This method generates default No appointment tweet for pincode and date
     * @param pincode: Pincode of the area
     * @param date: Date for which status was checked.
     * @return Tweet: e.g. No Appointment slots available at pincode:110009 on date:15-05-2021
     */
    public String noAppointmentTweet(Integer pincode, String date){
        StringBuilder sb=new StringBuilder("No Appointment slots available at pincode:");
        sb.append(pincode).append(" on date:").append(date).append(System.lineSeparator());
        sb.append("#CovidVaccine ").append("#VaccinationSlots");
        return sb.toString();
    }

    /**
     * This method posts tweet individually for each center at a pincode.
     * @param sessionResponse : @{@link AppointmentSessionResponse}
     * @param date : Date of status check
     * @param pincode : Pincode of the area
     * @throws Exception
     */
    public void postTweetByAppointmentSessionPincode(AppointmentSessionResponse sessionResponse, String date, Integer pincode) throws Exception{
        String tweet=null;
        if(!CollectionUtils.isEmpty(sessionResponse.getSessions())){
            for(Appointments session:sessionResponse.getSessions()){
                tweet=prepareTweetByAppointment(session,date);
                if(tweet.length()>=280){
                    tweet=tweet.substring(0,280);
                }
                log.info(tweet);
                twitter.updateStatus(tweet);
            }
        }else{
            tweet=noAppointmentTweet(pincode, date);
            log.info(tweet);
            twitter.updateStatus(tweet);
        }
    }

    /**
     * This method posts tweet of slot availability by District Id
     * @param sessionResponse : @{@link AppointmentSessionResponse}
     * @throws Exception
     */
    public void postTweetByAppointmentSessionDistrictId(AppointmentSessionResponse sessionResponse,String date) throws Exception{
        String tweet=null;
        if(!CollectionUtils.isEmpty(sessionResponse.getSessions())){
            for(Appointments session:sessionResponse.getSessions()){
                tweet=prepareTweetByAppointment(session, date);
                if(tweet.length()>=280){
                    tweet=tweet.substring(0,280);
                }
                log.info(tweet);
                twitter.updateStatus(tweet);
            }
        }
    }

}
