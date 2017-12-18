package com.wentjiang.laboratory.communication;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangwentao
 * @create 2017-11-17 14:20
 * @desc
 **/
@Slf4j
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("server").build());
        try (ServerSocket serverSocket = new ServerSocket(81)) {
            while (true) {
                Socket socket = null;
                socket = serverSocket.accept();
                SocketServerThread socketServerThread = new SocketServerThread(socket);
                poolExecutor.execute(socketServerThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
