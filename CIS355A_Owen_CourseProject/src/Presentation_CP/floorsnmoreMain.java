/*******************************************************************************
	 * Programmer: Lee-Michael Owen CIS355A Course Project // Date: Aug 2017 
	 * Description: Initiates the Floors n More Program
	*******************************************************************************/
package Presentation_CP;

import java.awt.EventQueue;

public class floorsnmoreMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					floorsnmoreGUI frame = new floorsnmoreGUI("Floors N Moore");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
