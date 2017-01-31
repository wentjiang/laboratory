package com.wentjiang.laboratory.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wentj on 2017/1/31.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName = inetAddress.getHostName();
        System.out.println(hostName);
    }
}
