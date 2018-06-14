package lab1;
/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week1 // Date: July 2017 
 * Description: Stores information about clients and their fitness data.
 * Input: Age, Weight, Height
 * Output: Prints the users HealthProfile
*******************************************************************************/
import java.util.Scanner;

public class Lab1Main {
	public static Scanner userString = new Scanner( System.in );
	public static Scanner userInt = new Scanner( System.in );
	public static Scanner userDouble = new Scanner( System.in );
	 
	public static void main( String[] args ) {
		String name;
		int age;
		double weight;
		double heightFT;
		double heightIN;
		
		 do {
			 System.out.print("Enter name or X to quit: ");
			 name = userString.next();
			 System.out.print("Your age: ");
			 age = userInt.nextInt();
			 System.out.print("Your weight: ");
			 weight = userDouble.nextDouble();
			 System.out.print("Your height - feet: ");
			 heightFT = userDouble.nextDouble();
			 System.out.print("Your height - inches: ");
			 heightIN = userDouble.nextDouble();
			 
			 HealthProfile newProfile = new HealthProfile(name, age, weight, heightFT, heightIN );
			 
			 System.out.println("\nHealth Profile for " + name);
			 System.out.println("BMI: " + newProfile.getBMI());
			 System.out.println("BMI Category: " + newProfile.getCategory());
			 System.out.println("Max Heart Rate: " + newProfile.getMaxHR()+"\n");
			 
		 }
		 while (!name.equalsIgnoreCase("x"));
	 }

}
