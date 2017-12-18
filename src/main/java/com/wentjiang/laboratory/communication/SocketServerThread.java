package com.wentjiang.laboratory.communication;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author jiangwentao
 * @create 2017-11-17 14:22
 * @desc
 **/
@Slf4j
public class SocketServerThread implements Runnable {

    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        Integer sourcePort = socket.getPort();
        int maxLen = 1024;
        byte[] contextBytes = new byte[maxLen];
        int realLen;
        String message = "";
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            //这里也会被阻塞，直到有数据准备好
            realLen = in.read(contextBytes, 0, maxLen);
            //读取信息
            message += new String(contextBytes , 0 , realLen);

            log.info("服务端收到来自端口: " + sourcePort + " 的消息 :" + message);
            out.write("返回响应消息!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
