package pl.project.encryption;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {

	private int status; // user input switch status
	private char[] convertedMessage;// removed upper case, remember index position
	private String msg; // raw String message predefined by the user
	private char[] encMessage; // encoded/decoded char []
	private String encodedMessage; // converted encoded/decoded message to String, restore upper letters)

	// GETTERS AND SETTERS

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public char[] getEncMessage() {
		return encMessage;
	}

	public void setEncMessage(char[] encMessage) {
		this.encMessage = encMessage;
	}

	public String getEncodedMessage() {
		return encodedMessage;
	}

	public void setEncodedMessage(String encodedMessage) {
		this.encodedMessage = encodedMessage;
	}

	public char[] getConvertedMessage() {
		return convertedMessage;
	}

	public void setConvertedMessage(char[] convertedMessage) {
		this.convertedMessage = convertedMessage;
	}
	
	
	/**
	 * Welcome message
	 */
	public void welcomeMessage() {
		System.out.println("Welcome to BetaCipher. This simple app will encrypt/decrypt your messages\n"
				+ "using two different methods: Caesar Cipher or Vigenere Cipher.\n\n");
	}
	
	
	/**
	 * Select source of encoded/decoded message
	 * case 1 - Keyboard input
	 * case 2 - Text file
	 */
	
	public void selectInputMethod() {
		Scanner scan = new Scanner(System.in);
		//Main newSubmission = new Main();
		System.out.println("Select your input data definition\n[1] - Keybord entry\n[2] - Text file");
		try {
			setStatus(Integer.parseInt(scan.next()));
		} catch (NumberFormatException e) {
			System.out.println("This is not valid number");
		}
		scan.nextLine();
		switch (getStatus()) {
		case 1:
			System.out.println("Type message for encryption/decryption:");
			setMsg(scan.nextLine());
			break;
		case 2:
			setMsg(new ReadWriteInputFile().usingBufferedReader());
			break;
		default:
			System.out.println("You have 'literally two options: '1' or '2' ");
			System.out.println("Try again");
			selectInputMethod();
		}
		
	}
	
	
	/**
	 * Select encryption method
	 */
	public void selectEncryptionMethod() {
		EncryptionInterface newTask = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Select requested encryption/decryption method:\n[1]-Caesar Cipher\n[2]-Vigenere Cipher");
		try {
			setStatus(Integer.parseInt(scan.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("This is not valid number");
		}
		switch(getStatus()){
		case 1:
			newTask = new CaesarCipher(selectOperation());
			System.out.println("Type a passoward for encryption/decryption (integers > 0 ONLY)");
			boolean loopBool = false;
			while(!loopBool) {
				try {
					((CaesarCipher)newTask).setCode(Integer.parseInt(scan.nextLine()));
					if(((CaesarCipher)newTask).getCode()<0) {
						System.out.println("Your number should be POSITIVE\nRetype your password:");
					}else  {
						loopBool=true;	
					}
				} catch (NumberFormatException e) {
					System.out.println("This is Casear Cipher. You can encode/decode you message\nusing ONLY numerical passoword\nType a positive integer number:");
				}
			}
			setEncMessage(((CaesarCipher) newTask).makeEncryption(getConvertedMessage()));
			break;
			
		case 2:
			newTask = new VigenereEncryption(selectOperation());
			System.out.println("Type a passoward for encryption/decryption (low letters ONLY)");
			loopBool=false;
			String password="";
			while(!loopBool) {
				password = scan.nextLine();
				for(char e:password.toCharArray()) {
					if(Character.isLowerCase(e)==false){
						System.out.println("Invalid password");
						loopBool=false;
						System.out.println("Retype your password:");
						break;
					}else {
						loopBool=true;
					}
				}
				
			
		}
			
			((VigenereEncryption) newTask).psswdPreparation(password, getConvertedMessage());
			setEncMessage(((VigenereEncryption) newTask).makeEncryption(getConvertedMessage()));
			break;
		default:
			System.out.println("You have 'literally two options: '1' or '2' ");
			System.out.println("Try again");
			selectEncryptionMethod();
			
		}
		
	}
	
	
	/**
	 * Sets if message should be encrypted/decrypted
	 * @return encryption status
	 */
	public boolean selectOperation() {
		boolean status=true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to:\n[1]-Encrypt your message\n[2]-Decrypt your message");
		try {
			setStatus(Integer.parseInt(scan.next()));
		} catch (NumberFormatException e) {
			System.out.println("This is not valid number");
		}
		switch(getStatus()) {
		case 1:
			status = true;
			break;
		case 2:
			status = false;
			break;
		default:
			System.out.println("You have 'literally two options: '1' or '2' ");
			System.out.println("Try again");
			selectOperation();
		}
		
		return status;	
		
	}
	
	/**
	 * encoded/decoded message postProcessing
	 * 
	 */
	public void messagePostProcessing() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to:\n[1] - Print your encoded/decoded message.\n[2] - Save your encoded/decoded message to a file.\n[3] - Print and save"
						+ " your encoded/decoded message.");
		try {
			setStatus(Integer.parseInt(scan.next()));
		} catch (NumberFormatException e) {
			System.out.println("This is not valid number");
		}
		switch (getStatus()) {
		case 1:
			System.out.println("YOUR ENCODED/DECODED MESSAGE");
			System.out.println(getEncodedMessage());
			break;
		case 2:
			new ReadWriteInputFile().writeEncodedString(getEncodedMessage());
			break;
		case 3:
			System.out.println("YOUR ENCODED/DECODED MESSAGE");
			System.out.println(getEncodedMessage());
			new ReadWriteInputFile().writeEncodedString(getEncodedMessage());
			break;
		default:
			System.out.println("You have 'literally three options: '1','2' or '3' ");
			System.out.println("Try again");
			messagePostProcessing() ;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Main newTask = new Main();
		newTask.welcomeMessage();
		newTask.selectInputMethod();
		
		StringConversion newString = new StringConversion(newTask.getMsg());
		
		newTask.setConvertedMessage(newString.getMessageToCipher());
		newTask.selectEncryptionMethod();
		newTask.setEncodedMessage(newString.toUpperCase(newTask.getEncMessage()));
		
		System.out.println("Message length: " + newTask.getMsg().length() + " chars");
		newTask.messagePostProcessing();
	}
	
	

	

}
