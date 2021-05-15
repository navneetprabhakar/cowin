package com.cowin.apis.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data model for Districts
 * @author navneetprabhakar
 */
@Data
public class Districts {
    @JsonProperty("district_id")
    private Integer districtId;
    @JsonProperty("district_name")
    private String stateName;
}
