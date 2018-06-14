/*******************************************************************************
	 * Programmer: Lee-Michael Owen CIS355A Course Project // Date: Aug 2017 
	 * Description: Creates the customerOrder Object
	 * Methods: get/setters for the object as well ass the constructors
	*******************************************************************************/
package Buisness_CP;

public class customerOrders {

	private String customerName = null;
	private String customerAddress = null;
	private String flooringType = null;
	private double floorArea;
	private double floorCost;
	
	//Default Constructor
	public customerOrders() {
		customerName = "";
		customerAddress = "";
		flooringType = "";
		floorArea = 0;
		floorCost = 0;
	}
	
	//Constructor
	public customerOrders(String customerName, String customerAddress, String flooringType, double floorArea,
			double floorCost) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.flooringType = flooringType;
		this.floorArea = floorArea;
		this.floorCost = floorCost;
	}
	
	//Getters
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public String getFlooringType() {
		return flooringType;
	}
	public double getFloorArea() {
		return floorArea;
	}
	public double getFloorCost() {
		return floorCost;
	}
	
	//Setters
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void setFlooringType(String flooringType) {
		this.flooringType = flooringType;
	}
	public void setFloorArea(double floorArea) {
		this.floorArea = floorArea;
	}
	public void setFloorCost(double floorCost) {
		this.floorCost = floorCost;
	}

}
