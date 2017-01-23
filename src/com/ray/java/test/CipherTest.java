package com.ray.java.test;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by 80107442 on 2017-01-22.
 */
public class CipherTest {
    public static void main(String[] args) {
        String decrypt = decrypt("d41d8cd98f00b204e9800998ecf8427e", "KDFH&^Ec");
        System.out.println(decrypt);
    }

    public static String decrypt(String in, String key) {
        if ((null == in) || (null == key)) {
            return in;
        }
        byte[] data = decryptBytes(hexStringToBytes(in), key.getBytes());
        return new String(data);
    }

    /**
     * 解密字节数组
     *
     * @param inBytes 输入字节数组
     * @return 解密后的字节数组
     */
    public static byte[] decryptBytes(byte[] inBytes, byte[] key) {
        try {
            DESKeySpec keySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key desKey = keyFactory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            return cipher.doFinal(inBytes);
        } catch (Exception e) {
            return inBytes;
        }
    }


    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
