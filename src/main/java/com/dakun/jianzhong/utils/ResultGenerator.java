package com.dakun.jianzhong.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genListOrPageResult(List list, Integer page, Integer size){
        if (page != null && size != null && page>0 && size>0) {
            PageInfo pageInfo = new PageInfo(list);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("list", list);
            result.put("total", pageInfo.getTotal());
            return ResultGenerator.genSuccessResult(result);
        }else{
            return ResultGenerator.genSuccessResult(list);
        }
    }
}
