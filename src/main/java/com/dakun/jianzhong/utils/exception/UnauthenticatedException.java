package com.dakun.jianzhong.utils.exception;

import com.dakun.jianzhong.utils.ServiceException;

/**
 * @author wangjie
 * @date 1/9/2018
 */
public class UnauthenticatedException extends ServiceException {

    private static final String MESSAGE = "用户未登录";

    public UnauthenticatedException() {
        super(MESSAGE);
    }

    public UnauthenticatedException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
