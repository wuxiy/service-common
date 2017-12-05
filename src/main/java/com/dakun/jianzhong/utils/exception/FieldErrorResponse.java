package com.dakun.jianzhong.utils.exception;

import org.springframework.validation.FieldError;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
public class FieldErrorResponse {

    private String resource;
    private String field;
    private String code;
    private String message;

    public static FieldErrorResponse from(FieldError fieldError) {
        FieldErrorResponse fieldErrorResponse = new FieldErrorResponse();
        fieldErrorResponse.setResource(fieldError.getObjectName());
        fieldErrorResponse.setField(fieldError.getField());
        fieldErrorResponse.setCode(fieldError.getCode());
        fieldErrorResponse.setMessage(fieldError.getDefaultMessage());

        return fieldErrorResponse;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
