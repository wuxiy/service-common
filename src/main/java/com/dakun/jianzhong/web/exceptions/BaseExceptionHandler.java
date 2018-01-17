package com.dakun.jianzhong.web.exceptions;

import com.dakun.jianzhong.utils.Result;
import com.dakun.jianzhong.utils.ResultCode;
import com.dakun.jianzhong.utils.ResultGenerator;
import com.dakun.jianzhong.utils.ServiceException;
import com.dakun.jianzhong.utils.exception.*;
import com.google.common.collect.Lists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 11/3/2017
 * @author wangjie
 */
public class BaseExceptionHandler {

    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<Object> handleInvalidRequest(InvalidRequestException e, WebRequest webRequest) {

        ErrorResponse errorResponse = new ErrorResponse();
        List<FieldErrorResponse> fieldErrorResponses = Lists.newArrayList();

        if (e.getErrors() != null) {
            FieldError firstError = e.getErrors().getFieldError();
            String message = firstError.getDefaultMessage();
            errorResponse.setCode(ResultCode.FAIL).setMessage(message);

            e.getErrors().getFieldErrors()
                    .forEach(fieldError -> {
                        FieldErrorResponse fieldErrorResponse = FieldErrorResponse.from(fieldError);
                        fieldErrorResponses.add(fieldErrorResponse);
                    });

            errorResponse.setFieldErrors(fieldErrorResponses);
        } else if (!StringUtils.isEmpty(e.getMessage())) {
            errorResponse.setCode(ResultCode.FAIL).setMessage(e.getMessage());
        }

        return handleExceptionInternal(e, errorResponse, null, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler({UnauthenticatedException.class, UnauthorizedException.class})
    public ResponseEntity<Object> handleAuthException(ServiceException e, WebRequest request) {

        Result result = ResultGenerator.genFailResult(e.getMessage());
        result.setCode(ResultCode.UNAUTHORIZED);

        return handleExceptionInternal(e, result, null, HttpStatus.UNAUTHORIZED, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                           HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
