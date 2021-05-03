package com.cowin.apis.models;

import com.cowin.apis.data.models.VaccinationCenters;
import lombok.Data;

import java.util.List;

/**
 * API Response model for calendarByPin/calendarByDistrict
 * @author navneetprabhakar
 */
@Data
public class CalendarAPIResponse {
    private List<VaccinationCenters> centers;
}
