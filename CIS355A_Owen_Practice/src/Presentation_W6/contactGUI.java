/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week6 // Date: Aug 2017 
 * Description: Make an address book application that stores your contacts in
 *  a database.
 * First, set up a database with at least one table for the contacts. The fields 
 * should include the contact's name, phone number, and email address.
 * Then create a JTabbedPane GUI with two tabs: an Add tab that lets the user 
 * enter the information for a contact and add it to the database, and a 
 * Display tab that shows all of the contacts in the database
*******************************************************************************/

package Presentation_W6;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class contactGUI extends JFrame implements ActionListener {
	private JLabel nameLabel, phoneLabel, emailLabel;
	private JTextField nameTextField, phoneTextField, emailTextField;
	private JPanel panel, panel_1;
	private JButton btnSaveContact, btnRefreshList;
	private JList contactList;

	public contactGUI(String title) {
		setTitle("Contacts");
		// Create Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		getContentPane().add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("New Contact", null, panel, null);
		panel.setLayout(null);

		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 11, 46, 14);
		panel.add(nameLabel);

		phoneLabel = new JLabel("Phone Number");
		phoneLabel.setBounds(10, 36, 115, 14);
		panel.add(phoneLabel);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 61, 46, 14);
		panel.add(emailLabel);

		nameTextField = new JTextField();
		nameTextField.setText("");
		nameTextField.setBounds(178, 8, 86, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		phoneTextField = new JTextField();
		phoneTextField.setText("");
		phoneTextField.setBounds(178, 33, 86, 20);
		panel.add(phoneTextField);
		phoneTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setText("");
		emailTextField.setBounds(178, 58, 86, 20);
		panel.add(emailTextField);
		emailTextField.setColumns(10);

		btnSaveContact = new JButton("Save Contact");
		btnSaveContact.addActionListener(this);

		btnSaveContact.setBounds(175, 152, 107, 23);
		panel.add(btnSaveContact);

		panel_1 = new JPanel();
		tabbedPane.addTab("Contact List", null, panel_1, null);
		panel_1.setLayout(null);

		btnRefreshList = new JButton("Refresh List");
		btnRefreshList.addActionListener(this);
		btnRefreshList.setBounds(164, 177, 89, 23);
		panel_1.add(btnRefreshList);
		
		contactList = new JList();
		contactList.setBounds(38, 11, 332, 152);
		panel_1.add(contactList);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSaveContact) {
			// Create a variable for the connection string.
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=contacts;integratedSecurity=true;";

			// Declare the JDBC objects.
			Connection con = null;
			Statement stmt = null;
			PreparedStatement insertStmt;
			String insertQuery = "INSERT INTO contactList (contact_Name, phone_Number, email_Address) VALUES (?,?,?)";
			ResultSet rs = null;

			try {
				// Establish the connection.
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl);

				// Create varabiales to insert
				String cName = nameTextField.getText().toString();
				String cPhone = phoneTextField.getText().toString();
				String cEmail = emailTextField.getText().toString();

				insertStmt = con.prepareStatement(insertQuery);
				// fill in the blanks of the query with user data
				insertStmt.setString(1, cName);
				insertStmt.setString(2, cPhone);
				insertStmt.setString(3, cEmail);
				// Execute insert statement
				insertStmt.execute();
				System.out.println("New Row Added");
				// now display all rows in table
				stmt = con.createStatement();
				rs = stmt.executeQuery("Select * from contactList");
				while (rs.next()) {
					System.out.println(rs.getString("contact_Name") + " " + rs.getString("phone_Number") + " "
							+ rs.getString("email_Address"));

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
		if (e.getSource() == btnRefreshList) {
			// Create a variable for the connection string.
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=contacts;integratedSecurity=true;";

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
			    DefaultListModel listModel = new DefaultListModel();
				rs = stmt.executeQuery("Select * from contactList");
				while (rs.next()) {
					listModel.addElement(rs.getString("contact_Name") + " " + rs.getString("phone_Number") + " "
							+ rs.getString("email_Address"));// I think you want get this field
				}

			contactList.setModel(listModel);
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
}
