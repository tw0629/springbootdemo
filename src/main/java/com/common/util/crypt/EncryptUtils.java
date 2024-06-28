package com.common.util.crypt;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author David Tian
 * @desc https://blog.csdn.net/zcmain/article/details/90640797
 *
 * Java原生是不支持AESWRAP算法的，因此可以引入BC的依赖，再使用转换模式AESWRAP。
 * 上面的例子需要注意，因为使用了AESWRAP算法，输入的需要加密的报文长度必须是8的倍数。
 *
 * @since 2021/11/1 14:30
 */
public enum EncryptUtils {

    /**
     * SINGLETON
     */
    SINGLETON;

    private static final String SECRET = "throwable";
    private static final String CHARSET = "UTF-8";

    //装载BC提供商
    static {
        Security.addProvider(new BouncyCastleProvider());
    }


    private Cipher createAesCipher() throws Exception {
        return Cipher.getInstance("AESWRAP");
    }

    public String encryptByAes(String raw) throws Exception {
        Cipher aesCipher = createAesCipher();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AESWRAP");
        keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AESWRAP");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] bytes = aesCipher.doFinal(raw.getBytes(CHARSET));
        return Hex.encodeHexString(bytes);
    }

    public String decryptByAes(String raw) throws Exception {
        byte[] bytes = Hex.decodeHex(raw.toCharArray());
        Cipher aesCipher = createAesCipher();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AESWRAP");
        keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AESWRAP");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(aesCipher.doFinal(bytes), CHARSET);
    }

    public static void main(String[] args) throws Exception {
        String raw = "tianweitianwei66";
        String en = EncryptUtils.SINGLETON.encryptByAes(raw);
        System.out.println(en);
        String de = EncryptUtils.SINGLETON.decryptByAes(en);
        System.out.println(de);
    }
}
