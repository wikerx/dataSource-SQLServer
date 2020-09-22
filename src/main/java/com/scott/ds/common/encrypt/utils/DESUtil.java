package com.scott.ds.common.encrypt.utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :DESUtil
 * @description :
 * @data :2020/8/7 0007 下午 3:13
 * @status : 编写
 **/
public class DESUtil {
    // DES加密密钥key
    public static String key = "sdfDA12r3JHV214IJrwerDSO892BK2345nrekk35oewr4wrwrenlklknsdlemifzkw8iiiifegJG7649UJNDFJSvgsfdjFGDFGj435jUhjhjbkajb12kj987gsjh9834tbAXiudhf9B3PM4bt98dyf9Q2m97jjyf417aliD";

    /**
     * DES加密明文plaintext
      * @param plaintext
     * @return
     */
    @SuppressWarnings("static-access")
    public static String encryptDES(String plaintext) {
        try {
            // 首先，DES算法要求有一个可信任的随机数源，可以通过 SecureRandom类,内置两种随机数算法，NativePRNG和SHA1PRNG
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 加密生成密文byte数组
            byte[] cipherBytes = cipher.doFinal(plaintext.getBytes());
            // 将密文byte数组转化为16进制密文
            String ciphertext = byteToHex(cipherBytes);
            return ciphertext;
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * DES解密
      * @param ciphertext
     * @return
     */
    @SuppressWarnings("static-access")
    public static String decryptDES(String ciphertext) {
        try {
            // DES算法要求有一个可信任的随机数源，SecureRandom内置两种随机数算法，NativePRNG和SHA1PRNG,
            // 通过new来初始化，默认来说会使用NativePRNG算法生成随机数，但是也可以配置-Djava.security参数来修改调用的算法，
            // 如果是/dev/[u]random两者之一就是NativePRNG，否则就是SHA1PRNG。
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 将16进制密文转化为密文byte数组
            byte[] cipherBytes = hexToByte(ciphertext);
            // 真正开始解密操作
            String plaintext = new String(cipher.doFinal(cipherBytes));
            return plaintext;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    // 将byte转化为16进制
    public static String byteToHex(byte[] bs) {
        if (0 == bs.length) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < bs.length; i++) {
                String s = Integer.toHexString(bs[i] & 0xFF);
                if (1 == s.length()) {
                    sb.append("0");
                }
                sb = sb.append(s.toUpperCase());
            }
            return sb.toString();
        }
    }

    // 将16进制转化为byte
    public static byte[] hexToByte(String ciphertext) {
        byte[] cipherBytes = ciphertext.getBytes();
        if ((cipherBytes.length % 2) != 0) {
            throw new IllegalArgumentException("长度不为偶数");
        } else {
            byte[] result = new byte[cipherBytes.length / 2];
            for (int i = 0; i < cipherBytes.length; i += 2) {
                String item = new String(cipherBytes, i, 2);
                result[i / 2] = (byte) Integer.parseInt(item, 16);
            }
            return result;
        }
    }

     // 进行测试
    public static void main(String[] args) {
        // 当前时间戳
        // 待加密内容
        String str = "20200807150709948780";
        // 密码，长度要是8的倍数
        String ciphertext = encryptDES(str);
        System.out.println("加密后：" + ciphertext);
        String plaintext = decryptDES(ciphertext);
        System.out.println("解密后：" + plaintext);
        String t = plaintext.substring(plaintext.length() - 13,plaintext.length());
        System.out.println(t);
    }

}
