package com.wentjiang.laboratory.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by wentj on 2017/2/19.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //发送数据
        InetAddress inetAddress =  InetAddress.getByName("localhost");
        int port = 8800;
        String data = "jiagnwnetao";
        DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(),data.getBytes().length,inetAddress,port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);

        //接受服务器数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,inetAddress,port);
        datagramSocket.receive(packet2);
        String reply = new String(data2,0,packet2.getLength());
        System.out.println(reply);
    }

}
