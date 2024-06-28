package com.common.util.crypt.pgp;

import org.bouncycastle.openpgp.PGPPublicKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author David Tian
 * @desc
 * @since 2022/8/4 18:24
 */
public class PgpTest {

    public static void main(String[] args) throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();

        //addSigunature();
        //verifySigunature();
        encryptFile();
        decryptFile();

        System.out.println("");
    }

    public  static  void addSigunature(){
        byte[] sign= PgpUtils.signatureCreate("/Users/tianwei/Downloads/SHOPLINE.zip",
                "/Users/tianwei/Project/souche-base/springbootdemo/src/main/java/com/common/util/crypt/pgp/SHOPLINE_TEST_secretKey.asc",
                "/Users/tianwei/Downloads/SHOPLINE_sign.zip",
                "12345678");
        System.out.println(new String(sign));
    }

    public  static  void verifySigunature(){
        boolean flag = PgpUtils.verifySignature("/Users/tianwei/Downloads/SHOPLINE.zip",
                "/Users/tianwei/Project/souche-base/springbootdemo/src/main/java/com/common/util/crypt/pgp/SHOPLINE_TEST_publicKey.asc",
                "/Users/tianwei/Downloads/SHOPLINE_sign.zip");
        System.out.println(flag);
    }


    public  static  void encryptFile()  throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();
        PGPPublicKey pgpPublicKey = pgpUtils.readPublicKey(new FileInputStream("/Users/tianwei/Project/souche-base/springbootdemo/src/main/java/com/common/util/crypt/pgp/SHOPLINE_TEST_publicKey.asc"));
        OutputStream os = new FileOutputStream(new File("/Users/tianwei/Downloads/SHOPLINE_encrypt7.zip.pgp"));
        pgpUtils.encryptFile(os,"/Users/tianwei/Downloads/SHOPLINE.zip",pgpPublicKey,false,false);

    }

    public  static  void decryptFile()  throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();
        pgpUtils.decryptFile(new FileInputStream(new File("/Users/tianwei/Downloads/SHOPLINE_encrypt6.zip.pgp")),
                new FileOutputStream(new File("/Users/tianwei/Downloads/SHOPLINE_decrypt7.zip")),
                new FileInputStream(new File("/Users/tianwei/Project/souche-base/springbootdemo/src/main/java/com/common/util/crypt/pgp/SHOPLINE_TEST_secretKey.asc")),
                "Joyy1026.".toCharArray());
    }

}
