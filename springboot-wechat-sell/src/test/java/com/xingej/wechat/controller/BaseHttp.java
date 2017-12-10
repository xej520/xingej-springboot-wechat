package com.xingej.wechat.controller;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public abstract class BaseHttp {
    protected CloseableHttpClient httpClient = HttpClients.createDefault();

    protected abstract HttpPost getHttpPost(String url);

    protected abstract HttpGet getHttpGet(String url);
}
