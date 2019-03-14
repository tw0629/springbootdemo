package com.common;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.security.MessageDigest;

public class SecurityUtil implements Serializable {
    private static final long serialVersionUID = -3063318512161179435L;

    public SecurityUtil() {
    }

    public static String getDigest(String srcString) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(DigestUtils.md5Hex(srcString).getBytes());
    }


    public static String doSign(String content, String charset, String keys) {
        String sign = "";
        content = content + keys;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes(charset));
            sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(md.digest()), charset);
            return sign;
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static void main(String[] args) {
        System.out.println("=========>" + "     " + getDigest("502266891"));

    }
}

