/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A Week 6 Lab // Date: Aug 2017 
 * Description: Creates window for studentkGui
 * Input: Student Name, and three grades
 * Output: Displays student info to the console
*******************************************************************************/

package Presentation_W6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Buisness_W6.student;
import Persistence_W6.StudentDB;

public class studentGUI extends JFrame implements ActionListener {

	private JLabel nameLabel, testOne, testTwo, testThree;
	private JTextField nameTF, oneTF, twoTF, threeTF;
	private JButton btnAddS, btnDisplayA;

	public studentGUI(String string) {
		// Create Frame
		setTitle(string);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		// Create and add JLabels
		nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(120, 10, 65, 25);
		getContentPane().add(nameLabel);

		testOne = new JLabel("Test One");
		testOne.setHorizontalAlignment(SwingConstants.CENTER);
		testOne.setBounds(120, 60, 65, 25);
		getContentPane().add(testOne);

		testTwo = new JLabel("Test Two");
		testTwo.setHorizontalAlignment(SwingConstants.CENTER);
		testTwo.setBounds(120, 110, 65, 25);
		getContentPane().add(testTwo);

		testThree = new JLabel("Test Three");
		testThree.setHorizontalAlignment(SwingConstants.CENTER);
		testThree.setBounds(120, 170, 65, 25);
		getContentPane().add(testThree);

		// Create and add JTextFields
		nameTF = new JTextField();
		nameTF.setBounds(243, 7, 176, 30);
		getContentPane().add(nameTF);
		nameTF.setColumns(10);

		oneTF = new JTextField();
		oneTF.setBounds(243, 57, 176, 30);
		getContentPane().add(oneTF);
		oneTF.setColumns(10);

		twoTF = new JTextField();
		twoTF.setBounds(243, 107, 176, 30);
		getContentPane().add(twoTF);
		twoTF.setColumns(10);

		threeTF = new JTextField();
		threeTF.setText("");
		threeTF.setBounds(244, 167, 175, 30);
		getContentPane().add(threeTF);
		threeTF.setColumns(10);

		btnAddS = new JButton("Add Student");
		btnAddS.setBounds(10, 227, 175, 30);
		getContentPane().add(btnAddS);

		btnDisplayA = new JButton("Display All");
		btnDisplayA.setBounds(244, 227, 175, 30);
		getContentPane().add(btnDisplayA);

		// Add Action Listeners
		btnAddS.addActionListener(this);
		btnDisplayA.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAddS) {
			String sName = nameTF.getText();
			int gOne = Integer.parseInt(oneTF.getText());
			int gTwo = Integer.parseInt(twoTF.getText());
			int gThree = Integer.parseInt(threeTF.getText());
			StudentDB.add(sName, gOne, gTwo, gThree);
		}
		if (event.getSource() == btnDisplayA) {
			ArrayList<student> allStudents = StudentDB.allStudents();
			System.out.println("Name		" + "Test One	" + "Test Two	" + "Test Three	" + "Avg	" + "Grade");
			for (student s : allStudents) {
				int gOne = s.getGradeOne();
				int gTwo = s.getGradeTwo();
				int gThree = s.getGradeThree();
				double gpa = s.gpa(gOne, gTwo, gThree);
				System.out.println(
						s.toString() + "	" + gOne + "		" + gTwo + "		" + gThree + "		" + gpa + "     " + s.letterGrade(gpa));
			}

		}

	}
}
