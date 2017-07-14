package com.wentjiang.laboratory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jiangwentao on 2017/6/21 17:43.
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("classpath:dbcp.properties");
            properties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
