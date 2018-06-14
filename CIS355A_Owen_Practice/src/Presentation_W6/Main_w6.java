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

import java.awt.EventQueue;

public class Main_w6 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contactGUI frame = new contactGUI("Contacts");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
