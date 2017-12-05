package com.dakun.jianzhong.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lichenghai on 2017/8/1 0001.
 */
public class MD5 {

    protected static char hexDigits[] = {'T','v','f','3','Y','1','P','m','s','4','c','D','g','5','9','h'};
    protected static MessageDigest messageDigest = null;

    static{
        try{
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e) {
            System.err.println(MD5.class.getName()+"初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {

        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    /**
     * 字符串的md5加密
     * @param input
     * @return
     */
    public static String getMD5String(String input) {
        // 输入的字符串转换成字节数组
        byte[] inputByteArray = input.getBytes();
        // inputByteArray是输入字符串转换得到的字节数组
        messageDigest.update(inputByteArray);
        // 转换并返回结果，也是字节数组，包含16个元素
        byte[] resultByteArray = messageDigest.digest();
        // 字符数组转换成字符串返回
        return bufferToHex(resultByteArray);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //测试字符串MD5加密
        //123456: e10adc3949ba59abbe56e057f20f883e
        //eastcom:  6997c46956185a7c4d452646fc9c69e2
        System.out.println(getMD5String("test"));


    }
}
