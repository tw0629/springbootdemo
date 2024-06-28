package com.tw.encrypt.des;

import com.common.util.crypt.CipherMessage;

import java.security.Key;

/**
 * @author David Tian
 * @desc https://blog.csdn.net/lindonghai/article/details/40149853
 * @since 2021/11/1 14:55
 */
public class TestMain {

    public static void main(String[] args) {
        String algorithm = "DES"; // 定义加密算法,可用 DES,DESede,Blowfish
        String message = "Hello World. 这是待加密的信息"; // 生成个DES密钥
        Key key;

        CipherMessage cm = new CipherMessage(algorithm, message);
        key = cm.initKey();
        byte[] msg = cm.CipherMsg();
        System.out.println("加密后的密文为：" + new String(msg));
        // System.out.println("密钥为："+new String(cm.getBinaryKey(key)));


        System.out.println(cm.getBinaryKey(key));
        System.out.println("解密密文为：" + cm.EncipherMsg(msg, key));

    }
}
