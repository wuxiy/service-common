package com.dakun.jianzhong.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by hexingfu on 2017/10/24.
 */
public class RestUtils {

    public static <T> T exchange(RestTemplate restTemplate, String url, HttpMethod method, Map<String,Object> params,Class<T> responseType){
        try{
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            if(params!=null && params.size()>0){
                Iterator<Map.Entry<String,Object>> it =  params.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry<String,Object> entry = it.next();
                    builder.queryParam(entry.getKey(),entry.getValue());
                }
            }
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);
            HttpEntity<String> response = restTemplate.exchange(
                    builder.build().encode().toUri(),
                    method,
                    entity,
                    String.class);
            if(response!=null && response.getBody()!=null ){
                JSONObject rs = JSONObject.parseObject(response.getBody());
                if(rs.getInteger("status")==200 && rs.get("data")!=null){
                    if(rs.get("data") instanceof JSONArray ){
                        if(rs.getJSONArray("data").size()>0){
                            return rs.getJSONArray("data").toJavaObject(responseType);
                        }else{
                            return responseType.newInstance();
                        }
                    }
                    return rs.getJSONObject("data").toJavaObject(responseType);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static Result exchange(RestTemplate restTemplate, String url, HttpMethod method, Map<String,Object> params){
        try{
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            if(params!=null && params.size()>0){
                Iterator<Map.Entry<String,Object>> it =  params.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry<String,Object> entry = it.next();
                    builder.queryParam(entry.getKey(),entry.getValue());
                }
            }
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);
            HttpEntity<Result> response = restTemplate.exchange(
                    builder.build().encode().toUri(),
                    method,
                    entity,
                    Result.class);
            if(response!=null && response.getBody()!=null){
                return response.getBody();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
