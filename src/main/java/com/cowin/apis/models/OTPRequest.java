package com.cowin.apis.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request model for CoWin OTP Authentication Request
 * @author navneetprabhakar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class OTPRequest {
    @ApiModelProperty(notes = "transaction id of the request")
    private String txnId;
    @ApiModelProperty(notes = "otp received by user")
    private String otp;
}
