package com.wentjiang.laboratory.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wentj on 2017/2/18.
 */
public class Server {
    public static final int PORT = 12345;//监听端口号

    public static void main(String[] args) {
        System.out.println("服务器启动...");
        Server server = new Server();
        server.init();
    }

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                Socket client = serverSocket.accept();

                new HandlerThread(client);
            }
        } catch (IOException e) {
            System.out.println("服务器异常");
            e.printStackTrace();
        }
    }

    private class HandlerThread implements Runnable{
        private Socket socket;
        public HandlerThread(Socket client){
            this.socket = client;
            new Thread(this).start();
        }
        @Override
        public void run() {

            try {
                //读取客户端数据
                DataInputStream input = new DataInputStream(socket.getInputStream()) ;
                String clientInputStr = input.readUTF();
                //处理客户端数据
                System.out.println("客户端发送的内容:" + clientInputStr);

                //向客户端回复信息
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("请输入:\t");
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.writeUTF(str);

                out.close();
                input.close();
            } catch (IOException e) {
                System.out.println("服务器运行异常:");
                e.printStackTrace();
            }finally {
                if (socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("服务器finally异常");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
