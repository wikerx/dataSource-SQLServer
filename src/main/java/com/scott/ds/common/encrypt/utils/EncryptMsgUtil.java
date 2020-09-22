package com.scott.ds.common.encrypt.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.scott.ds.common.utils.Ognl;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 标题:  EncryMsgUtil
 * 公司： FTP/自贸通
 * 作者： Mr.薛
 * 时间： 2020-5-21上午10:42:53
 * 内容： 数据加密格式
 * 状态： 编写
 */
public class EncryptMsgUtil {
    private static Logger logger = LoggerFactory.getLogger(EncryptMsgUtil.class);
    //	加密方式
    public static final String SHA256 = "SHA-256";
    public static final String SHA512 = "SHA-512";
    public static final String RSA_ALGORITHM = "RSA";
    public static final String RSA_ALGORITHM_MD5 = "MD5withRSA";
    public static final String KEY_ALGORITHM = "AES";
    private static final String SIGN_ALGORITHMS = "SHA1PRNG";
    //	编码格式
    private static final String ENCODE_TYPE = "UTF-8";
    //	RSA最大加密明文大小
    private static final int MAX_ENCRYPT_BLOCK = 117;
    //   RSA最大解密密文大小
    private static final int MAX_DECRYPT_BLOCK = 128;
    //    Token偏移向量 - 不允许修改
    private static final String FINGER_PRINT_IV = "8FC11150A7508F14BACA07285703392A399CC57C";

    /**
     * 密钥
     * 测试使用，请勿直接使用
     */
    private static String KEY = "x3/eqbraBj0pFyKLza21lq3nj7TP31Wz86DQZEKEszm9NRO/JxKmUTpwBOBslGF0xS3NtT2m3EHYieymCMbQQ/8j68SZNg/5DHH+pznp3P5f65lcIYsVh3mP5fjhPI6vaYthmG0QOd/bFjzxrSMvP8Fi=/vHezHNwiZ8siAcQF3yXgStuTE3tH9tV8IOLJPpRrjRXqNCAOCjVZtpJRun6OBb";


    /**
     * 利用java原生的类实现SHA256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance(SHA256);
            messageDigest.update(str.getBytes(ENCODE_TYPE));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }


    /**
     * 字符串 SHA 加密
     *
     * @param encryptMsg     字符数据
     * @param encryptSHAType 加密格式支持256和512方式
     * @return 加密结果
     */
    public static String encryptSHA(String encryptMsg, String encryptSHAType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (encryptMsg != null && encryptMsg.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest
                        .getInstance(encryptSHAType);
                // 传入要加密的字符串
                messageDigest.update(encryptMsg.getBytes());
                // 得到 byte 类型结果
                byte byteBuffer[] = messageDigest.digest();

                // 将 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                logger.error("-01-字符串 SHA 加密异常-" + e.getMessage());
                e.printStackTrace();
            }
        }

        return strResult;
    }

	/**
	 * 字符串MD5加密
	 * @param encryptMsg
	 * @return
	 */
    public static String encryptMD5(String encryptMsg) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
					encryptMsg.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }


    /**
     * 获取密钥对
     *
     * @return 密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        generator.initialize(1024);
        return generator.generateKeyPair();
    }

    /**
     * 获取私钥
     *
     * @param privateKey 私钥字符串
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取公钥
     *
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * RSA加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return
     */
    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.getBytes().length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        // 获取加密内容使用base64进行编码,并以UTF-8为标准转化成字符串
        // 加密后的字符串
        return new String(Base64.encodeBase64String(encryptedData));
    }

    /**
     * RSA解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return
     */
    public static String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dataBytes = Base64.decodeBase64(data);
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        // 解密后的内容
        return new String(decryptedData, ENCODE_TYPE);
    }

    /**
     * 签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(RSA_ALGORITHM_MD5);
        signature.initSign(key);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 验签
     *
     * @param srcData   原始字符串
     * @param publicKey 公钥
     * @param sign      签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(RSA_ALGORITHM_MD5);
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }


    /*
     * 加密
     */
    public static String AESEncode(String content) {
        return AESEncode(content, KEY);
    }

    /*
     * 加密
     */
    public static String AESEncode(String content, String pkey) {
        if (pkey == null) {
            pkey = KEY;
        }
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance(KEY_ALGORITHM);
            //故调整为如下方式
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(pkey.getBytes(ENCODE_TYPE));
            keygen.init(128, random);
            SecretKey original_key = keygen.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byte_encode = content.getBytes(ENCODE_TYPE);
            byte[] byte_AES = cipher.doFinal(byte_encode);
            String AES_encode = new String(Base64.encodeBase64(byte_AES));
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
     * 解密 
     */
    public static String AESDncode(String content) {
        return AESDncode(content, KEY);
    }

    public static String AESDncode(String content, String pkey) {
        if (pkey == null) {
            pkey = KEY;
        }
        try {
            KeyGenerator keygen = KeyGenerator.getInstance(KEY_ALGORITHM);
            //故调整为如下方式
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(pkey.getBytes(ENCODE_TYPE));
            keygen.init(128, random);
            SecretKey original_key = keygen.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byte_content = Base64.decodeBase64(content);
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, ENCODE_TYPE);
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过SHA256模拟生成伪装Token
     */
    public static String buildToken(String msg) {
        String token = "";
        if (Ognl.isEmpty(msg)) {
            msg = String.valueOf(System.currentTimeMillis()) +
                    FINGER_PRINT_IV;
        }

        token = encryptSHA(msg, SHA256);

        return token;
    }

    /**
     * token验证 - 伪装型，不包含过期设置
     */
    public static boolean verifToken(String msg, String token) {
        String verifToken = "";
//		默认验证失败
        boolean flag = false;
        if (Ognl.isEmpty(msg)) {
            msg = String.valueOf(System.currentTimeMillis()) +
                    FINGER_PRINT_IV;
        }

        verifToken = encryptSHA(msg, SHA256);

        if (Ognl.isNotEmpty(verifToken) &&
                verifToken.equalsIgnoreCase(token)) {
            flag = true;
        }

        return flag;
    }

    /**
     * @param cardno the input data collection
     * @return CardNoTruncation 获取截取之后的cardno
     */
    public static String getCardNoTruncation(String cardno) {
        int length=cardno.length();
        return length > 10 ? cardno.substring(0,6) +"***"+ cardno.substring(length - 4, length) : cardno;
    }


}
