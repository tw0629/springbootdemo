package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author David Tian
 * @desc
 * @since 2021/11/1 15:10
 */
public class DesUtils {
    private static final String DES_ALGORITHM = "DES";

    private static final Logger log = LoggerFactory.getLogger(DesUtils.class);

    private static Cipher encryptCipher = null;
    private static Cipher decryptCipher = null;

    private static final Object ENCRYPT_CIPHER_LOCK = new Object();
    private static final Object DECRYPT_CIPHER_LOCK = new Object();

    private DesUtils() {}

    /**
     * DES加密
     *
     * @param plainData 原始字符串
     * @param secretKey 加密密钥
     *
     * @return 加密后的字符串
     *
     * @throws Exception kms系统异常
     */
    @SuppressWarnings("squid:S5547")
    public static String encrypt(String plainData, String secretKey) throws Exception {
        synchronized (ENCRYPT_CIPHER_LOCK) {
            if (encryptCipher == null) {
                try {
                    encryptCipher = Cipher.getInstance(DES_ALGORITHM);
                    encryptCipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey));
                } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidKeySpecException e) {
                    log.error("[kms-sdk] init des encrypt chpher failed: {}", e.getMessage());
                    throw new Exception(e);
                }
            }
        }

        try {
            // 为了防止解密时报javax.crypto.IllegalBlockSizeException: Input length must
            // be multiple of 8 when decrypting with padded cipher异常，
            // 不能把加密后的字节数组直接转换成字符串
            byte[] buf = encryptCipher.doFinal(plainData.getBytes());
            return Base64Utils.encodeToString(buf);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            log.error("[kms-sdk] encrypt data failed: {}", e.getMessage());
            throw new Exception(e);
        }
    }


    /**
     * DES解密
     *
     * @param secretData 密码字符串
     * @param secretKey  解密密钥
     *
     * @return 原始字符串
     *
     * @throws Exception kms系统异常
     */
    @SuppressWarnings("squid:S5547")
    public static String decrypt(String secretData, String secretKey) throws Exception {
        synchronized (DECRYPT_CIPHER_LOCK) {
            if (decryptCipher == null) {
                try {
                    decryptCipher = Cipher.getInstance(DES_ALGORITHM);
                    decryptCipher.init(Cipher.DECRYPT_MODE, generateKey(secretKey));
                } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidKeySpecException e) {
                    log.error("[kms-sdk] init des decrypt chpher failed: {}", e.getMessage());
                    throw new Exception(e);
                }
            }
        }

        try {
            byte[] buf = decryptCipher.doFinal(Base64Utils.decodeFromString(secretData));
            return new String(buf);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            log.error("[kms-sdk] decrypt data failed: {}", e.getMessage());
            throw new Exception(e);
        }
    }

    /**
     * 获得秘密密钥
     *
     * @param secretKey secretKey
     *
     * @return SecretKey
     *
     * @throws NoSuchAlgorithmException exception
     * @throws InvalidKeySpecException  exception
     * @throws InvalidKeyException      exception
     */
    private static SecretKey generateKey(String secretKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
        DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
        keyFactory.generateSecret(keySpec);
        return keyFactory.generateSecret(keySpec);
    }

    /**
     * DES秘钥 好像不是随便的, 有大小长度限制
     * 好像 只能是qwertttttt, 以后在研究……
     */
    private static final String ASSETS_DEV_PWD_FIELD = "qwertttttt";

    public static void main(String[] args) throws Exception {
        //System.err.println(DesUtils.decrypt("ulqM8c2sASY4krtgaX9qEQ==", "qwertttttt"));

        String origin = "tian is very piaoyi";
        String encrypt = DesUtils.encrypt(origin, DesUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt = DesUtils.decrypt(encrypt, DesUtils.ASSETS_DEV_PWD_FIELD);
        System.out.println("原文："+origin);
        System.out.println("DES加密后："+encrypt);
        System.out.println("DES解密后："+decrypt);
    }
}
