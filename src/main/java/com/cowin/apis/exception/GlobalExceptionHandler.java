package com.cowin.apis.exception;

import com.cowin.apis.models.ExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class acts as Global Controller Advice
 * @author navneetprabhakar
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    private static final ObjectMapper mapper=new ObjectMapper();

    @ExceptionHandler(value = {Throwable.class})
    @ResponseBody
    protected ResponseEntity<String> handleConflict(Throwable ex) throws JsonProcessingException {
        if(ex instanceof SystemException){
            log.error("GlobalExceptionHandler: {}",ex);
            return new ResponseEntity<String>(mapper.writeValueAsString(new ExceptionResponse(ex.getMessage())), ((SystemException) ex).getStatus());
        }else{
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
