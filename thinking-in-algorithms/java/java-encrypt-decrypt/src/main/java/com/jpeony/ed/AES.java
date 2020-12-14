package com.jpeony.ed;//package com.lanhuigu.encryptdecrypt;
//
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import javax.crypto.Cipher;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.Security;
//import java.util.Arrays;
//
///**
// * @author yihonglei
// */
//public class AES {
//    // 算法名称
//    final static String KEY_ALGORITHM = "AES";
//    // 加解密算法/模式/填充方式
//    final static String algorithmStr = "AES/ECB/PKCS7Padding";
//    //
//    private static Key key;
//    private static Cipher cipher;
//    boolean isInited = false;
//
//    static byte[] iv = { 0x30, 0x31, 0x30, 0x32, 0x30, 0x33, 0x30, 0x34, 0x30, 0x35, 0x30, 0x36, 0x30, 0x37, 0x30, 0x38 };
//    public  static  void init(byte[] keyBytes) {
//
//        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
//        int base = 16;
//        if (keyBytes.length % base != 0) {
//            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
//            byte[] temp = new byte[groups * base];
//            Arrays.fill(temp, (byte) 0);
//            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
//            keyBytes = temp;
//        }
//        // 初始化
//        Security.addProvider(new BouncyCastleProvider());
//        // 转化成JAVA的密钥格式
//        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
//        try {
//            // 初始化cipher
//            cipher = Cipher.getInstance(algorithmStr, "BC");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 加密方法
//     *
//     * @param content
//     *            要加密的字符串
//     * @param keyBytes
//     *            加密密钥
//     * @return
//     */
//    public static byte[] encrypt(byte[] content, byte[] keyBytes) {
//        byte[] encryptedText = null;
//        init(keyBytes);
//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            encryptedText = cipher.doFinal(content);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedText;
//    }
//    /**
//     * 解密方法
//     *
//     * @param encryptedData
//     *            要解密的字符串
//     * @param keyBytes
//     *            解密密钥
//     * @return
//     */
//    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) {
//        byte[] encryptedText = null;
//        init(keyBytes);
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            encryptedText = cipher.doFinal(encryptedData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedText;
//    }
//
//    public static void main(String[] args) {
//        String str = "zNkSeANebsT6uK05MK4mkA==";
//        String key = "0123456789abcdef";
//
//        byte[] b = decrypt(str.getBytes(), key.getBytes());
//
//        System.out.println("===" + new String(b));
//
//    }
//}
