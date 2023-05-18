package com.example.gas_station.exceptions;

import org.springframework.http.HttpStatus;
public class RestAppException extends Exception{
    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;

    public RestAppException(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestAppException(String errorMessage, HttpStatus httpStatus, String errorCode, String message1) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = message1;
    }

    public RestAppException(String errorMessage, Throwable cause, HttpStatus httpStatus, String errorCode, String message1) {
        super(errorMessage, cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = message1;
    }

    public RestAppException(Throwable cause, HttpStatus httpStatus, String errorCode, String errorMessage) {
        super(cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestAppException(String errorMessage, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus, String errorCode, String message1) {
        super(errorMessage, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = message1;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
