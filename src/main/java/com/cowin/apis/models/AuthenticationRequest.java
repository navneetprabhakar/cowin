package com.cowin.apis.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request model for CoWin registration authentication
 * @author navneetprabhakar
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @ApiModelProperty(notes = "Mobile number of the user")
    private String mobile;
}
