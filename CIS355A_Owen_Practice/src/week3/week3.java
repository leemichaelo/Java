package week3;

import java.util.Scanner;

/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week3 // Date: July 2017 Description:
 * Write a program to simulate the rolling of two six-sided dice. The program
 * will work by generating two random numbers, each in the range of 1 to 6, to
 * represent the two dice. The sum of the two values should then be calculated.
 * Use a loop to roll the dice millions of times and use a one-dimensional array
 * to keep a count of how many times each sum appears. Input: None Output: How
 * many times each sum appears.
 *******************************************************************************/
public class week3 {

	public static void main(String[] args) {
		
		System.out.println("This program will roll a pair of die and record"
				+ " the result of each roll for as many times as the user "
				+ "specifices.");
		int[] counts = new int[13];
		Scanner userInput = new Scanner(System.in);
		System.out.println("\nHow many times would you like to roll the Die?");
		int numOfRolls = userInput.nextInt();

		for (int i = 0; i < numOfRolls; i++) {
			int die1 = 1 + (int) (Math.random() * 6);

			int die2 = 1 + (int) (Math.random() * 6);

			int sum = die1 + die2;

			counts[sum]++;
		}
		System.out.println();
		for (int i = 0; i < 12; i++) {
			System.out.println((i + 1) + ": " + counts[i]);
		}
	}
}
