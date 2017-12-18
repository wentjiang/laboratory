package com.wentjiang.laboratory.socket.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * Created by jiangwentao on 2017/8/15 10:52.
 */
public class ServerSocketTest {

    public static void main(String[] args) {

    }

    public static ServerSocket getServerSocket(String host) {
        ServerSocket serverSocket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            serverSocket = new ServerSocket(8080,1,inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket;
    }
}
