/* Created by: James McCoy
 * Created on: 12/14/19
 * Version: 1.0
 * */

package com.files.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingMultipleFiles {
	static String location = "C:\\Users\\James\\Desktop";
	static String fileName1 = "\\courseCode.txt";
	static String fileName2 = "\\courseName.txt";
	static String abstractFilePath1 = location + fileName1;
	static String abstractFilePath2 = location + fileName2;
	static File file1, file2;
	static Scanner sc1;
	static Scanner sc2;
	static ArrayList<String> lines;
	static int i;

	public static void main(String[] args) {
		readMultipleFiles();
	}
	
	protected static void readMultipleFiles() {
		try {
			file1 = new File(abstractFilePath1);
			file2 = new File(abstractFilePath2);
			sc1 = new Scanner(file1);
			sc2 = new Scanner(file2);
			lines = new ArrayList<String>();
			while(sc1.hasNextLine() || sc2.hasNextLine()) {
				lines.add(sc1.nextLine());
				lines.add(sc2.nextLine());
				}
			for(i = 0; i < lines.size(); i++) {
				System.out.printf("%-5s|",lines.get(i));
				if((i % 2) != 0) {
					System.out.println();
				}
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

}
