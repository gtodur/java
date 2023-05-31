package com.patterns.behavioural;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class StrategyPattern {

	public static void main(String[] args) {
	      EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
	      Encryptor aesEncryptor=new Encryptor(aesStrategy);
	      aesEncryptor.setPlainText("This is plain text");
	      aesEncryptor.encrypt();
	        EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
	        Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
	        blowfishEncryptor.setPlainText("This is plain text");
	        blowfishEncryptor.encrypt();

	}

}

/*
 * Strategy
 * Is an interface common to all supported algorithm-specific classes.
 */
interface EncryptionStrategy {
    void encryptData(String plainText);
}

/*
 * Concrete Strategy
 * Implements the algorithm using the Strategy interface.
 */
class AesEncryptionStrategy implements EncryptionStrategy{
	   @Override
	    public void encryptData(String plaintext) {
	       System.out.println("-------Encrypting data using AES algorithm-------");
	       try {
	           KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	           keyGenerator.init(128);
	           SecretKey secretKey = keyGenerator.generateKey();
	           byte[] plaintTextByteArray = plaintext.getBytes("UTF8");
	           Cipher cipher = Cipher.getInstance("AES");
	           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	           byte[] cipherText = cipher.doFinal(plaintTextByteArray);
	           System.out.println("Original data: " + plaintext);
	           System.out.println("Encrypted data:");
	           for (int i = 0; i < cipherText.length; i++) {
	               System.out.print(cipherText[i] + " ");
	           }
	       }
	           catch(Exception ex){
	               ex.printStackTrace();
	           }
	       }
	   }

/*
 * Concrete Strategy
 * Implements the algorithm using the Strategy interface.
 */
class BlowfishEncryptionStrategy implements EncryptionStrategy{
    @Override
    public void encryptData(String plaintext) {
        System.out.println("\n-------Encrypting data using Blowfish algorithm-------");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] plaintTextByteArray = plaintext.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plaintTextByteArray);
            System.out.println("Original data: " + plaintext);
            System.out.println("Encrypted data:");
            for (int i = 0; i < cipherText.length; i++) {
                System.out.print(cipherText[i] + " ");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

/*
 * Context
 * Provides the interface to client for encrypting data. 
 * The Context maintains a reference to a Strategy object and 
 * is instantiated and initialized by clients with a ConcreteStrategy object.
 */
class Encryptor {
    private EncryptionStrategy strategy;
    private String plainText;
    public Encryptor(EncryptionStrategy strategy){
        this.strategy=strategy;
    }
    public void encrypt(){
        strategy.encryptData(plainText);
    }
    public String getPlainText() {
        return plainText;
    }
    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
}

