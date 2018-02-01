package pl.project.encryption;

public class CaesarCipher implements EncryptionInterface {

	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public CaesarCipher(boolean encryptionFlag) {
		setEncryptionFlag(encryptionFlag);
	}

	private boolean encryptionFlag; // checks if encryption or decryption is required

	@Override
	public boolean isEncryptionFlag() {
		return this.encryptionFlag;
	}

	@Override
	public void setEncryptionFlag(boolean encryptionFlag) {
		this.encryptionFlag = encryptionFlag;

	}

	/**
	 * Funtion provides encryption/decryption using Casear method
	 * 
	 * @param char[] (small letters only)
	 * @return 
	 * @return char[] (returns encrypted/decrypted [] )
	 */

	
	private boolean letterMatch(char i, char k) {
		boolean status=false;
		if(Character.isLetter(i)) {
			if(i==k) {
				status=true;
			}else {
				status=false;
			}
		}
		return status;
	}
	


	
	public char[] makeEncryption(char[] msgToEncrypt) {
		int code = getCode();
		int shift = -1;
		char[] returnArray = new char[msgToEncrypt.length];
		for (int i = 0; i < msgToEncrypt.length; i++) {
			for (int j = 0; j < ALPHA_LEN; j++) {
				if(letterMatch(msgToEncrypt[i], ALPHABET[j])) {
					
				}
					
				}
			}
	
	
	}
	
	
	/*
	public char[] makeEncryption(char[] msgToEncrypt) {
		int code = getCode();
		int shift = -1;
		char[] returnArray = new char[msgToEncrypt.length];
		for (int i = 0; i < msgToEncrypt.length; i++) {
			for (int j = 0; j < ALPHA_LEN; j++) {
				if (Character.isLetter(msgToEncrypt[i])) {
					if (msgToEncrypt[i] == ALPHABET[j]) {
						if (isEncryptionFlag()) {
							shift = (code + j) % ALPHA_LEN;
						} else {
							shift = (j - (code % ALPHA_LEN) + ALPHA_LEN) % ALPHA_LEN;
						}
						returnArray[i] = ALPHABET[shift];
					}
				} else {
					returnArray[i] = msgToEncrypt[i];
				}
			}
		}

		return returnArray;

	}*/

}
