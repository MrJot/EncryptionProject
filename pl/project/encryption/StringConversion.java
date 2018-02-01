package pl.project.encryption;

import java.util.ArrayList;

public class StringConversion {

	private ArrayList<Integer> capitalLetterIndex = new ArrayList<Integer>();
	private char[] messageToCipher;

	public StringConversion(String inputMessage) {
		toLowerCase(inputMessage);
	}
	
	public StringConversion() {
		
	}

	public char[] getMessageToCipher() {
		return messageToCipher;
	}

	public void setMessageToCipher(char[] messageToCipher) {
		this.messageToCipher = messageToCipher;
	}

	public ArrayList<Integer> getCapitalLetterIndex() {
		return capitalLetterIndex;
	}

	public void setCapitalLetterIndex(ArrayList<Integer> capitalLetterIndex) {
		this.capitalLetterIndex = capitalLetterIndex;
	}

	/**
	 * Function converts String input. 
	 * Stage 1. Conversion to char array
	 * Stage 2. Upper case letters converted to lower case
	 * Stage 3. Creates ArrayList with upper case letters location
	 *
	 * to lower case. Upper case 
	 * @param String input
	 */
	public void toLowerCase(String input) {
		ArrayList<Integer> indexNumber = new ArrayList<Integer>();
		char[] inputArray = input.toCharArray();
		char[] outputArray = new char[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			if (Character.isUpperCase(inputArray[i])) {
				indexNumber.add(i);
			}
			outputArray[i] = Character.toLowerCase(inputArray[i]);
		}
		setCapitalLetterIndex(indexNumber);
		setMessageToCipher(outputArray);
	}
	
	
	/**
	 * Function restores capital letters (using previously created ArrayList CapitalLetterIndex index location)
	 * @param char [] input
	 * @return String message
	 */
	public String toUpperCase(char input[]) {
		ArrayList<Integer> indexID = getCapitalLetterIndex();
		for (int i : indexID) {
			input[i] = Character.toUpperCase(input[i]);
		}
		return new String(input);
	}

}
