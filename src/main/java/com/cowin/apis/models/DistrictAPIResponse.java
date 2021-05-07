package com.cowin.apis.models;

import com.cowin.apis.data.models.Districts;
import lombok.Data;

import java.util.List;

/**
 * API Response model for findByDistrict
 * @author navneetprabhakar
 */
@Data
public class DistrictAPIResponse {
    private List<Districts> districts;
    private Long ttl;
}
