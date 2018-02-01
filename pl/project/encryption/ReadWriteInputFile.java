package pl.project.encryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteInputFile {

	/**
	 * Function reads text file into String
	 * 
	 * @return text file as String
	 * @param no additional parameters required
	 *            
	 * 
	 */

	public String usingBufferedReader() {

		Scanner scan = new Scanner(System.in);

		System.out.println("NOTE: Make sure that your text file is encoded in 'UTF-8'\n"
				+ "Make sure that your text file is in your working directory.\nOnly '*.txt' files are valid.\n"
				+ "Type full file name:");

		BufferedReader reader=null;
		String fileName="";
		boolean loopBool=false;
		String path = System.getProperty("user.dir");
		
		
		while(!loopBool) {
			try {
				fileName = scan.next();
				String complFileName = path + File.separator + fileName;
				reader = new BufferedReader(new FileReader(complFileName ));
				break;
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found :-(. Try again:");
			}	
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (IOException e) {
			System.out.println("Your input file seems to be empty.");

		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("Cannot close file reader.");

		}

		String content = stringBuilder.toString();

		return content;
	}


	public void writeEncodedString(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type file name for encoded/decoded message:");
		String fileName = scan.nextLine();

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(msg);
			writer.close();
			System.out.println("File " + fileName + " has been created.");
		} catch (IOException e) {
			System.out.println("Something went wrong...");
		}

	}

}
