package com.wentjiang.laboratory.socket.login;

import java.io.*;
import java.net.Socket;

/**
 * Created by wentj on 2017/2/19.
 */
public class LoginClient {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                //创建socket,指定服务器端口地址
                Socket socket = new Socket("localhost", 8888);

                System.out.println("start send message to server");
                //获取输出流,向服务器发送信息
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);
                pw.write("用户名: admin; 密码:1234");
                System.out.println("send message end");
                pw.flush();
                socket.shutdownOutput();

                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String message = null;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);
                }

                socket.shutdownInput();

                br.close();
                isr.close();
                is.close();

                pw.close();
                os.close();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
