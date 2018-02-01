package pl.project.encryption;

public class VigenereEncryption implements EncryptionInterface {

	private boolean encryptionFlag;
	private char[] psswdPreparation;

	public char[] getPsswdPreparation() {
		return psswdPreparation;
	}

	public void setPsswdPreparation(char[] psswdPreparation) {
		this.psswdPreparation = psswdPreparation;
	}

	public boolean isEncryptionFlag() {
		return encryptionFlag;
	}

	public void setEncryptionFlag(boolean encryptionFlag) {
		this.encryptionFlag = encryptionFlag;
	}

	public VigenereEncryption(boolean encryptionFlag) {
		setEncryptionFlag(encryptionFlag);
	}

	/**
	 * Function prepares passwod array for Vigenere ecnryption
	 * @param String password
	 * @param char [] msgToEncrypt (lower case letters only)
	 */
	
	public String psswdChecker(String password) {
		char[] psTable = password.toCharArray();
		boolean status=false;
		while(!status) {
			for(int i=0;i<psTable.length;i++) {
				if(Character.isLowerCase(psTable[i])) {
					status=true;
				}else {
					System.out.println("Please provide correct passoword format");
				}
			}
		}
			
		return new String(psTable);
	}
	
	public void psswdPreparation(String password, char[] msgToEncrypt) {
		char psswdChar[] = password.toCharArray();
		char[] passwordArray = new char[msgToEncrypt.length];

		for (int i = 0; i < msgToEncrypt.length; i++) {
			if (Character.isLetter(msgToEncrypt[i])) {
				for (int j = 0; j < psswdChar.length; j++) {
					passwordArray[i] = psswdChar[i % psswdChar.length];
				}
			} else {
				passwordArray[i] = msgToEncrypt[i];
			}
		}
		setPsswdPreparation(passwordArray);
	}
	
	/**
	 * Function provides vigenereEncryption
	 * @param char[] (lower case letters only)
	 * @return char[] 
	 */

	public char[] makeEncryption(char[] msgToEncrypt) {
		char[] passwordArray = getPsswdPreparation();
		int msgLength = msgToEncrypt.length;
		char[] encrypterTable = new char[msgLength];
		int[] mesToEncryptId = new int[msgLength];
		int[] psswdArrayId = new int[msgLength];
		int[] revPasswordArrayId = new int[msgLength];
		for (int i = 0; i < msgLength; i++) {
			for (int j = 0; j < ALPHA_LEN; j++) {
				if (msgToEncrypt[i] == ALPHABET[j]) {
					mesToEncryptId[i] = j;
				}
				if (passwordArray[i] == ALPHABET[j]) {
					psswdArrayId[i] = j;
					revPasswordArrayId[i] = (ALPHA_LEN - j) % ALPHA_LEN;
				}
			}
			if (Character.isLetter(passwordArray[i])) {
				if (this.encryptionFlag) {
					encrypterTable[i] = ALPHABET[(mesToEncryptId[i] + psswdArrayId[i]) % ALPHA_LEN];
				} else {
					encrypterTable[i] = ALPHABET[(mesToEncryptId[i] + revPasswordArrayId[i]) % ALPHA_LEN];
				}

			} else {
				encrypterTable[i] = msgToEncrypt[i];
			}

		}

		return encrypterTable;
	}

}