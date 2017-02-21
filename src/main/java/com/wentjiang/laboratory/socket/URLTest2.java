package com.wentjiang.laboratory.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wentj on 2017/1/31.
 * 使用url读取网页内容
 */
public class URLTest2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            //通过url的opensteam获取url对象所表示的资源的字节输入流
            InputStream is = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();//读取数据
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
