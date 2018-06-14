/*******************************************************************************
	 * Programmer: Lee-Michael Owen CIS355A Course Project // Date: Aug 2017 
	 * Description: Creates the GUI for Floors N More
	*******************************************************************************/
package Presentation_CP;

import Persistence_CP.floorsnmoreDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class floorsnmoreGUI extends JFrame implements ActionListener {
	private JFrame optionsFrame;
	private JTabbedPane tabbedPane;
	private JPanel customerInfo, orderInfo, orderHistory;
	private JLabel cNameLabel, cAddressLabel, fTypeLabel, fLengthLabel, fwidthLabel;
	private JTextField cNameField, cAddressField, fLengthField, fWidthField;
	private JLabel currentCostLabel;
	private JButton btnSaveCustomer, btnCalculateCost, btnSubmitOrder, btnUpdateOrderHistory;
	private JComboBox fTypeCBox;
	private JList orderList;

	public floorsnmoreGUI(String string) {
		// Create Frame
		setTitle(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		// Creates the Tabbed Pane for the Three Tabs
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 434, 250);
		getContentPane().add(tabbedPane);

		// Creates the Customer Panel
		customerInfo = new JPanel();
		tabbedPane.addTab("Customer Info", null, customerInfo, null);
		customerInfo.setLayout(null);

		// Creates the Customer Name Label and Field
		cNameLabel = new JLabel("Customer Name");
		cNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cNameLabel.setBounds(93, 60, 102, 14);
		customerInfo.add(cNameLabel);

		cNameField = new JTextField();
		cNameField.setBounds(205, 57, 139, 20);
		customerInfo.add(cNameField);
		cNameField.setColumns(10);

		// Creates the Customer Address Label, Field
		cAddressLabel = new JLabel("Customer Address");
		cAddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cAddressLabel.setBounds(56, 101, 139, 14);
		customerInfo.add(cAddressLabel);

		cAddressField = new JTextField();
		cAddressField.setBounds(205, 98, 139, 20);
		customerInfo.add(cAddressField);
		cAddressField.setColumns(10);

		// Creates the Save Button for the Customer Info
		btnSaveCustomer = new JButton("Save Customer");
		btnSaveCustomer.setBounds(141, 154, 147, 23);
		customerInfo.add(btnSaveCustomer);
		btnSaveCustomer.addActionListener(this);

		// Creates the Order Info Panel
		JPanel orderInfo = new JPanel();
		tabbedPane.addTab("Order Info", null, orderInfo, null);
		orderInfo.setLayout(null);

		// Creates the Label, Fields and Buttons
		fTypeLabel = new JLabel("Flooring Type");
		fTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fTypeLabel.setBounds(111, 48, 80, 20);
		orderInfo.add(fTypeLabel);

		// Floor and Width are used to calculate area
		fLengthLabel = new JLabel("Floor Length");
		fLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fLengthLabel.setBounds(111, 79, 80, 20);
		orderInfo.add(fLengthLabel);

		fwidthLabel = new JLabel("Floor Width");
		fwidthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fwidthLabel.setBounds(111, 110, 80, 20);
		orderInfo.add(fwidthLabel);

		fLengthField = new JTextField();
		fLengthField.setBounds(220, 80, 86, 20);
		orderInfo.add(fLengthField);
		fLengthField.setColumns(10);

		fWidthField = new JTextField();
		fWidthField.setBounds(220, 110, 86, 20);
		orderInfo.add(fWidthField);
		fWidthField.setColumns(10);

		btnCalculateCost = new JButton("Calculate Cost");
		btnCalculateCost.setBounds(29, 166, 134, 25);
		orderInfo.add(btnCalculateCost);
		btnCalculateCost.addActionListener(this);

		btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.setBounds(267, 166, 134, 25);
		orderInfo.add(btnSubmitOrder);
		btnSubmitOrder.addActionListener(this);

		String[] fTypeStrings = { "Wood", "Carpet" };
		fTypeCBox = new JComboBox(fTypeStrings);
		fTypeCBox.setBounds(220, 48, 86, 20);
		orderInfo.add(fTypeCBox);
		// Creates options for the JComboBox fTypeCBox
		fTypeCBox.addActionListener(this);

		currentCostLabel = new JLabel("");
		currentCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentCostLabel.setBounds(166, 166, 101, 25);
		orderInfo.add(currentCostLabel);

		// Creates Order History Panel
		orderHistory = new JPanel();
		tabbedPane.addTab("Order History", null, orderHistory, null);
		orderHistory.setLayout(null);

		btnUpdateOrderHistory = new JButton("Update Order History");
		btnUpdateOrderHistory.setBounds(112, 188, 190, 23);
		orderHistory.add(btnUpdateOrderHistory);

		// Creates the scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 409, 166);
		orderHistory.add(scrollPane);

		// Adds the JList to the scroll pane
		orderList = new JList();
		scrollPane.setViewportView(orderList);
		btnUpdateOrderHistory.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// adds actions to the j combo box for the floor type
		if (event.getSource() == fTypeCBox) {
			String floorType = (String) fTypeCBox.getSelectedItem();
			System.out.println(floorType);
		}
		// Navigates Customer to the floor specification tab
		if (event.getSource() == btnSaveCustomer) {
			tabbedPane.setSelectedIndex(1);
		}

		// Previews cost of the floor
		if (event.getSource() == btnCalculateCost) {
			double fLength = Double.parseDouble(fLengthField.getText());
			double fWidth = Double.parseDouble(fWidthField.getText());
			double fArea = fLength / fWidth;
			String floorType = (String) fTypeCBox.getSelectedItem();
			if (floorType.equals("Wood")) {
				currentCostLabel.setText("$" + fArea * 20);
			} else
				currentCostLabel.setText("$" + fArea * 10);
		}

		// Attempts to save the data to the sql table
		if (event.getSource() == btnSubmitOrder) {

			// validates that the name and address field are filled
			if (!cNameField.getText().trim().isEmpty() && !cAddressField.getText().trim().isEmpty()) {
				// Custom button text
				String cName = cNameField.getText();
				String cAddress = cAddressField.getText();
				double fLength = 0;
				double fWidth = 0;
				double fArea;
				double currentCost;

				// validates that the length and width fields have numeric values
				try {
					fLength = Double.parseDouble(fLengthField.getText());
					fWidth = Double.parseDouble(fWidthField.getText());
					fArea = fLength / fWidth;
					String floorType = (String) fTypeCBox.getSelectedItem();
					if (floorType.equals("Wood")) {
						currentCost = fArea * 20;
					} else
						currentCost = fArea * 10;
					Object[] options = { "Cancel", "Submit" };
					int n = JOptionPane.showOptionDialog(optionsFrame,
							"Please Verify Order Before Submission" + "\nCustomer Name: " + cName
									+ "\nCustomer Address: " + cAddress + "\nFloor Type: " + floorType
									+ "\nTotal Area: " + fArea + "\nTotal Cost: " + currentCost,
							"Order Verification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							options, options[1]);
					switch (n) {
					case 0:
						break;
					case 1:
						floorsnmoreDB.add(cName, cAddress, floorType, fArea, currentCost);
						break;
					}

					// error box if there are non numeric values in the length and width field
				} catch (NumberFormatException e) {
					JOptionPane.showConfirmDialog(null, "Please enter numbers only in the length and width fields.",
							"ERROR: Length and or Width Fields", JOptionPane.CANCEL_OPTION);
				}
			}

			// error box if there is no entry for the name and or address field
			else
				JOptionPane.showConfirmDialog(null, "Please enter information in all text fields.",
						"ERROR: Name and or Address Fields", JOptionPane.CANCEL_OPTION);

		}

		// refreshes the jlist to show the data in the sql table
		if (event.getSource() == btnUpdateOrderHistory) {
			// Create a variable for the connection string.
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=floorsNmore;integratedSecurity=true;";

			// Declare the JDBC objects.
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			DefaultListModel listModel = new DefaultListModel();
			try {
				// Establish the connection.
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl);
				// now display all rows in table
				stmt = con.createStatement();
				rs = stmt.executeQuery("Select * from orderInfo");
				while (rs.next()) {
					String cName = rs.getString("customerName");
					String cAddress = rs.getString("customerAddress");
					String fType = rs.getString("flooringType");
					double fArea = rs.getDouble("floorArea");
					double fCost = rs.getInt("floorCost");

					listModel.addElement("NAME: " + cName + "   ADDRESS: " + cAddress + "   FLOOR TYPE: " + fType
							+ "   FLOOR AREA: " + fArea + "   FLOOR COST: " + fCost);
				}
				con.close();
				orderList.setModel(listModel);
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
}
