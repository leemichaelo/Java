/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A Week 6 Lab // Date: Aug 2017 
 * Description: Create a Student class to manage the student data.
 * Input: Student name and three test scores.
 * Output: A get method to calculate and return the average,
 * A get method to calculate and return the letter grade, toString to 
 * display the name of the student .
*******************************************************************************/

package Buisness_W6;

public class student {
	private String sName;
	private int gradeOne;
	private int gradeTwo;
	private int gradeThree;

	// Constructor
	public student(String sName, int gradeOne, int gradeTwo, int gradeThree) {
		this.sName = sName;
		this.gradeOne = gradeOne;
		this.gradeTwo = gradeTwo;
		this.gradeThree = gradeThree;
	}

	// Default Constructor
	public student() {
		this.sName = null;
		this.gradeOne = 0;
		this.gradeTwo = 0;
		this.gradeThree = 0;
		// TODO Auto-generated constructor stub
	}

	//Calculates GPA
	public double gpa(int gOne, int gTwo, int gThree) {
		double gpa = 0;

		gpa += (gOne + gTwo + gThree) / 3;

		return gpa;
	}

	//Determines letter grade
	public char letterGrade(double gpa) {
		char letterGrade = 'n';
		if (gpa >= 90) {
			letterGrade = 'A';
		} else if (gpa >= 80 && gpa < 90) {
			letterGrade = 'B';
		} else if (gpa >= 70 && gpa < 80) {
			letterGrade = 'C';
		} else if (gpa >= 60 && gpa < 70) {
			letterGrade = 'D';
		} else
			letterGrade = 'F';
		return letterGrade;
	}

	//Modifies toString to display students name
	public String toString() {
		return sName;
	}
	// Getters
	public String getsName() {
		return sName;
	}

	public int getGradeOne() {
		return gradeOne;
	}

	public int getGradeTwo() {
		return gradeTwo;
	}

	public int getGradeThree() {
		return gradeThree;
	}

	// Setters
	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setGradeOne(int gradeOne) {
		this.gradeOne = gradeOne;
	}

	public void setGradeTwo(int gradeTwo) {
		this.gradeTwo = gradeTwo;
	}

	public void setGradeThree(int gradeThree) {
		this.gradeThree = gradeThree;
	}
}
