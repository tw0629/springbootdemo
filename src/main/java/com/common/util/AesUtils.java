package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author David Tian
 * @desc
 * @since 2021/11/1 15:05
 */
public class AesUtils {
    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String ASSETS_DEV_PWD_FIELD = "123456";

    private static final Logger log = LoggerFactory.getLogger(AesUtils.class);

    private AesUtils() {}

    /**
     * AES 加密操作
     *
     * @param content   待加密内容
     * @param secretKey 加密秘钥
     *
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String secretKey) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(secretKey));
            byte[] result = cipher.doFinal(byteContent);
            return Base64Utils.encodeToString(result);
        } catch (Exception ex) {
            log.error("[kms-sdk] aes encrypt data failed: {}", ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content   待加密明文
     * @param secretKey 秘钥
     *
     * @return 密文
     */
    public static String decrypt(String content, String secretKey) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(secretKey));
            //执行操作
            byte[] result = cipher.doFinal(Base64Utils.decodeFromString(content));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            log.error("[kms-sdk] aes decrypt data failed: {}", ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @param password 秘钥字符串
     *
     * @return 数据秘钥
     */
    private static SecretKeySpec getSecretKey(String password) {
        // 返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            log.error("[kms-sdk] generate secret key failed: {}", ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String origin = "tian is very piaoyi";
        String encrypt = AesUtils.encrypt(origin, AesUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt = AesUtils.decrypt(encrypt, AesUtils.ASSETS_DEV_PWD_FIELD);
        System.out.println("原文："+origin);
        System.out.println("加密后："+encrypt);
        System.out.println("解密后："+decrypt);
    }
}
