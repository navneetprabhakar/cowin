package com.cowin.apis.service;

import com.cowin.apis.models.AppointmentSessionResponse;
import com.cowin.apis.models.CalendarAPIResponse;

/**
 * This interface manages interaction with CoWin Appointment services
 * @author navneetprabhakar
 */
public interface CoWinAppointmentService {
    /**
     * This method calls findByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    AppointmentSessionResponse findAppointmentByPincode(Integer pincode, String date);

    /**
     * This method calls findByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link AppointmentSessionResponse}
     */
    AppointmentSessionResponse findAppointmentByDistrict(Integer disctrictId, String date);

    /**
     * This method calls calendarByPin API of CoWin Appointment services
     * @param pincode : The pincode for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    CalendarAPIResponse findCalendarAppointmentByPin(Integer pincode, String date);

    /**
     * This method calls calendarByDistrict API of CoWin Appointment services
     * @param disctrictId : The district id for which Appointment is being searched
     * @param date : The date for which Appointment is being searched format (dd-MM-yyyy)
     * @return response : @{@link CalendarAPIResponse}
     */
    CalendarAPIResponse findCalendarAppointmentByDistrict(Integer disctrictId, String date);
}
