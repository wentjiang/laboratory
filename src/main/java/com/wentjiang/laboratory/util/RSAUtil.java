package com.wentjiang.laboratory.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangwentao on 2017/6/13 18:11.
 */
public class RSAUtil {


    public static Map<String, byte[]> generateKeyBytes() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            Map<String, byte[]> keyMap = new HashMap<>();

            keyMap.put("privateKey", privateKey.getEncoded());
            keyMap.put("publicKey", publicKey.getEncoded());

            return keyMap;


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, byte[]> map = generateKeyBytes();
        byte[] priveteKey = map.get("privateKey");
        byte[] publicKey = map.get("publicKey");
        String privateKeystr = Base64Util.getBase64(priveteKey.toString());
        System.out.println(privateKeystr);
        System.out.println(Base64Util.getBase64(publicKey.toString()));

    }
}
