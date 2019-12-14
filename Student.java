/* Created by: James McCoy
 * Created on: 12/14/19
 * Version: 1.0
 * */

package com.files.main;


public class Student {
	private String name;
	private Integer grade;
	private Double gpa;
	
	public Student() {
		
	}
	
	public Student(String name, Integer grade, Double gpa) {
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Integer getGrade () {
		return grade;
	}

	protected void setGrade (Integer grade) {
		this.grade = grade;
	}

	protected double getGpa() {
		return gpa;
	}

	protected void setGpa (Double gpa) {
		this.gpa = gpa;
	}
	
	protected void getInfo() {
		
		System.out.println("Hi my name is " + name + ". I'm in grade " + grade + " and I have a " + gpa + " GPA. For now, at least...");
	}

}
