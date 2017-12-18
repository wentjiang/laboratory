package com.wentjiang.laboratory.opendata.support;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by jiangwentao on 2017/8/21 12:23.
 */
public class HttpClientBuilder {

    private static HttpClientBuilder builder = new HttpClientBuilder();

    private HttpClientBuilder(){
    }

    public HttpClient getClient() {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(new BasicCookieStore()).build();
        return httpClient;
    }

    public static HttpClientBuilder getBuilder(){
        return builder;
    }



}
