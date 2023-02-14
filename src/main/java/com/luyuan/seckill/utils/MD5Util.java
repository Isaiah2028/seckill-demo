package com.luyuan.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: IsaiahLu
 * @date: 2023/2/14 15:12
 */
@Component
public class MD5Util {

    private static final String SALT = "1a2b3c4d";

    /**
     * md5加密
     *
     * @param msg 密码
     * @return MD5加密后密码
     */
    public static String md5(String msg) {
        return DigestUtils.md5Hex(msg);
    }

    /**
     * @param inputPass
     * @return
     */
    public static String inputPassToFromPass(String inputPass) {
        String str = SALT.charAt(0) + SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(1);
        return md5(str);
    }

    /**
     * @param formPass
     * @param salt
     * @return
     */
    public static String fromPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(0) + salt.charAt(3) + formPass + salt.charAt(5) + salt.charAt(1);
        return str;
    }

    /**
     *
     * @param inputPass 前端传入pass
     * @param salt 随机盐值
     * @return dbPass
     */
    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //c8a3f82c63b713309bf6fedd4781ee08
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(fromPassToDBPass("c8a3f82c63b713309bf6fedd4781ee08","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}
