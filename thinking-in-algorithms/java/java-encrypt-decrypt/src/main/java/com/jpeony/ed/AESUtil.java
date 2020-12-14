package com.jpeony.ed;//package com.lanhuigu.encryptdecrypt;
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * @author yihonglei
// */
//public class AESUtil {
//    private static final String KEY_ALGORITHM = "AES";
//    /** 默认的加密算法 */
//    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
//
//    /**
//     * AES加密
//     * @author yihonglei
//     * @params content   待加密内容，即明文
//     * @params password  加密密码
//     * @return String    返回Base64转码后的加密数据
//     * @throws
//     * @since 1.0.0
//     */
//    public static String encrypt(String content, String password) {
//        try {
//            // 创建密码器
//            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
//            byte[] byteContent = content.getBytes("utf-8");
//
//            // 初始化为加密模式的密码器
//            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
//
//            // 加密
//            byte[] result = cipher.doFinal(byteContent);
//
//            //通过Base64转码返回
//            return Base64.encodeBase64String(result);
//        } catch (Exception ex) {
//            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }
//
//    /**
//     * AES解密
//     * @author yihonglei
//     * @params content   密文
//     * @params password  解密密码
//     * @return String    返回解码后的明文
//     * @throws
//     * @since 1.0.0
//     */
//    public static String decrypt(String content, String password) {
//        try {
//            // 实例化
//            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
//
//            // 使用密钥初始化，设置为解密模式
//            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
//
//            // 执行操作
//            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
//
//            // 以UTF-8方式返回明文
//            return new String(result, "utf-8");
//        } catch (Exception ex) {
//            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }
//
//    /**
//     * 生成加密密钥
//     * @author yihonglei
//     * @params password 密码
//     * @return 加密密钥
//     * @throws
//     * @since 1.0.0
//     */
//    private static SecretKeySpec getSecretKey(final String password) {
//        // 返回生成指定算法密钥生成器的KeyGenerator对象
//        KeyGenerator kg = null;
//        try {
//            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//
//            // AES要求密钥长度为128
//            kg.init(128, new SecureRandom(password.getBytes()));
//
//            // 生成一个密钥
//            SecretKey secretKey = kg.generateKey();
//
//            // 转换为AES专用密钥
//            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String str = "hello,您好啊!";
//        String secretKeySpec = "123456";
//        System.out.println("加密前的内容:" + str);
//
//        String encryptStr = AESUtil.encrypt(str, secretKeySpec);
//        System.out.println("加密后的内容:" + encryptStr);
//
//        String decryptStr = AESUtil.decrypt(encryptStr, secretKeySpec);
//        System.out.println("解密后的内容:" + decryptStr);
//
//        String s = AESUtil.decrypt("zNkSeANebsT6uK05MK4mkA==", "0123456789abcdef");
//    }
//}
