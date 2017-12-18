package com.wentjiang.laboratory.io.test;

import java.io.*;

/**
 * @author jiangwentao
 * @create 2017-11-13 11:08
 * @desc
 **/
public class TestOutputStream {
    public static void main(String[] args) {
        String content = "D:\\self-work\\laboratory\\src\\main\\java\\com\\wentjiang\\laboratory\\io\\testOutputStream.txt";
        File file = new File("D:\\self-work\\laboratory\\src\\main\\java\\com\\wentjiang\\laboratory\\io\\testOutputStream.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
