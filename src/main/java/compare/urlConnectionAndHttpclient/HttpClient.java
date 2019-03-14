/*
package compare.urlConnectionAndHttpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class HttpClient {

    String urlAddress = "http://192.168.1.102:8080/qualityserver/login.do";

//    public HttpClientServer(){
//
//    }

    public String doGet(String username,String password){
        String getUrl = urlAddress + "?username="+username+"&password="+password;
        HttpGet httpGet = new HttpGet(getUrl);
        HttpParams hp = httpGet.getParams();
        hp.getParameter("true");
//hp.
//httpGet.setp
        HttpClient hc = new DefaultHttpClient();
        try {
            HttpResponse ht = hc.execute(httpGet);
            if(ht.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity he = ht.getEntity();
                InputStream is = he.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String response = "";
                String readLine = null;
                while((readLine =br.readLine()) != null){
//response = br.readLine();
                    response = response + readLine;
                }
                is.close();
                br.close();

//String str = EntityUtils.toString(he);
                System.out.println("========="+response);
                return response;
            }else{
                return "error";
            }
        } catch (ClientProtocolException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        }
    }

    public String doPost(String username,String password){
//String getUrl = urlAddress + "?username="+username+"&password="+password;
        HttpPost httpPost = new HttpPost(urlAddress);
        List params = new ArrayList();
        NameValuePair pair1 = new BasicNameValuePair("username", username);
        NameValuePair pair2 = new BasicNameValuePair("password", password);
        params.add(pair1);
        params.add(pair2);

        HttpEntity he;
        try {
            he = new UrlEncodedFormEntity(params, "gbk");
            httpPost.setEntity(he);

        } catch (UnsupportedEncodingException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }

        HttpClient hc = new DefaultHttpClient();
        try {
            HttpResponse ht = hc.execute(httpPost);
//连接成功
            if(ht.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity het = ht.getEntity();
                InputStream is = het.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String response = "";
                String readLine = null;
                while((readLine =br.readLine()) != null){
//response = br.readLine();
                    response = response + readLine;
                }
                is.close();
                br.close();

//String str = EntityUtils.toString(he);
                System.out.println("=========&&"+response);
                return response;
            }else{
                return "error";
            }
        } catch (ClientProtocolException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            return "exception";
        }
    }
}
*/
