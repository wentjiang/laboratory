package com.wentjiang.laboratory.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by wentj on 2017/2/19.
 */
public class Client {
    public static final String IP_ADDR = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args){
        System.out.println("客户端启动..");
        System.out.println("接收到服务器端OK时,客户端将终止");
        while (true){
            Socket socket = null;
            try {
                //创建一个流量套接字并将其连接到指定主机上的指定端口
                socket = new Socket(IP_ADDR,PORT);

                //读取服务器端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                System.out.println("请输入:");;
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                output.writeUTF(str);

                String ret = input.readUTF();
                System.out.println("服务器端返回结果是:" + ret);
                //如果收到"ok"则断开连接
                if ("OK".equals(ret)){
                    System.out.println("客户端将关闭连接");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        break;
                    }
                }
                output.close();
                input.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if (socket != null ){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
