package com.dakun.jianzhong.utils;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
