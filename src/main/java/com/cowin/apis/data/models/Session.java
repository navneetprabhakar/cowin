package com.cowin.apis.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * Data model for appointment session
 * @author navneetprabhakar
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

    @JsonProperty("session_id")
    private String session_id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("available_capacity")
    private Integer availableCapacity;
    @JsonProperty("available_capacity_dose1")
    private String available_capacity_dose1;
    @JsonProperty("available_capacity_dose2")
    private String available_capacity_dose2;
    @JsonProperty("min_age_limit")
    private Integer minAgeLimit;
    @JsonProperty("vaccine")
    private String vaccine;
    @JsonProperty("slots")
    private List<String> slots;
}
