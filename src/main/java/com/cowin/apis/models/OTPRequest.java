package com.cowin.apis.models;

import lombok.Data;

/**
 * Request model for CoWin OTP Authentication Request
 * @author navneetprabhakar
 */
@Data
public class OTPRequest {
    private String txnId;
    private String otp;
}
