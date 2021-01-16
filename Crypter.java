package br.com.sabre.api.utils;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

public class Crypter {
	private static BasicTextEncryptor textEncryptor;
	private static BasicPasswordEncryptor passwordEncryptor;
	private static String masterPassword = "d7831ec62134ddccbe4d121f242959fc4254c88b575c410b571d7702da9e7afc";
	
	/**
	 * Returns a encrypted string that can be decrypted
	 * @author Renan Souza Rodrigues
	 * @param textToEncrypt string to encrypt
	 * @return String
	 */
	public static String encrypt(String textToEncrypt) {
		textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPasswordCharArray(masterPassword.toCharArray());
		String encryptedString = textEncryptor.encrypt(textToEncrypt);
		return encryptedString;
	}
	
	/**
	 * Returns a decrypted string previously encrypted with the 'encrypt' method
	 * @author Renan Souza Rodrigues
	 * @param encryptedString token as encrypted string
	 * @return String
	 */
	public static String decrypt(String encryptedString) {
		textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPasswordCharArray(masterPassword.toCharArray());
		String decryptedString = textEncryptor.decrypt(encryptedString);
		return decryptedString;
	}
	
	/**
	 * Return a encrypted password string. This method has only one way. The encrypted password cannot be decrypted.
	 * @author Renan Souza Rodrigues
	 * @param password string password to be encrypted
	 * @return String
	 */
	public static String passwordEncrypt(String password) {
		passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		return encryptedPassword;
	}
	
	/**
	 * Compare to encrypted passwords
	 * @author Renan Souza Rodrigues
	 * @param loosePassword as encrypted string
	 * @param encryptedPassword as encrypted string
	 * @return Boolean
	 */
	public static Boolean compare(String loosePassword, String encryptedPassword) {
		passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.checkPassword(loosePassword, encryptedPassword);
	}
}
