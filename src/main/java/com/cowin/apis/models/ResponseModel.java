package com.cowin.apis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author navneetprabhakar
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel<T> {

    private String status;
    private String message;
    private T response;

    public ResponseModel(String status, String message){
        this.message=message;
        this.status=status;
    }
}
