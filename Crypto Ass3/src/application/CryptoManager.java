package application;

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if ((int) plainText.charAt(i) < (int) LOWER_BOUND || (int) plainText.charAt(i) > (int) UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// Check if all string characters are in bound
		if (stringInBounds(plainText) == false){
			return "Not all of the String's characters are in bound";
		}
		
		// Variables Tools to encrypt string
		int num;
		StringBuilder sb = new StringBuilder(plainText);
		String result;
		
		// Encrypting each character 
		for (int i = 0; i < plainText.length(); i++) {
			num = (int) plainText.charAt(i) + key;
			while (num > UPPER_BOUND) {
				num -= RANGE;
			}
			sb.setCharAt(i, (char)num);
		}
		
		// Result
		result = sb.toString();
		return result;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// Check if all string characters are in bound
		if (stringInBounds(plainText) == false){
			return "Not all of the String's characters are in bound";
		}
				
		// Variable Tools to Encrypt string
		int sum;
		int j = 0;
		StringBuilder sb = new StringBuilder(plainText);
		String result;
		
		for (int i = 0; i < plainText.length(); i++) {
			sum = (int) plainText.charAt(i) + (int) bellasoStr.charAt(j);
			while (sum > UPPER_BOUND) {
				sum -= RANGE;
			}
			sb.setCharAt(i, (char)sum);
			j++;
			if (j >= bellasoStr.length()) {
				j = 0;
			}
		}
		
		// Result
		result = sb.toString();
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// Variable Tools
		int num;
		StringBuilder sb = new StringBuilder(encryptedText);
		String result;
		
		// De-crypting each character 
		for (int i = 0; i < encryptedText.length(); i++) {
			num = (int) encryptedText.charAt(i) - key;
			while (num < LOWER_BOUND) {
				num += RANGE;
			}
			sb.setCharAt(i, (char)num);
		}
		
		// Result
		result = sb.toString();
		return result;
		
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// Variable Tools
		int sum;
		int j = 0;
		StringBuilder sb = new StringBuilder(encryptedText);
		String result;
		
		// De-cryption
		for (int i = 0; i < encryptedText.length(); i++) {
			sum = (int) encryptedText.charAt(i) - (int) bellasoStr.charAt(j);
			while (sum < LOWER_BOUND) {
				sum += RANGE;
			}
			sb.setCharAt(i, (char)sum);
			j++;
			if (j >= bellasoStr.length()) {
				j = 0;
			}
		}
		
		// Result
		result = sb.toString();
		return result;
	}
}