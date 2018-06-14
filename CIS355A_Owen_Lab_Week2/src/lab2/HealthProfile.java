package lab2;
/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week1 // Date: July 2017 
 * Description: Stores information about clients and their fitness data.
 * Input: Age, Weight, Height
 * Output: Prints the users HealthProfile
*******************************************************************************/
 public class HealthProfile {
	private String name;
	private int age;
	private double weight;
	private double heightFT;
	private double heightIN;
	
	//Constructor that initializes an empty HealthProfile
	public HealthProfile() {
		age = 0;
		weight = 0;
		heightFT = 0;
		heightIN = 0;
	}
	
	//Constructor that initializes a HealthProfile based on user input
	public HealthProfile(String userName, int userAge, double userWeight, double userHeightFT, double userHeightIN) {
		name = userName;
		age = userAge;
		weight = userWeight;
		heightFT = userHeightFT;
		heightIN = userHeightIN;
		}
	
	//Class Setters
	public void setName(String userName) {
		name = userName;
	}
	
	public void setAge(int userAge) {
		age = userAge;
	}
	
	public void setWeight(double userWeight) {
		weight = userWeight;
	}
	
	public void setHeightFT(double userHeightFT) {
		heightFT = userHeightFT;
	}
	
	public void setHeightIN(double userHeightIN) {
		heightIN = userHeightIN;
	}
	
	//Class Getters
	public String getName() {
	return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}

	public double getHeightFT() {
		return heightFT;
	}
	
	public double getHeightIN() {
		return heightIN;
	}
	
	//Class Functions
	public double getBMI() {
		double BMI = (weight*703)/(Math.pow((heightFT*12)+heightIN, 2));
		BMI = Math.round(BMI * 10d) / 10d;
		return BMI;
	}
	
	public String getCategory() {
		String category = "";
		if (getBMI() < 18.5) {
			category = "Underweight";
		}
		else if (getBMI() < 25) {
			category = "Normal";
		}
		else if (getBMI() < 30) {
			category = "Overweight";
		}
		else 
			category = "Obese";
		return category;
	}
	
	public int getMaxHR() {
		return 200 - age;
	}
	
}
