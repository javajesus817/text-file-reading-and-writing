/* Created by: James McCoy
 * Created on: 12/14/19
 * Version: 1.0
 * */

package com.files.main;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentApp {
	static File file, file1, file2, file3;
	static String location = "C:\\Users\\James\\Desktop";
	static String fileName = "\\students.csv";
	static String fileName1 = "\\names.text";
	static String fileName2 = "\\grades.text";
	static String fileName3 = "\\gpas.text";
	static String abstractFilePath = location + fileName;
	static String abstractFilePath1 = location + fileName1;
	static String abstractFilePath2 = location + fileName2;
	static String abstractFilePath3 = location + fileName3;
	static FileWriter writer, writer1, writer2, writer3;
	static Scanner sc;
	static Student[] studentArray;
	static final int TOTALSTUDENTS = 10;
	static ArrayList<String> lines;

	public static void main(String[] args) {

		//To create a new file if it doesn't exist, validate if does exist
		createNewFiles();
		System.out.println();
		
		//To create student objects to be written into text files
		Student studentJames = new Student("James", 12, 4.0);
		Student studentMike = new Student("Mike", 9, 3.4);
		Student studentMalcolm = new Student("Malcolm", 10, 3.6);
		Student studentJerome = new Student("Jerome", 10, 3.8);
		Student studentBrett = new Student("Brett", 12, 2.1);
		Student studentScott = new Student("Scott", 9, 2.4);
		Student studentDontrelle = new Student("Dontrelle", 11, 3.9);
		Student studentRodney = new Student("Rodney", 9, 4.0);
		Student studentTravis = new Student("Travis", 12, 3.2);
		Student studentBilly = new Student("Billy", 11, 2.9);

		//To write within the 3 created files
		writerToFile(studentJames);
		writerToFile(studentMike);
		writerToFile(studentMalcolm);
		writerToFile(studentJerome);
		writerToFile(studentBrett);
		writerToFile(studentScott);
		writerToFile(studentDontrelle);
		writerToFile(studentRodney);
		writerToFile(studentTravis);
		writerToFile(studentBilly);
		
		//To create arrays for each student property
		String[] namesToArrays = new String[10];
		Integer[] gradeToArrays = new Integer[10];
		Double[] gpaToArrays = new Double[10];
		namesToArrays = storeNamesToArrays(file1);
		gradeToArrays = storeGradeToArray(file2);
		gpaToArrays = storeGpaToArray(file3);
		
		//To read the above arrays
//		for(int i = 0; i < 10; i++) {
//			System.out.println(namesToArrays[i]);
//			System.out.println(gradeToArrays[i]);
//			System.out.println(gpaToArrays[i]);
//		}
		
		//To create an array of Student objects
		studentArray = new Student[10];
		for(int i = 0; i < studentArray.length; i++) {
			studentArray[i] = new Student();
			studentArray[i].setName(namesToArrays[i]);
			studentArray[i].setGrade(gradeToArrays[i]);
			studentArray[i].setGpa(gpaToArrays[i]);
			studentArray[i].getInfo();
		}
		System.out.println();
		
		//To create a new CSV file
		createNewCSVFile();
		
		//To write into CSV file
		writerToCSVFile(studentJames);
		writerToCSVFile(studentMike);
		writerToCSVFile(studentMalcolm);
		writerToCSVFile(studentJerome);
		writerToCSVFile(studentBrett);
		writerToCSVFile(studentScott);
		writerToCSVFile(studentDontrelle);
		writerToCSVFile(studentRodney);
		writerToCSVFile(studentTravis);
		writerToCSVFile(studentBilly);
		
		//To read CSV file
//		readCSVFile();
		
		//To create an array of objects using data from CSV file
		moveCSVTextToArray();
		
		
	}
	
	protected static void moveCSVTextToArray() {
		try {
			file = new File(abstractFilePath);
			sc = new Scanner(file);
			ArrayList<String[]> studentData = new ArrayList<String[]>();
			String line;
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				studentData.add(line.split(","));
			}
			
			Student student;
			int counter = 0;
			
			for(String[] read : studentData) {
				student = new Student();
				student.setName(read[0]);
				student.setGrade(Integer.parseInt(read[1]));
				student.setGpa(Double.parseDouble(read[2]));
				studentArray[counter] = new Student();
				studentArray[counter].setName(student.getName());
				studentArray[counter].setGrade(student.getGrade());
				studentArray[counter].setGpa(student.getGpa());
				studentArray[counter].getInfo();
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void readCSVFile() {
		try {
			file = new File(abstractFilePath);
			sc = new Scanner(file);
			lines = new ArrayList<String>();
			
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			
			for(String students : lines) {
				System.out.println(students);
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void createNewCSVFile() {
		try{
			file = new File(abstractFilePath);
			if(file.createNewFile()) {
				System.out.println("File 'students.csv' has been created");
			} else {
				System.out.println("File 'students.csv' has already been created");
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void createNewFiles() {
		try {
			file1 = new File(abstractFilePath1);
			file2 = new File(abstractFilePath2);
			file3 = new File(abstractFilePath3);
			
			if(file1.createNewFile()) {
				System.out.println("File 'names.txt' has been created");
			} else {
				System.out.println("File 'names.txt' has already been created");
			}
			
			if(file2.createNewFile()) {
				System.out.println("File 'grades.txt' has been created");
			} else {
				System.out.println("File 'grades.txt' has already been created");
			}
			
			if (file3.createNewFile()) {
				System.out.println("File 'gpas.txt' has been created");
			} else {
				System.out.println("File 'gpas.txt' has already been created");
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void writerToCSVFile(Student object) {
		try {
			writer = new FileWriter(abstractFilePath, true);
			writer.write(object.getName() + "," + object.getGrade() + "," + object.getGpa() + "\n");
			writer.close();
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static void writerToFile(Student object) {
		try{
			writer1 = new FileWriter(abstractFilePath1, true);
			writer2 = new FileWriter(abstractFilePath2, true);
			writer3 = new FileWriter(abstractFilePath3, true);
			writer1.write(object.getName() + "\n");
			writer2.write(object.getGrade() + "\n");
			writer3.write(object.getGpa() + "\n");
			writer1.close();
			writer2.close();
			writer3.close();
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	protected static String[] storeNamesToArrays(File file) {
		int i;
		String[] namesArray = new String [10];
		try {
			sc = new Scanner(file);
			for(i = 0; i < namesArray.length; i++) {
				namesArray[i] = sc.next();
//				System.out.println(namesArray[i]);
			}

		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return namesArray;
	}
	
	protected static Integer[] storeGradeToArray(File file) {
		int i;
		Integer[] gradeArray = new Integer[10];
		try {
			sc = new Scanner(file);
			
			for(i = 0; i < gradeArray.length; i++) {
				gradeArray[i] = sc.nextInt();
//				System.out.println(gradeArray[i]);
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return gradeArray;
	}
	
	protected static Double[] storeGpaToArray(File file) {
		int i;
		Double[] gpaArray = new Double[10];
		try{
			sc = new Scanner(file);
			
			
			for(i = 0; i < gpaArray.length; i++) {
				gpaArray[i] = sc.nextDouble();
//				System.out.println(gpaArray[i]);
			}
			
		} catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return gpaArray;
	}

}
