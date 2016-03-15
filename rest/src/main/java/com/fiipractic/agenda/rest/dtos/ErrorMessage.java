package com.fiipractic.agenda.rest.dtos;

/**
 * File created by a.chmilevski on 3/15/2016 - 2:20 PM.
 * RadiON
 */
public class ErrorMessage {
    private Long statusCode;
    private String error;
    private String message;

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
