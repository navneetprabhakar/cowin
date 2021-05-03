package com.cowin.apis.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Data model for Appointment sessions
 * @author navneetprabhakar
 */
@Data
public class Appointments {
    @JsonProperty("center_id")
    private Integer centerId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("district_name")
    private String districtName;
    @JsonProperty("block_name")
    private String blockName;
    @JsonProperty("pincode")
    private Integer pincode;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("long")
    private Double lng;
    @JsonProperty("fee_type")
    private String feeType;
    @JsonProperty("session_id")
    private String session_id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("fee")
    private String fee;
    @JsonProperty("min_age_limit")
    private Integer minAgeLimit;
    @JsonProperty("vaccine")
    private String vaccine;
    @JsonProperty("slots")
    private List<String> slots;

}
