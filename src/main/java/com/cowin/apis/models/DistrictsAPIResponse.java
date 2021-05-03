package com.cowin.apis.models;

import com.cowin.apis.data.models.Districts;
import lombok.Data;

import java.util.List;

/**
 * API Response model for Districts API
 * @author navneetprabhakar
 */
@Data
public class DistrictsAPIResponse {
    private List<Districts> districts;
}
