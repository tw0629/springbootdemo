package com.common;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5 {
    
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	
	
	
	/**
     * 
     * @Title: md5Encryption   
     * @Description: (MD5加密 param + key 进行加密)   
     * @param params
     * @param udapi_sign
     * @return String    返回类型   
     * @throws
     */
    public static String md5Encryption(String params, String udapi_sign) {

        String key = Base64.encodeBase64String(MD5bytes(params + udapi_sign, "UTF-8"));

        return key;
    }
    
    /**
     * 
     * @Title: md5Encryption16   
     * @Description: (这里用一句话描述这个方法的作用)   
     * @param params
     * @param udapi_sign
     * @return String    返回类型   
     * @throws
     */
    public static String md5Encryption16(String params, String udapi_sign){
        
        String key = byteToString(MD5bytes(params + udapi_sign, "UTF-8"));
        
        return key;
    }
    
    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    
    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
    
    
    
    /**
     * 
     * @Title: MD5bytes   
     * @Description: (MD5加密依赖)   
     * @param context
     * @param charset
     * @return byte[]    返回类型   
     * @throws
     */
    private static byte[] MD5bytes(String context, String charset) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(context.getBytes(charset));
            byte[] arrByte = messageDigest.digest();
            return arrByte;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
	
	public static void main(String[] args) {
		System.out.println(md5("31119@qq.com"+"123456"));
		System.out.println(md5("mj1"));
	}
}
