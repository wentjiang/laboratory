package com.wentjiang.laboratory.io.test;

import java.io.*;

/**
 * @author jiangwentao
 * @create 2017-11-13 10:49
 * @desc
 **/
public class TestInputStream {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        File file = new File("D:\\self-work\\laboratory\\src\\main\\java\\com\\wentjiang\\laboratory\\io\\test.txt");
        StringBuilder content = new StringBuilder();
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] buffer = new byte[8];
            while (is.read(buffer)!= -1){
                content.append(new String(buffer));
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("close time :" + (endTime - startTime));
    }
}
