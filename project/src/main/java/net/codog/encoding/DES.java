package net.codog.encoding;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class DES {
	
    private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };  
    
    @SuppressWarnings("restriction")
	public static String encryptBasedDes(String data) {  
        String encryptedData = null;  
        try {  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(DES_KEY);  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey key = keyFactory.generateSecret(deskey);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));  
        } catch (Exception e) {  
            throw new RuntimeException("加密错误，错误信息：", e);  
        }  
        return encryptedData;  
    }  
   
    
    @SuppressWarnings("restriction")
	public static String decryptBasedDes(String cryptData) {  
        String decryptedData = null;  
        try {  
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(DES_KEY);  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey key = keyFactory.generateSecret(deskey);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.DECRYPT_MODE, key, sr);    
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));  
        } catch (Exception e) {   
            throw new RuntimeException("解密错误，错误信息：", e);  
        }  
        return decryptedData;  
    }  
    
}
