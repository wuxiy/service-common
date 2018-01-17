package com.dakun.jianzhong.utils.exception;

import com.dakun.jianzhong.utils.ServiceException;

/**
 * @author wangjie
 * @date 1/9/2018
 */
public class UnauthorizedException extends ServiceException {

    public static final String MESSAGE = "用户权限验证失败";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    public UnauthorizedException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
