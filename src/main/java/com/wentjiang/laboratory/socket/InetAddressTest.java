package com.wentjiang.laboratory.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

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
        String hostAddress = inetAddress.getHostAddress();
        byte[] bytes = inetAddress.getAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
        System.out.println(Arrays.toString(bytes));
        System.out.println(inetAddress);
    }
}
