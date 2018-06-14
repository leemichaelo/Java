package Week3_Buisness;

import java.util.ArrayList;

public class OrderManager {
	
	// initialize array
	private ArrayList<Order> orderList;
	
	// create new array
	public OrderManager() {
		orderList = new ArrayList<Order>();
	}

	// add order to array
	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	// set getter
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public int getTotalCost () {
		int totalCost = 0;		
		for (Order currentOrder : this.getOrderList()) {
			totalCost += currentOrder.getCost();
		}
		return totalCost;
	}
}
