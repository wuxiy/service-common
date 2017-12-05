package com.dakun.jianzhong.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Base64Utils {
    // 加密  
    public static String EncBase64(String str) {
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);
        }  
        return s;  
    }  
  
    // 解密  
    public static String DecBase64(String s) {
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }
    /*public static void main(String[] ar){
        String s = EncBase64("sadasz中国323");
        System.out.println(s);
        System.out.println(DecBase64(s));
    }*/
}  