package com.wentjiang.laboratory.opendata.support;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by jiangwentao on 2017/8/21 14:07.
 */
public class HttpUtil {

    public static String getCookie(HttpClientContext context, String cookieName) {
        List<Cookie> cookies = context.getCookieStore().getCookies();
        String result = null;
        if (CollectionUtils.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    result = cookie.getValue();
                }
            }
        }
        return result;
    }

    public static void addHttpHeads(HttpRequestBase requestBase, String referer, boolean ajax) {
        requestBase.addHeader("Host", "steamcommunity.com");
        requestBase.addHeader("Connection", "keep-alive");
        requestBase.addHeader("Pragma", "no-cache");
        requestBase.addHeader("Cache-Control", "no-cache");
        requestBase.addHeader("Accept", "*/*");
        requestBase.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
        requestBase.addHeader("Referer", "http://steamcommunity.com/search/users");
        requestBase.addHeader("Accept-Encoding", "gzip, deflate");
        requestBase.addHeader("Accept-Language", "zh-CN,zh;q=0.8");

        if (referer != null) {
            requestBase.addHeader("Referer", referer);
        }
        if (ajax) {
            requestBase.addHeader("X-Prototype-Version", "1.7");
            requestBase.addHeader("X-Requested-With", "XMLHttpRequest");
        }
    }

    public static String getResponseContent(HttpResponse response) {
        StringBuilder resultContent = new StringBuilder();
        InputStream is = null;
        try {
            is = response.getEntity().getContent();
            InputStreamReader isr = new InputStreamReader(is);
            char[] buffer = new char[256];
            while (isr.read(buffer, 0, 256) != -1) {
                resultContent.append(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultContent.toString();
//        System.out.println(resultContent);
    }
}
