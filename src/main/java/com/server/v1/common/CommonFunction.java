package com.server.v1.common;

import java.util.Random;

/**
 * Created by wanghaoyang on 17-3-21.
 */
public class CommonFunction {

    //生成随机字符串
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //md5
    //base64
    // utils/Tools
}
