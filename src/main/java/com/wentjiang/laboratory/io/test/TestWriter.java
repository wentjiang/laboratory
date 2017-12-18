package com.wentjiang.laboratory.io.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author jiangwentao
 * @create 2017-11-13 10:26
 * @desc
 **/
public class TestWriter {
    public static void main(String[] args) {
        String text = "hahahahhaha";
        File file = new File("D:\\self-work\\laboratory\\src\\main\\java\\com\\wentjiang\\laboratory\\io\\testWriter.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Writer writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
