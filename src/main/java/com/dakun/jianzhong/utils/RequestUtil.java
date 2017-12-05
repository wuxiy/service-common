package com.dakun.jianzhong.utils;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Created by hexingfu on 2017/8/11.
 */
public class RequestUtil {
    /**
     * 根据请求头获取用户id
     * @param headers
     * @return
     */
    public static int getAccountId(HttpHeaders headers){
        int accountId = 0;
        if(headers != null) {
            List<String> accountIdHeader = headers.get("accountId");
            if(accountIdHeader!=null&&accountIdHeader.size()>0) {
                try{
                    accountId = Integer.parseInt(accountIdHeader.get(0));
                }catch (Exception ex){
                    System.out.print("请求头异常");
                }
            }
        }
        return accountId;
    }
}
