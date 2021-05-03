package com.cowin.apis.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Response model for CoWin authentication response
 * @author navneetprabhakar
 */
@Data
@ApiModel
public class AuthenticationResponse {
    @ApiModelProperty(notes = "transaction id of the request")
    private String txnId;
}
