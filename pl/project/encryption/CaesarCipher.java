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
	 * @return char[] (returns encrypted/decrypted [] )
	 */

	public char[] makeEncryption(char[] msgToEncrypt) {
		int code = getCode();
		int shift = -1;
		char[] returnArray = new char[msgToEncrypt.length];
		for (int i = 0; i < msgToEncrypt.length; i++) {
			for (int j = 0; j < alphaLen; j++) {
				if (Character.isLetter(msgToEncrypt[i])) {
					if (msgToEncrypt[i] == alphabet[j]) {
						if (isEncryptionFlag()) {
							shift = (code + j) % alphaLen;
						} else {
							shift = (j - (code % alphaLen) + alphaLen) % alphaLen;
						}
						returnArray[i] = alphabet[shift];
					}
				} else {
					returnArray[i] = msgToEncrypt[i];
				}
			}
		}

		return returnArray;

	}

}
