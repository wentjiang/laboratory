package com.wentjiang.laboratory.communication;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * @author jiangwentao
 * @create 2017-11-17 12:28
 * @desc
 **/
@Slf4j
public class SocketClientRequestThread implements Runnable {

    private CountDownLatch countDownLatch;

    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    @Override
    public void run() {
        Socket socket = null;
        OutputStream clientRequest = null;
        InputStream clientResponse = null;
        try {
            socket = new Socket("localhost", 81);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();

            this.countDownLatch.await();
            clientRequest.write(("这是第" + clientIndex + " 个客户端的请求.").getBytes());
            clientRequest.flush();

            log.info("第 " + clientIndex + " 个客户端的请求发送完成,等待服务端响应");
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int realLen;
            String message = "";
            //程序执行到这里，会一直等待服务器返回信息（注意，前提是in和out都不能close，如果close了就收不到服务器的反馈了）
            while((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                message += new String(contextBytes , 0 , realLen);
            }
            log.info("收到来自服务端的消息: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (clientRequest != null) {
                try {
                    clientRequest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientResponse != null) {
                try {
                    clientResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
