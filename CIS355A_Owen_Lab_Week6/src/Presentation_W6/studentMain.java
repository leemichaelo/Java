/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A Week 6 Lab // Date: Aug 2017  
 * Description: Main for the program
*******************************************************************************/
package Presentation_W6;

import java.awt.EventQueue;

public class studentMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentGUI frame = new studentGUI("Students");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
