package com.common.HttpclientUtil;

import com.common.SecurityUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpClientUtils {

    private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();


    private static final int TIMEOUT = 5 * 1000;//5 * 1000

    private static final int MAX_HTTP_CONNECTION = 50;


    private static final int MAX_CONNECTION_PER_HOST = 10;// 10

    private static final String CHARSET_UTF8 = "UTF-8";

    private String KEY = "ycapp";

    private String SECRET_KEY = "23ra12dfasde31dd";


    private static HttpClientUtils instance = null;

    private static Logger logger = Logger.getLogger(HttpClientUtils.class);

    static {

        //HttpClient 连接池属性设置，HOST并发数默认为50, 客户端�?并发数为200, TimeOut时间�?s.

        HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();

        // 文档参数说明：Sets the maximum number of connections allowed.
        httpConnectionManagerParams.setMaxTotalConnections(MAX_HTTP_CONNECTION);

        // 文档参数说明�?Sets the default maximum number of connections allowed for a given host config.
        httpConnectionManagerParams.setDefaultMaxConnectionsPerHost(MAX_CONNECTION_PER_HOST);

        // 读取数据超时时间
        httpConnectionManagerParams.setSoTimeout(TIMEOUT);

        // 连接超时时间
        httpConnectionManagerParams.setConnectionTimeout(TIMEOUT);

        connectionManager.setParams(httpConnectionManagerParams);

    }


    public HttpClientUtils() {

    }

    public static HttpClientUtils getInstance() {

        if (null == instance) {

            synchronized (HttpClientUtils.class) {

                if (instance == null) {

                    instance = new HttpClientUtils();

                }

            }

        }

        return instance;

    }

    public HttpClient createHttpClient() {

        HttpClient httpClient = new HttpClient(connectionManager);

        return httpClient;

    }

    /*
     * 进行 http请求返回String结果
     *
     * @param url
     * @return
     */


    public String getHttpClientJson(String url) {

        HttpClient httpClient = createHttpClient();

        GetMethod getMethod = new GetMethod(url);

        try {

            httpClient.executeMethod(getMethod);

            InputStreamReader in = new InputStreamReader(getMethod.getResponseBodyAsStream(),
                    HttpClientUtils.CHARSET_UTF8);
            //            String jsonString = getMethod.getResponseBodyAsString();
            String jsonString = getStringByParams(in);

            return jsonString;

        } catch (Exception e) {
            logger.error("Http Client GetMethod Execute is Exception , Message = " + e.getMessage(), e);
            return "{\"reason\":\"获取信息失败！\",\"resultCode\":9999,\"resultInfo\":{\"data\":\"\"}}";
        } finally {
            if (getMethod != null)
                getMethod.releaseConnection();

        }

    }

    /*
     * 进行 http post请求返回String结果,仅限FO接口使用，因为牵扯到key和秘钥
     *
     * @param url
     * @return
     */


    public String postHttpClientJson(String url, String params) {

        HttpClient httpClient = createHttpClient();

        PostMethod postMethod = null;

        try {
            postMethod = getPostMethod(url, params);
            logger.info(" Request Url is : " + url);

            httpClient.executeMethod(postMethod);
            //            String jsonString = postMethod.getResponseBodyAsString();
            InputStreamReader in = new InputStreamReader(postMethod.getResponseBodyAsStream(),
                    HttpClientUtils.CHARSET_UTF8);
            String jsonString = getStringByParams(in);

            return jsonString;

        } catch (Exception e) {
            logger.error("Http Client PostMethod Execute is Exception , Message = " + e.getMessage(), e);
            return "{\"reason\":\"获取信息失败！\",\"resultCode\":9999,\"resultInfo\":{\"data\":\"\"}}";
        } finally {
            if (postMethod != null)
                postMethod.releaseConnection();

        }

    }

    /*
     * @param params
     * @return List<NameValuePair>    返回类型
     * @throws
     * @Title: getCheckParam
     * @Description: (设置验证参数)
     */

    private List<NameValuePair> getCheckParam(String params) {
        String digest = SecurityUtil.getDigest(params + KEY + SECRET_KEY);
        String timestamp = "" + new Date().getTime();
        final List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
        // 接口调用的请求格式
        nameValueList.add(new NameValuePair("params", params));

        nameValueList.add(new NameValuePair("digest", digest));
        nameValueList.add(new NameValuePair("timestamp", timestamp));
        nameValueList.add(new NameValuePair("appkey", KEY));

        return nameValueList;

    }

    /*
     * @param url
     * @param params
     * @return PostMethod    返回类型
     * @throws
     * @Title: getPostMethod
     * @Description: (设置params参数)
     */

    private PostMethod getPostMethod(String url, String params) {
        PostMethod postMethod = new PostMethod(url);

        List<NameValuePair> nameValueList = getCheckParam(params);

        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        postMethod.setRequestBody(nameValueList.toArray(new NameValuePair[nameValueList.size()]));
        //        postMethod.addRequestHeader("Connection", "close");

        return postMethod;

    }


    public String getParams(String orderid, String address, String key, String secretKey) {

        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append("\"id\":\"" + orderid + "\",");
        str.append("\"address\":\"" + address + "\"");
        str.append("}");

        this.KEY = key;
        this.SECRET_KEY = secretKey;

        return str.toString();
    }

    /*
     * @param in
     * @return String    返回类型
     * @throws IOException
     * @throws
     * @Title: getStringByParams
     * @Description: (将流文件转换成字)
     */

    private String getStringByParams(InputStreamReader in) throws IOException {

        BufferedReader reader = new BufferedReader(in);

        StringBuffer stringBuffer = new StringBuffer();

        String str = "";

        while ((str = reader.readLine()) != null) {

            stringBuffer.append(str);

        }

        String ts = stringBuffer.toString();

        return ts;
    }


    public static void main(String[] args) {
        HttpClientUtils hcu = HttpClientUtils.getInstance();
        String params = "{\"billCode\":\"201712061002\"}";
        String url = "http://172.16.36.14:8080/rosefinch-web/fosp/api/getCodInfoByBillCode.api";
        String result = hcu.postHttpClientJson(url, params);
        System.out.println(result);
    }

}
