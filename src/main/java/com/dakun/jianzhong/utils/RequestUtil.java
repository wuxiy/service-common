package com.dakun.jianzhong.utils;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Created by hexingfu on 2017/8/11.
 */
public class RequestUtil {

    public static final String DEFAULT_ADMIN_HEADER_NAME = "ADMIN-ID";

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

    /**
     * 获取当前登录后台管理用户, 从 http header 中获取
     * @param headers
     * @return
     */
    public static Integer getAdminId(HttpHeaders headers) {

        if (headers == null) {
            return null;
        }

        List<String> adminIds = headers.get(DEFAULT_ADMIN_HEADER_NAME);
        if (adminIds == null || adminIds.isEmpty()) {
            return null;
        } else {
            return Integer.valueOf(adminIds.get(0));
        }
    }
}
