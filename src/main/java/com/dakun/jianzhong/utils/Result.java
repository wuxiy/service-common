package com.dakun.jianzhong.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public class Result<T> {

    private int status;
    private String message;
    private T data;

    public Result() {}

    public Result(ResultCode resultCode, String message) {
        this.status = resultCode.status;
        this.message = message;
    }

    public Result setCode(ResultCode resultCode) {
        this.status = resultCode.status;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Result setStatus(int code) {
        this.status = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
