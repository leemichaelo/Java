/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A Week 5 Programming Practice // 
 * Date: Aug 2017 Description:
 * Write a program to display shapes and colors that the user specifies through a 
 * GUI. The GUI should contain a JPanel on which the shapes will be drawn. The 
 * program should allow the user to select a shape and a color using whatever GUI
 * components you think are appropriate. For example, in my version, I selected 
 * the shape and color from JComboBoxes, and then had a JButton to make the 
 * program draw the shape.
 *******************************************************************************/
package Week5;

import java.awt.EventQueue;

public class main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					week5 frame = new week5("Shapes");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
