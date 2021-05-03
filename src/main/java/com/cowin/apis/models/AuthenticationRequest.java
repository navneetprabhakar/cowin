package com.cowin.apis.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Request model for CoWin registration authentication
 * @author navneetprabhakar
 */
@Data
@ApiModel
public class AuthenticationRequest {
    @ApiModelProperty(notes = "Mobile number of the user")
    private String mobile;
}
