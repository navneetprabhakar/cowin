package com.cowin.apis.models;

import lombok.Data;

/**
 * Request model for CoWin registration authentication
 * @author navneetprabhakar
 */
@Data
public class AuthenticationRequest {
    private String mobile;
}
