package com.cowin.apis.utils;


import com.cowin.apis.data.models.Appointments;
import org.springframework.stereotype.Component;

@Component
public class TwitterUtils {


    public String prepareTweetByAppointment(Appointments appointments){
        StringBuilder sb=new StringBuilder();
        sb.append("Pincode:").append(appointments.getPincode()).append(",");
        sb.append("Name:").append(appointments.getName()).append(",").append("Address:").append(appointments.getAddress()).append(",");
        sb.append("Vaccine:").append(appointments.getVaccine()).append(",").append("Available Capacity:")
                .append(appointments.getAvailable_capacity()).append(",").append("Slots:");
        for(String slot:appointments.getSlots()){
            sb.append(slot).append(" ");
        }
        sb.append("#CovidVaccine ").append("#").append(appointments.getDistrictName());
        return sb.toString().trim();
    }


}
