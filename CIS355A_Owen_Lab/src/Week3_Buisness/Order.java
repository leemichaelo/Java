package Week3_Buisness;

public class Order {
	private String name;
	private String toppings;
	private double cost;

	public Order(int burgerType, String toppings, double cost, int quantity) {
		if (burgerType == 0) {
			this.name = "Single Burger";
		} else
			this.name = "Double Burger";
		this.toppings = toppings;
		this.cost = cost*quantity;
	}

	public String getName() {
		return name;
	}

	public String getToppings() {
		return toppings;
	}

	public double getCost() {
		return cost;
	}

}
