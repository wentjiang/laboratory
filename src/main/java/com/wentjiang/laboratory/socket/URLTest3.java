package com.wentjiang.laboratory.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by wentj on 2017/2/19.
 */
public class URLTest3 {
    public static void main(String[] args) {
        try {
            URL baiduUrl = new URL("http://www.baidu.com");
            InputStream inputStream = baiduUrl.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data != null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
