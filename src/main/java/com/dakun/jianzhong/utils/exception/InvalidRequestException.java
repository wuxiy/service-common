package com.dakun.jianzhong.utils.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

/**
 * <p>User: wangjie
 * <p>Date: 4/28/2017
 * @author wangjie
 */
public class InvalidRequestException extends RuntimeException {

    private Errors errors;

    public InvalidRequestException(Errors errors) {
        super(errors.getFieldError().getDefaultMessage());
        this.errors = errors;
    }

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    private String getDefaultMessage(Errors errors) {

        FieldError fieldError = errors.getFieldError();
        if (fieldError == null) {
            return "参数错误";
        } else {
            return fieldError.getDefaultMessage();
        }
    }

    public Errors getErrors() {
        return this.errors;
    }
}
