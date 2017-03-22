package com.server.v1.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by wanghaoyang on 17-3-21.
 */
public class EncodeTools {

    //base64编码
    public static String base64Encode(String string){
        return new BASE64Encoder().encode(string.getBytes());
    }
    //base64解码
    public static String base64Decode(String string) throws Exception{
        return new String(new BASE64Decoder().decodeBuffer(string));
    }
    //md5加密
    public static String newMD5(String str) {
        String result="";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((str).getBytes("UTF-8"));
            byte b[] = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer("");

            for(int offset=0; offset<b.length; offset++){
                i = b[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            result = buf.toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
