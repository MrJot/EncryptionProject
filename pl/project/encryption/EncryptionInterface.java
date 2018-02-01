package pl.project.encryption;

public interface EncryptionInterface {

	public boolean encryptionFlag = false;

	final char[] alphabet = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
	final int alphaLen = alphabet.length;

	public boolean isEncryptionFlag();

	public void setEncryptionFlag(boolean encryptionFlag);

	public char[] makeEncryption(char[] msgToProcess);

}
