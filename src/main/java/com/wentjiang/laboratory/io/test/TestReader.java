package com.wentjiang.laboratory.io.test;

import java.io.*;

/**
 * @author jiangwentao
 * @create 2017-11-13 10:16
 * @desc
 **/
public class TestReader {
    public static void main(String[] args) {
        File file = new File("D:\\self-work\\laboratory\\src\\main\\java\\com\\wentjiang\\laboratory\\io\\test.txt");
        Long startTime = System.currentTimeMillis();
        Reader reader = null;
        try {
            StringBuffer sb = new StringBuffer();
            reader = new FileReader(file);
            char[] buffer = new char[1];
            while (reader.read(buffer) != -1) {
                sb.append(buffer);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("close time :" + (endTime - startTime));

    }
}
