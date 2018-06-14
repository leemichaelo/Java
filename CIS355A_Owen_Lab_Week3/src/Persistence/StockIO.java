package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Buisness.Stock;

public class StockIO {

	public static void write() {
		try {
			//create the file object and "open" the file
			BufferedWriter outfile = new BufferedWriter(new FileWriter ("C://Users//LeeMi//OneDrive//Documents//Devry//CIS355A(Java)//Week5Files/data.txt"));
			ArrayList<Stock> writeStock = new ArrayList<Stock>();
			writeStock = Stock.returnArray();
			//write data to the file
			for (Stock s: writeStock) {
                outfile.write(s.getCompanyName());
                outfile.write("#" + s.getNumOfShares());  
                outfile.write("#" + s.getPurchasePrice());
                outfile.write("#" + s.getCurrentPrice());
                outfile.newLine();  //"enter" key
			}
			//close the file
			outfile.close();
		}
		catch (IOException e) {
			System.err.println("Input Error " + e.toString());
		}

}
	public static void read() {
		ArrayList<Stock> readStock = new ArrayList<Stock>();
		try {
		BufferedReader infile = new BufferedReader(new FileReader("C://Users//LeeMi//OneDrive//Documents//Devry//CIS355A(Java)//Week5Files/data.txt"));
		String inputString = "";
		StringTokenizer tokens;
		System.out.println("Reading the File");
		//get first line
		inputString = infile.readLine();
		// not EOF
		while (inputString != null) {
			System.out.println(inputString); //echo to console
			//break the line into pieces
			tokens = new StringTokenizer(inputString, "#");
			//fields are CompanyName#NumOfShares#PurchasePrice#CurrentPrice
			String companyName = tokens.nextToken();
			int numOfShares = Integer.parseInt(tokens.nextToken());
			double purchasePrice = Double.parseDouble(tokens.nextToken());
			double currentPrice = Double.parseDouble(tokens.nextToken());
			//create stock object
			Stock newStock = new Stock(companyName, numOfShares, purchasePrice, currentPrice);
			readStock.add(newStock);
			//read next line
			inputString = infile.readLine();
		}
		infile.close();
		}
		catch (Exception e) {
			System.err.println("Input Error " + e.toString());
		}
		Stock.setArray(readStock);;
	}

}
