package com.Employee.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
