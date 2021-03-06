package compare.urlConnectionAndHttpclient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpUrlConnection {

    String urlAddress = "http://192.168.1.102:8080/AndroidServer/login.do";
    URL url;
    HttpURLConnection uRLConnection;

//    public UrlConnectionToServer(){
//
//    }

    //向服务器发送get请求
    public String doGet(String username, String password) {
        String getUrl = urlAddress + "?username=" + username + "&password=" + password;
        try {
            url = new URL(getUrl);
            uRLConnection = (HttpURLConnection) url.openConnection();
            InputStream is = uRLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String response = "";
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
//response = br.readLine();
                response = response + readLine;
            }
            is.close();
            br.close();
            uRLConnection.disconnect();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //向服务器发送post请求
    public String doPost(String username, String password) {
        try {
            url = new URL(urlAddress);
            uRLConnection = (HttpURLConnection) url.openConnection();
            uRLConnection.setDoInput(true);
            uRLConnection.setDoOutput(true);
            uRLConnection.setRequestMethod("POST");
            uRLConnection.setUseCaches(false);
            uRLConnection.setInstanceFollowRedirects(false);
            uRLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uRLConnection.connect();

            DataOutputStream out = new DataOutputStream(uRLConnection.getOutputStream());
            String content = "username=" + username + "&password=" + password;
            out.writeBytes(content);
            out.flush();
            out.close();

            InputStream is = uRLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String response = "";
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
//response = br.readLine();
                response = response + readLine;
            }
            is.close();
            br.close();
            uRLConnection.disconnect();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
