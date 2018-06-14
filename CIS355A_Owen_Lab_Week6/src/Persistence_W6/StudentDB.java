/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A Week 6 Lab // Date: Aug 2017 
 * Description: Create a StudentDB class that is used to create a connection 
 * and interface with the database.
 * Methods: getAll—reads data from database, returns data in an arraylist of 
 * student objects and add—writes a record to the database
*******************************************************************************/

package Persistence_W6;
import Buisness_W6.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDB {

	public static void add(String sName, int gOne, int gTwo, int gThree) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=StudentDB;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		PreparedStatement insertStmt;
		String insertQuery = "INSERT INTO StudentGrades (sName, gradeOne, gradeTwo, gradeThree) VALUES (?,?,?,?)";
		ResultSet rs = null;
		// Establish the connection.
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(connectionUrl);

			// Create variables to insert
			String inSName = sName;
			int inGOne = gOne;
			int inGTwo = gTwo;
			int inGThree = gThree;
			insertStmt = con.prepareStatement(insertQuery);

			// fill in the blanks of the query with user data
			insertStmt.setString(1, inSName);
			insertStmt.setInt(2, inGOne);
			insertStmt.setInt(3, inGTwo);
			insertStmt.setInt(4, inGThree);

			// Execute insert statement
			insertStmt.execute();
			System.out.println("New Row Added");

			// now display all rows in table
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from studentGrades");
			while (rs.next()) {
				System.out.println(rs.getString("sName") + " " + rs.getInt("gradeOne") + " " + rs.getInt("gradeTwo")
						+ " " + rs.getInt("gradeThree"));

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

	public static ArrayList<student> allStudents() {
		ArrayList<student> allStudents = new ArrayList<student>();
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=StudentDB;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			// now display all rows in table
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from studentGrades");
			while (rs.next()) {
				String sName = rs.getString("sName");
				int gOne = rs.getInt("gradeOne");
				int gTwo = rs.getInt("gradeTwo");
				;
				int gThree = rs.getInt("gradeThree");
				;
				student currentStudent = new student(sName, gOne, gTwo, gThree);
				allStudents.add(currentStudent);
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
		return allStudents;
	}
}
