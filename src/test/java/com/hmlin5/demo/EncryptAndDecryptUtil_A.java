package com.hmlin5.demo;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncryptAndDecryptUtil_A {
    public static String keyValue = "123"; // 用户密钥
    public static String token = "";//口令

    /***************** AES文本加密、解密 ********************/
    /**
     * 文本加密
     *
     * @param content
     *            需要加密的文本
     * @param keyValue
     *            密钥
     * @return 加密后文本
     */
    public static String encrypt(String content) {
        String str = "";
        try {
            SecretKey secretKey = getKey(keyValue);
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return parseByte2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 解密
     *
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decrypt(String content) {
        try {
            SecretKey secretKey = getKey(keyValue);
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(parseHexStr2Byte(content));
            String strRes = null;
            try {
                strRes = new String(result, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return strRes;
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
        }
        return null;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static SecretKey getKey(String strKey) {
        try {
            KeyGenerator _generator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128, secureRandom);
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(" 初始化密钥出现异常 ");
        }
    }

    /***************** MD5生成摘要; SHA-1生成签名 ********************/

    /**
     * 使用指定算法加密（默认MD5，生成摘要）
     *
     */
    public static String digest(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "MD5";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = EncryptAndDecryptUtil_A.parseByte2HexStr(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * 根据token、lol以及时间戳来生成签名
     *
     * @param token
     * @param lol
     * @param millis
     * @return
     */
    public static String generateSignature(String token, String lol,
                                           long millis) {
        String timestamp = String.valueOf(millis);
        String signature = null;
        if (null!=token && !"".equals(token) && null!=timestamp && !"".equals(timestamp)) {
            List<String> srcList = new ArrayList<String>();
            srcList.add(timestamp);
            srcList.add(token);
            srcList.add(lol);
            Collections.sort(srcList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < srcList.size(); i++) {
                sb.append(srcList.get(i));
            }
            signature = digest(sb.toString(), "SHA-1");
            srcList.clear();
            srcList = null;
        }
        return signature;
    }

    /**
     * 验证摘要(判断参数是否被修改过)
     * @param digest
     * @param requestParamStr
     * @return
     */
    public static boolean isValid(String digest,String requestParamStr){
        String lol = EncryptAndDecryptUtil_A.digest(requestParamStr, "MD5");
        return digest.equals(lol);
    }

    /**
     * 验证签名:
     * 1.根据token、lol以及时间戳计算一次签名;<br/>
     * 2.比较传过来的签名以及计算出的签名是否一致;
     * @param signature
     * @param lol
     * @param millis
     * @return
     */
    public static boolean isValid(String signature, String digest, long millis) {
        String calculatedSignature = generateSignature(token, digest,millis);
        if (calculatedSignature.equals(signature)) {
            return true;
        } else {
            return false;
        }
    }

}