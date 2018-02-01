package pl.project.encryption;

//W przypadku interfejsu modyfikatory public są zbędne - metody interfejsu zawsze są publiczne. 

interface EncryptionInterface {

	boolean encryptionFlag = false;
	
	//Jeśli zaś chodzi o stałe takie jak alfabet można je oznaczyć jako static final 
	//(wtedy inicjowane są tylko raz w ciągu trwania całej aplikacji). 
	//Zwyczajowo takie stałe pisze się z dużych liter, np. ALPHABET albo ALPHA_LEN.

	final static char[] ALPHABET = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
	final static int ALPHA_LEN = ALPHABET.length;

	boolean isEncryptionFlag();

	void setEncryptionFlag(boolean encryptionFlag);

	char[] makeEncryption(char[] msgToProcess);

}
