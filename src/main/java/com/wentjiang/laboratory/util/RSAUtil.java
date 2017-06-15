package com.wentjiang.laboratory.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    private static final Logger log = LoggerFactory
            .getLogger(RSAUtil.class);
    private static final int step_enc = 117;
    private static final int step_dec = 128;

    private PublicKey keyPub;
    private PrivateKey keyPri;

    private PublicKey getKeyPub() {
        return keyPub;
    }

    private PrivateKey getKeyPri() {
        return keyPri;
    }

    public RSAUtil(final String priKey, final String pubKey) throws GeneralSecurityException {

        final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        if (priKey != null) {
            final PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKey.getBytes()));
            keyPri = keyFactory.generatePrivate(priKeySpec);
        }
        if (pubKey != null) {
            final X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKey.getBytes()));
            keyPub = keyFactory.generatePublic(pubKeySpec);
        }
    }

    /**
     * 私钥加密<br>
     * 加密的时候超过117会报错，所以采用117一循环的方式<br>
     * 其实这不是一个很好的解决办法，因为RSA算法本来就比较慢，而且运用这个算法的初衷是传输很少的数据
     *
     * @param data 数据源
     * @return
     * @throws Exception
     */
    public byte[] encryptByPrivateKey(final byte[] data) throws GeneralSecurityException, IOException {
        final PrivateKey privateKey = getKeyPri();
        final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return doFinal(cipher, data, step_enc);
    }

    /**
     * 私钥解密
     * 解密的时候超过128会报错，所以采用128一循环的方式<br>
     * 其实这不是一个很好的解决办法，因为RSA算法本来就比较慢，而且运用这个算法的初衷是传输很少的数据
     *
     * @param data 数据源
     * @return
     * @throws Exception
     */
    public byte[] decryptByPrivateKey(final byte[] data) throws Exception {
        final PrivateKey privateKey = getKeyPri();
        final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return doFinal(cipher, data, step_dec);

    }

    /**
     * 公钥加密
     * 加密的时候超过117会报错，所以采用117一循环的方式<br>
     * 其实这不是一个很好的解决办法，因为RSA算法本来就比较慢，而且运用这个算法的初衷是传输很少的数据
     *
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] encryptByPublicKey(final byte[] data) throws Exception {
        final PublicKey publicKey = getKeyPub();
        final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return doFinal(cipher, data, step_enc);
    }

    /**
     * 公钥解密
     * 解密的时候超过128会报错，所以采用128一循环的方式<br>
     * 其实这不是一个很好的解决办法，因为RSA算法本来就比较慢，而且运用这个算法的初衷是传输很少的数据
     *
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] decryptByPublicKey(final byte[] data) throws GeneralSecurityException, IOException {
        final PublicKey publicKey = getKeyPub();
        final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return doFinal(cipher, data, step_dec);
    }

    private byte[] doFinal(final Cipher cipher, final byte[] data,
                           final int step) throws GeneralSecurityException, IOException {
        if (data.length <= step) {
            return cipher.doFinal(data);
        } else {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (int i = 0; i < data.length; i += step) {
                final int len = (i + step) < data.length ? step : data.length
                        - i;
                final byte[] b = cipher.doFinal(data, i, len);
                bos.write(b);
            }
            return bos.toByteArray();
        }
    }
}