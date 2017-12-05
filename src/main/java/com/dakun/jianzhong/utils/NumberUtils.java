package com.dakun.jianzhong.utils;

/**
 * <p>User: wangjie
 * <p>Date: 10/25/2017
 */
public class NumberUtils {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    // 判断一个字符串是否都为数字
    public static boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }
}
