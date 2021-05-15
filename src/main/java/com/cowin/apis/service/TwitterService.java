package com.cowin.apis.service;

import com.cowin.apis.models.ResponseModel;

/**
 * This interface contains all the twitter status update services
 * @author navneetprabhakar
 */
public interface TwitterService {

    /**
     * This method posts twitter status about vaccine slots status by pincode
     * @param pincode: Pincode of the area
     * @return @{@link ResponseModel}
     */
    ResponseModel postPincodeStatus(Integer pincode);

    /**
     * This method posts twitter status about vaccine slots status by district Id
     * @param districtId: District Id as per Cowin db
     * @return @{@link ResponseModel}
     */
    ResponseModel postDistrictStatus(Integer districtId);

    /**
     * This method posts twitter status about vaccine slots status by state Id
     * @param stateId: State Id as per Cowin db
     * @return @{@link ResponseModel}
     */
    ResponseModel postStateStatus(String stateId);

    /**
     * This method posts twitter status about vaccine slots status by country Id
     * @return @{@link ResponseModel}
     */
    ResponseModel postCountryStatus();
}
