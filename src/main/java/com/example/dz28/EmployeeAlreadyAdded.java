package com.example.dz28;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAdded extends RuntimeException{
    public EmployeeAlreadyAdded() {
    }

    public EmployeeAlreadyAdded(String message) {
        super(message);
    }

    public EmployeeAlreadyAdded(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAdded(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAdded(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
