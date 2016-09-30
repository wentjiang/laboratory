package com.wentjiang.laboratory.sign;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jiangwentao on 9/30/2016.
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        StringBuilder response = new StringBuilder();
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod("http://www.sina.com");
        httpClient.executeMethod(method);
        System.out.println(method.getStatusCode());
        if (method.getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(),
                    "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
        }
        System.out.println(response.toString());
        System.out.println(111);
    }
}
