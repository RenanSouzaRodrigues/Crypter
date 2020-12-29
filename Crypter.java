package br.com.sabre.api.utils;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

public class Crypter {
	private static BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	private static BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	private static String masterPassword = "d7831ec62134ddccbe4d121f242959fc4254c88b575c410b571d7702da9e7afc";
	
	public static String encrypt(String textToEncrypt) {
		textEncryptor.setPasswordCharArray(masterPassword.toCharArray());
		String encryptedString = textEncryptor.encrypt(textToEncrypt);
		return encryptedString;
	}
	
	public static String decrypt(String encryptedString) {
		textEncryptor.setPasswordCharArray(masterPassword.toCharArray());
		String decryptedString = textEncryptor.decrypt(encryptedString);
		return decryptedString;
	}
	
	public static String passwordEncrypt(String password) {
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		return encryptedPassword;
	}
	
	public static boolean compare(String loosePassword, String encryptedPassword) {
		return passwordEncryptor.checkPassword(loosePassword, encryptedPassword);
	}
}