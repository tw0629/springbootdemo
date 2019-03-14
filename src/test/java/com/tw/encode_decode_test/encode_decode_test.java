package com.tw.encode_decode_test;

import com.common.DigestCheck;
import org.junit.Test;

import java.security.MessageDigest;

public class encode_decode_test {

    @Test
    public  void test(){

//        String params = "{\"workerCode\":\"28856\"}";
//        String params = "{\"approveStatus\":\"\",\"endDate\":\"20180630\",\"pageIndex\":0,\"pageSize\":10,\"startDate\":\"20180601\"}\n";
//        String params = "{\"workerCode\":\"28856\",\"woekerName\":\"程于清\",\"punchAddress\":\"上海市普陀区水厂路远成快运大门口\",\"punchLongitude\":\"121.363512\",\"punchLatitude\":\"31.274241\",\"type\":\"1\"}";
//        String params = "{\"workerCode\":\"28856\",\"woekerName\":\"程于清\",\"punchAddress\":\"上海市普陀区水厂路李家浜桥\",\"punchLongitude\":\"121.363314\",\"punchLatitude\":\"31.274237\",\"type\":\"2\"}";
//        String params = "{\"workerCode\":\"28856\",\"woekerName\":\"程于清\",\"punchAddress\":\"上海市哈哈哈\",\"punchLongitude\":\"101.363314\",\"punchLatitude\":\"21.274237\",\"type\":\"2\"}";
        String params = "{\"workerCode\":\"156022\",\"woekerName\":\"田伟\",\"punchAddress\":\"上海市哈哈哈\",\"punchLongitude\":\"101.363314\",\"punchLatitude\":\"21.274237\",\"type\":\"2\"}";

        String timestamp = "1530154937741";
        String appkey = "ycapp";
        String digest = "";

/*        boolean flag = DigestCheck.getCheckResult(requestModel.getParams(), requestModel.getAppkey(),
                requestModel.getTimestamp(), requestModel.getDigest());*/

        digest = DigestCheck.getDigest(params + appkey + timestamp);
        System.out.println("===========> "+ digest);


        //NDBiYTIwOTkzNzk3YmE0MmIyYjQ5YzNmZTFhOGI4ZTg=
        //1
        //MTdkNjRjNGIxMWFhMzhhZDU0OWJiOGE1YzE0ZTYxMzk=
        //2
        //MDBjYzYzZjY1NDcwZDk3OTZkMDM2NGQwMjNkMGNlMTA=

    }

    @Test
    public void test2(){

        // 加密  下面就是自定义的加密算法

        // 这个加密算法只有  前端和后端两端知道，是约定好的
        // 防止参数传输过程中找到串改
        //    前端穿的的是“tianwei”和它加密后的sign
        //同理后端接收到参数后,也要进行将参数“tianwei”加密验证得到sign2, 看sign是否等于sign


        String passwordMD5 = null;
        try {
             MessageDigest md5 = MessageDigest.getInstance("MD5");
             byte[] byteArray = new byte[0];
             byteArray = md5.digest("tianwei".getBytes("utf-8"));
             System.out.println("========> "+ "tianwei".getBytes("utf-8"));
             System.out.println("========> "+ byteArray);
             passwordMD5 = byteArrayToHexString(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========> "+ passwordMD5);
        String sign = passwordMD5.toUpperCase();
        System.out.println("========> "+ sign);
        System.out.println("                        ");


    }
    private static final String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    private static String byteArrayToHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        for (byte b : byteArray) {
            sb.append(byteToHexChar(b));
        }
        return sb.toString();
    }
    private static Object byteToHexChar(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hex[d1] + hex[d2];
    }

}
