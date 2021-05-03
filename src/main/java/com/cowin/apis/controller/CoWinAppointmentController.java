package com.cowin.apis.controller;

import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.models.CalendarAPIResponse;
import com.cowin.apis.service.CoWinAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller interacts with CoWin Location services
 * @author navneetprabhakar
 */
@RestController
@RequestMapping("v1/appointment")
public class CoWinAppointmentController {

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    /**
     * This API calls findByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    @GetMapping("findByPin")
    public AppointmentSessionResponse findAppointmentByPincode(
            @RequestParam(name = "pincode") @NonNull Integer pincode, @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByPincode(pincode,date);
    }

    /**
     * This API calls findByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    public AppointmentSessionResponse findAppointmentByDistrict(
            @RequestParam(name = "district_id") @NonNull Integer disctrictId, @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByDistrict(disctrictId, date);
    }

    /**
     * This API calls calendarByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    public CalendarAPIResponse findCalendarAppointmentByPin(
            @RequestParam(name = "pincode") @NonNull Integer pincode, @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findCalendarAppointmentByPin(pincode, date);
    }

    /**
     * This API calls calendarByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    public CalendarAPIResponse findCalendarAppointmentByDistrict(
            @RequestParam(name = "district_id") @NonNull Integer disctrictId, @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findCalendarAppointmentByDistrict(disctrictId, date);
    }
}
