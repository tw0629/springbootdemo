package com.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


/**
 * 
 *     
 * 项目名称：ycapp-core    
 * 类名称：DigestCheck    
 * 类描述：    签名校验
 * 创建人：mengzw    
 * 创建时间：2016年10月26日 下午4:23:02    
 * 修改人：mengzw    
 * 修改时间：2016年10月26日 下午4:23:02    
 * 修改备注：    
 * @version     
 *
 */
public class DigestCheck {
    
    /**
     * 
     * @Title: getCheckResult   
     * @Description: (验证加密)   
     * @param params
     * @param appKey
     * @param timestamp
     * @param digest
     * @return boolean    返回类型   
     * @throws
     */
    public static boolean getCheckResult(String params,String appKey,String timestamp,String digest){
        boolean flag = false;
        
        String digestValue = getDigest(params + appKey + timestamp);
        
        if(StringUtils.isNotEmpty(digestValue) && digestValue.equals(digest)){
            flag = true;
        }
                
        
  
        return flag;
    }
    
    /**
     * 
     * @Title: getCheckResult   
     * @Description: (验证加密)   
     * @param params
     * @param appKey
     * @param timestamp
     * @param digest
     * @return boolean    返回类型   
     * @throws
     */
    public static boolean getCheckResult(String params,String appKey,String secret,String timestamp,String digest){
        boolean flag = false;
        
        String digestValue = getDigest(params + appKey + secret);
        
        if(StringUtils.isNotEmpty(digestValue) && digestValue.equals(digest)){
            flag = true;
        }
                
        
  
        return flag;
    }
    
    /**
     * 
     * @Title: getDigest   
     * @Description: (获取MD5加密证书)   
     * @param srcString
     * @return String    返回类型   
     * @throws
     */
    public static String getDigest(String srcString){
        return Base64.encodeBase64String(DigestUtils.md5Hex(srcString).getBytes());
    }
    
    /**
	 * 
	   
	 * digestStringImgUtil 根据图片生成对应的名称   
	   
	 * TODO(这里描述这个方法适用条件 – 可选)    
	   
	 * @param   idenimagFilename 图片名称    
	   
	 * @return String    DOM对象    
	   
	 * @Exception 异常对象    
	   
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String digestStringImgUtil(String idenimagFilename) {
		//获得时间戳
		if(idenimagFilename != null){
			long time = new Date().getTime(); 
			
			String[] split = idenimagFilename.split("\\.");
			String suffix = split[split.length-1];
			//加密后的结果
//			String digest = DigestCheck.getDigest(idenimagFilename+ time);
			String md5 = MD5.md5(idenimagFilename+ time);
			
			return md5+"."+suffix;
			
		}
		return null;
	}
	
	public static void main(String[] args) {
	    /*String params = "{\"billCode\":\"1234567890\",\"terminalNo\":\"MPNF809D3669609\",\"user\":{\"empCode\":\"44249\",\"empName\":\"徐志文\",\"siteCode\":\"021I01\",\"siteName\":\"上海01\"}}";
	    boolean flag = getCheckResult(params, "PDA_DONGDA", "1506401545175", "NThmNTY0NzAyY2RlY2I2NWM2MGRhYTIxYzJjN2Y5Zjc=");
	    System.out.println(flag);*/
		System.out.println(getDigest("17621503799"+"123456"));

		System.out.println("ZDZkMTk2MzQ1ODZmNDI1NDJkYzAyZTA3MDI3Mzc2Mzk=".equals("ZDZkMTk2MzQ1ODZmNDI1NDJkYzAyZTA3MDI3Mzc2Mzk="));


	}

}
