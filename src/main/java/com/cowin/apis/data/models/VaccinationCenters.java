package com.cowin.apis.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * Data model for Vaccination Centers
 * @author navneetprabhakar
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccinationCenters {
    @JsonProperty("center_id")
    private Integer centerId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
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
    @JsonProperty("fee")
    private String fee;
    @JsonProperty("sessions")
    private List<Session> sessions;
}
