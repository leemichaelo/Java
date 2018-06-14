/*******************************************************************************
	 * Programmer: Lee-Michael Owen CIS355A Course Project // Date: Aug 2017 
	 * Description: Create a StudentDB class that is used to create a connection 
	 * and interface with the database.
	 * Methods: getAll—reads data from database, returns data in an arraylist of 
	 * student objects and add—writes a record to the database
	*******************************************************************************/

package Persistence_CP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class floorsnmoreDB {

	// Adds Client data to the SQL Database
	public static void add(String customerName, String customerAddress, String flooringType, double floorArea,
			double floorCost) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=floorsNmore;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		PreparedStatement insertStmt;
		String insertQuery = "INSERT INTO orderInfo (customerName, customerAddress, flooringType, floorArea, floorCost) VALUES (?,?,?,?,?)";
		ResultSet rs = null;
		// Establish the connection.
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(connectionUrl);

			// Create variables to insert
			String inCName = customerName;
			String inCAddress = customerAddress;
			String inFType = flooringType;
			double inFArea = floorArea;
			double inFCost = floorCost;
			insertStmt = con.prepareStatement(insertQuery);

			// fill in the blanks of the query with user data
			insertStmt.setString(1, inCName);
			insertStmt.setString(2, inCAddress);
			insertStmt.setString(3, inFType);
			insertStmt.setDouble(4, inFArea);
			insertStmt.setDouble(5, inFCost);

			// Execute insert statement
			insertStmt.execute();
			System.out.println("New Row Added");

			// now display all rows in table
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from orderInfo");
			while (rs.next()) {
				System.out.println(rs.getString("customerName") + " " + rs.getString("customerAddress") + " "
						+ rs.getString("flooringType") + " " + rs.getDouble("floorArea") + rs.getDouble("floorCost"));

			}
			con.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Database error");
		}

		// Handle any errors that may have occurred.
		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception ex) {
				}
		}
	}

}