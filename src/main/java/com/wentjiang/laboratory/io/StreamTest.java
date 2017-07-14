package com.wentjiang.laboratory.io;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by jiangwentao on 2017/6/22 11:20.
 */
public class StreamTest {

    public static void main(String[] args) {
//        readTxt();
//        writeTxt();
//        copyJpeg();
        fileProperties();
    }


    //文件读取
    public static void readTxt() {
        String filePath = "d://tmp//laboratory//read.txt";
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(isr);
                String line = null;
                while (StringUtils.isNotEmpty(line = bufferedReader.readLine())) {
                    System.out.println(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //文件写入
    public static void writeTxt() {
        String filePath = "write.txt";

        String line1 = "line1 第一行";
        String line2 = "line2 第二行";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            file.mkdirs();
        }
        try {
            Writer writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(line1 + "\n");
            bufferedWriter.write(line2);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //读取图片
    public static void copyJpeg() {
        File inFile = new File("picture.jpeg");
        File outFile = new File("outputPicture.jpeg");

        if (!outFile.exists()) {
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //读取文件输入
            inputStream = new FileInputStream(inFile);
            int n = 512;
            byte[] buffer = new byte[n];

            //输出
            outputStream = new FileOutputStream(outFile);

            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileProperties() {
        File file = new File("picture.jpeg");
        System.out.println(file.getPath());
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
