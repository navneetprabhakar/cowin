package com.cowin.apis.controller;

import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.models.CalendarAPIResponse;
import com.cowin.apis.service.CoWinAppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "This controller interacts with CoWin Location services")
public class CoWinAppointmentController {

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    /**
     * This API calls findByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    @ApiOperation(value = "This API calls findByPin API of CoWin Appointment services")
    @GetMapping("findByPin")
    public AppointmentSessionResponse findAppointmentByPincode(
            @ApiParam(name = "pincode", type = "String", value = "Pincode", example = "110001",required = true) @RequestParam(name = "pincode") @NonNull Integer pincode,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByPincode(pincode,date);
    }

    /**
     * This API calls findByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    @ApiOperation(value = "This API calls findByDistrict API of CoWin Appointment services")
    @GetMapping("findByDistrict")
    public AppointmentSessionResponse findAppointmentByDistrict(
            @ApiParam(name = "district_id", type = "Integer", value = "District Id", example = "222",required = true)@RequestParam(name = "district_id") @NonNull Integer disctrictId,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByDistrict(disctrictId, date);
    }

    /**
     * This API calls calendarByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    @ApiOperation(value = "This API calls calendarByPin API of CoWin Appointment services")
    @GetMapping("calendarByPin")
    public CalendarAPIResponse findCalendarAppointmentByPin(
            @ApiParam(name = "pincode", type = "String", value = "Pincode", example = "110001",required = true) @RequestParam(name = "pincode") @NonNull Integer pincode,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findCalendarAppointmentByPin(pincode, date);
    }

    /**
     * This API calls calendarByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    @ApiOperation(value = "This API calls calendarByDistrict API of CoWin Appointment services")
    @GetMapping("calendarByDistrict")
    public CalendarAPIResponse findCalendarAppointmentByDistrict(
            @ApiParam(name = "district_id", type = "Integer", value = "District Id", example = "222",required = true)@RequestParam(name = "district_id") @NonNull Integer disctrictId,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findCalendarAppointmentByDistrict(disctrictId, date);
    }
}
