package com.example.studentmanage;

import android.util.Log;

import java.io.IOException;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;

public class HttpClientUtil {
    private static final String TAG = "HttpClientUtil";
    //
    private static HttpClient instance = null;
    //默认服务端信息

    public static String IP = "192.168.43.101";
    public static String PORT = "8088";
    private static String PROJECT = "DataBaseWeb";
    private static String BASE_URL = "http://" + IP + ":" + PORT + "/" + PROJECT + "/";

    public static HttpClient getInstance() {
        if (instance == null) {
            instance = HttpClientBuilder.create().build();
        }
        return instance;
    }

    /**
     * 更新服务端信息
     *
     * @param address
     * @param port
     */
    public static void refreshHost(String address, String port) {
        IP = address;
        PORT = port;
        BASE_URL = "http://" + IP + ":" + PORT + "/" + PROJECT + "/";
    }

    /**
     * 向服务端请求消息
     *
     * @param sendMsg 发送的数据
     * @param action  请求方式
     * @return 封装后的实体类
     */
    public static String request(String sendMsg, String action) {
        HttpClient httpClient = getInstance();
        HttpPost post = null;
        try {
            post = new HttpPost(BASE_URL + action);
            StringEntity entity = new StringEntity(sendMsg, "UTF-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType(ContentType.APPLICATION_JSON.toString());
            post.setEntity(entity);
            HttpEntity httpEntity = httpClient.execute(post).getEntity();

            String receMsg = EntityUtils.toString(httpEntity, Consts.UTF_8);
            Log.d(TAG, "request: --->接受的数据：" + receMsg);
            return receMsg;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return null;
    }


}
