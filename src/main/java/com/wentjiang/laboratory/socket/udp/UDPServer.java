package com.wentjiang.laboratory.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by wentj on 2017/2/19.
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8800);
            byte[] data = new byte[1024];

            DatagramPacket packet = new DatagramPacket(data,data.length);
            socket.receive(packet);
            String info  = new String(data,0,packet.getLength());
            System.out.println("客户端发送了:"+ info);

            InetAddress inetAddress = packet.getAddress();
            int port = packet.getPort();
            String result = "欢迎您";
            DatagramPacket datagramPacket2 = new DatagramPacket(result.getBytes(),result.getBytes().length,inetAddress,port);
            socket.send(datagramPacket2);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
