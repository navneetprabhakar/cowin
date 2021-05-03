package com.cowin.apis.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Response model for CoWin OTP Authentication Request
 * @author navneetprabhakar
 */
@Data
@ApiModel
public class OTPResponse {
    @ApiModelProperty(notes = "Session token")
    private String token;
}
