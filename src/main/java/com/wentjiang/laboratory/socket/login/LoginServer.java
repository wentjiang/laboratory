package com.wentjiang.laboratory.socket.login;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用户登录服务器端
 * Created by wentj on 2017/2/19.
 */
public class LoginServer {
    public static void main(String[] args) {
        try {
            //创建服务器端socket
            ServerSocket serverSocket = new ServerSocket(8888);
            //调用accept方法,等待连接
            System.out.println("****服务器即将启动,等待客户端连接");
            int count = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
                count++;
                System.out.println("当前已经处理请求数量:" + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println(inetAddress.getHostAddress());
            }
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
