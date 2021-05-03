package com.cowin.apis.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Data model for States
 * @author navneetprabhakar
 */
@Data
public class States {
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("state_name")
    private String stateName;
}
