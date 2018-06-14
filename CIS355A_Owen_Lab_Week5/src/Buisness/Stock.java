package Buisness;

import java.util.ArrayList;

/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week5 // Date: July 2017 Description:
 * Creates Object for Stock Input: Takes in user input fromt he GUI to create a
 * Stock Object Output: Returns the ROI of the stock and the name of the stock
 *******************************************************************************/

public class Stock {
	private String companyName;
	private int numOfShares;
	private double purchasePrice;
	private double currentPrice;
	private static ArrayList<Stock> stockList = new ArrayList<>();

	// Default Constructor
	public Stock() {
		super();
		this.companyName = "Blank";
		this.numOfShares = 0;
		this.purchasePrice = 0;
		this.currentPrice = 0;
	}

	// Constructor
	public Stock(String companyName, int numOfShares, double purchasePrice, double currentPrice) {
		super();
		this.companyName = companyName;
		this.numOfShares = numOfShares;
		this.purchasePrice = purchasePrice;
		this.currentPrice = currentPrice;
	}

	public String ROI() {
		String ROI = "";
		double numROI = this.numOfShares * (this.currentPrice - this.purchasePrice);
		if (numROI < this.purchasePrice) {
			ROI = "Loss of " + numROI;
		} else if (numROI > this.purchasePrice) {
			ROI = "Profit of " + numROI;
		} else
			ROI = "No Profit or Loss";
		return ROI;
	}

	public static void addStock(Stock stock) {
		stockList.add(stock);
	}

	public static void removeStock(int item) {
		stockList.remove(item);
	}

	public static ArrayList returnArray() {
		return stockList;
	}

	public static void setArray(ArrayList newList) {
		stockList = newList;
	}

	public String toString() {
		return companyName + ": " + numOfShares + " shares";
	}

	// Getters and Setters
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getNumOfShares() {
		return numOfShares;
	}

	public void setNumOfShares(int numOfShares) {
		this.numOfShares = numOfShares;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	};

}
