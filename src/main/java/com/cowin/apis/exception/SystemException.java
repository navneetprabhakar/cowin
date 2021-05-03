package com.cowin.apis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * This class acts as System Exception
 * @author navneetprabhakar
 */
@Data
@AllArgsConstructor
public class SystemException extends RuntimeException{

    private String message;
    private HttpStatus status;
}
