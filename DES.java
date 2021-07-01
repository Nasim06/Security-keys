import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {
	static Cipher cipher;
	
	public DES() throws Exception {
		cipher = Cipher.getInstance("DES");
		
	}

	public String encrypt(String plainText, SecretKey secretKey) throws Exception {
		
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
		
	}

	public String decrypt(String encryptedText, SecretKey secretKey)
			throws Exception {

		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
		
	}
	
	
	public SecretKey generateRandomKey() throws NoSuchAlgorithmException{
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println(encodedKey);
		return secretKey;
		
	}
	
	public SecretKey generateKeyFromPassword(String password) throws Exception{
		
		byte[] passwordInBytes = (password).getBytes("UTF-8");		
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		byte[] key = sha.digest(passwordInBytes);				
		key = Arrays.copyOf(key, 8); 
		SecretKeySpec secretKey = new SecretKeySpec(key, "DES");
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println(encodedKey);		
		return secretKey;
		
	}


	
}