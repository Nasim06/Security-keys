import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class test {

	
	public static void main(String[] args) throws Exception {
		
		AES aesGen = new AES();
		String message = "Hello world";
		System.out.println("Plain text: " + message);
		System.out.print("Random key: ");
		SecretKey key = aesGen.generateRandomKey();
		
		String encrypted = aesGen.encrypt(message, key);
		System.out.println("Cipher text: " + encrypted);
		
		String decrypted = aesGen.decrypt(encrypted, key);
		System.out.println("decrypted plain text: " + decrypted);
		
		System.out.println(" ");
		
		System.out.print("key from password: ");
		SecretKey key2 = aesGen.generateKeyFromPassword("strongPassword");
		
		String encrypted2 = aesGen.encrypt(message, key2);
		System.out.println("Cipher text: " + encrypted2);
		
		String decrypted2 = aesGen.decrypt(encrypted2, key2);
		System.out.println("decrypted plain text: " + decrypted2);
		
		System.out.println(" ");
		
		DES desGen = new DES();
		String sample = "laminated hardwood";
		System.out.println("Plain text: " + sample);
		System.out.print("Random key: ");
		SecretKey key3 = desGen.generateRandomKey();
		
		String encryptedDes = desGen.encrypt(sample, key3);
		System.out.println("Cipher text: " + encryptedDes);
		
		String decryptedDes = desGen.decrypt(encryptedDes, key3);
		System.out.println("decrypted plain text: " + decryptedDes);
		
		

		
	}
	

}
