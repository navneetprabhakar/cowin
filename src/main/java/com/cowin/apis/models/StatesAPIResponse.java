package com.cowin.apis.models;

import com.cowin.apis.data.models.States;
import lombok.Data;

import java.util.List;

/**
 * API Response model for States API
 * @author navneetprabhakar
 */
@Data
public class StatesAPIResponse {
    private List<States> states;
    private Long ttl;
}
