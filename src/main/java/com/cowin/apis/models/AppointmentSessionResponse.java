package com.cowin.apis.models;

import com.cowin.apis.data.models.Appointments;
import lombok.Data;

import java.util.List;

/**
 * API response model for findByPin
 * @author navneetprabhakar
 */
@Data
public class AppointmentSessionResponse {
    private List<Appointments> sessions;
}
