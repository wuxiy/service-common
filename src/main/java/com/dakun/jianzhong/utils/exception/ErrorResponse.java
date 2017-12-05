package com.dakun.jianzhong.utils.exception;

import com.dakun.jianzhong.utils.Result;
import com.dakun.jianzhong.utils.ResultCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends Result<Object> {

    private List<FieldErrorResponse> fieldErrors;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message) {
        super(ResultCode.INTERNAL_SERVER_ERROR, message);
    }

    public ErrorResponse(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public List<FieldErrorResponse> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResponse> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
