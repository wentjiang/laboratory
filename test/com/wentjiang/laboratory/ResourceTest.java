package com.wentjiang.laboratory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wentj on 2017/2/18.
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("config.properties");
        InputStream inputStream = resource.getInputStream();

    }
}
