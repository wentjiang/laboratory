package com.wentjiang.laboratory.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wentj on 2017/1/31.
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL imooc = new URL("http:www.imooc.com");
            URL url = new URL(imooc, "/index.html?username=tom#test");
            System.out.println("协议:" + url.getProtocol());
            System.out.println("主机:" + url.getHost());
            //如果未指定端口号,则使用默认端口号,此时getprot/)返回值未-1
            System.out.println("端口:" + url.getPort());
            System.out.println("文件路径:" + url.getPath());
            System.out.println("文件名:" + url.getFile());
            System.out.println("相对路径" + url.getRef());
            System.out.println("查询路径" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
