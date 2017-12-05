package com.dakun.jianzhong.utils.exception;

import com.dakun.jianzhong.utils.ServiceException;

/**
 * <p>User: wangjie
 * <p>Date: 10/17/2017
 * @author wangjie
 */
public class IllegalArgumentException extends ServiceException {

    public IllegalArgumentException() {
    }

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
