package com.cowin.apis.service;

import com.cowin.apis.models.DistrictAPIResponse;
import com.cowin.apis.models.StatesAPIResponse;

/**
 * This interface manages interaction with CoWin Location services
 * @author navneetprabhakar
 */
public interface CoWinLocationService {
    /**
     * This method fetches all States from Cowin public APIs
     * @return @{@link StatesAPIResponse}
     */
    StatesAPIResponse allStates();

    /**
     * This method finds all districts by state Id
     * @param stateId : State Id
     * @return @{@link DistrictAPIResponse}
     */
    DistrictAPIResponse findDistrictsByStateId(String stateId);
}
