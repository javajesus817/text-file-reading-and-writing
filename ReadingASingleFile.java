/* Created by: James McCoy
 * Created on: 12/14/19
 * Version: 1.0
 * */

package com.files.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingASingleFile {
	static File file;
	static String location = "C:\\Users\\James\\Desktop";
	static String fileName = "\\hello.txt";
	static String fileAbstractName = location + fileName;
	static Scanner sc;
	static ArrayList<String> lines;
	static int i;
	static FileWriter writer;

	public static void main(String[] args) throws IOException {
		createNewFile();
//		writeToFile();
		readFile();
		readFileBackwards(); 
		sc.close();
	}
	
	protected static void createNewFile() {
		try {
			file = new File(fileAbstractName);
			
			if(file.createNewFile()) {
				System.out.println("File has been created");
			} else {
				System.out.println("Text below: ");
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void writeToFile() {
		try {
			writer = new FileWriter(fileAbstractName, false);
			writer.write("Hello" + "\nWorld");
			writer.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void readFile() {
		try {
			sc = new Scanner(file);
			lines = new ArrayList<String>();
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			for(String readLines : lines) {
				System.out.println(readLines);
			}
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void readFileBackwards() {
		try {
			sc = new Scanner(file);
			lines = new ArrayList<String>();
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			for(i = lines.size() - 1; i >= 0; i--) {
				System.out.println(lines.get(i));
			}
		} catch (Exception e) {
			
		}
	}

}
