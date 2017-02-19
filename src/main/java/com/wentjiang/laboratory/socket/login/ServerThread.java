package com.wentjiang.laboratory.socket.login;

import java.io.*;
import java.net.Socket;

/**
 * Created by wentj on 2017/2/19.
 */
public class ServerThread extends Thread {
    //和本线程相关的socket
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("start new thread to deal request");
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream outputStream = null;
        PrintWriter pw = null;
        try {
            //获取输入流,读取客户端信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("客户端说:" + info);

            }
            socket.shutdownInput();//关闭输入流

            outputStream = socket.getOutputStream();
            pw = new PrintWriter(outputStream);
            pw.write("欢迎您");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null){
                    pw.flush();
                }
                outputStream.close();
                pw.close();
                br.close();
                isr.close();
                is.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
