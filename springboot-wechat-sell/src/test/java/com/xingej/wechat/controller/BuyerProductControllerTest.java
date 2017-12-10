package com.xingej.wechat.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class BuyerProductControllerTest extends BaseHttp {

    private String baseURL = "http://localhost:8089/wechat/buyer/product";

    private HttpPost post;

    private HttpGet get;

    String url = null;
    String clusterName = "";

    @Override
    protected HttpPost getHttpPost(String url) {
        post = new HttpPost(url);

        post.setHeader("Content-Type", "application/json;charset=UTF-8");

        return post;
    }

    @Override
    protected HttpGet getHttpGet(String url) {

        get = new HttpGet(url);

        get.setHeader("Content-Type", "application/json;charset=UTF-8");

        return get;
    }

    @Test
    public void testGetList() throws Exception {
        String url = baseURL + "/list";

        get = getHttpGet(url);

        CloseableHttpResponse response = httpClient.execute(get);

        HttpEntity entity = response.getEntity();

        String result = EntityUtils.toString(entity);

        System.out.println("----get----:\t" + result);

    }

}
