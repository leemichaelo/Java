package lab2_presentation;
/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week2 // Date: July 2017 
 * Description: Creates window for HealthProfile
 * Input: Age, Weight, Height
 * Output: Prints the users HealthProfile
*******************************************************************************/
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lab1.HealthProfile;

public class HealthProfileGUI extends JFrame implements ActionListener {
	// GUI components
	private JTextField nameField, ageField, heightFTField, heightINField, weightField, bmiField, categoryField,
			mhrField;
	private JLabel nameLabel, ageLabel, heightFTLabel, heightINLabel, weightLabel, bmiLabel, categoryLabel, mhrLabel;
	private JButton btnCalc, btnClear;

	// Constructor builds the GUI
	public HealthProfileGUI(String title) throws HeadlessException {
		super(title);
		// window setup
		this.setSize(600, 600); // dimensions of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program when x is selected

		// instantiate components
		nameField = new JTextField(10);
		nameLabel = new JLabel("Name:");
		ageField = new JTextField(10);
		ageLabel = new JLabel("Age:");
		heightFTField = new JTextField(10);
		heightFTLabel = new JLabel("Hieght in Feet:");
		heightINField = new JTextField(10);
		heightINLabel = new JLabel("Height in Inches:");
		weightField = new JTextField(10);
		weightLabel = new JLabel("Weight in Pounds:");
		btnCalc = new JButton("Display");
		btnClear = new JButton("Clear");
		bmiField = new JTextField(10);
		bmiLabel = new JLabel("BMI:");
		categoryField = new JTextField(10);
		categoryLabel = new JLabel("Category:");
		mhrField = new JTextField(10);
		mhrLabel = new JLabel("Max Heart Rate:");
		
		//register action listeners
		btnCalc.addActionListener(this);
		btnClear.addActionListener(this);
		
		// set window layout
		setLayout(new GridLayout(0, 2, 10, 10));

		// add components to window
		this.getContentPane().add(nameLabel);
		this.getContentPane().add(nameField);
		this.getContentPane().add(ageLabel);
		this.getContentPane().add(ageField);
		this.getContentPane().add(heightFTLabel);
		this.getContentPane().add(heightFTField);
		this.getContentPane().add(heightINLabel);
		this.getContentPane().add(heightINField);
		this.getContentPane().add(weightLabel);
		this.getContentPane().add(weightField);
		this.getContentPane().add(btnCalc);
		this.getContentPane().add(btnClear);
		this.getContentPane().add(bmiLabel);
		this.getContentPane().add(bmiField);
		this.getContentPane().add(categoryLabel);
		this.getContentPane().add(categoryField);
		this.getContentPane().add(mhrLabel);
		this.getContentPane().add(mhrField);
		
	}// ends constructor

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCalc) {
			//age, height, weight
			String name = nameField.getText();
			int age = Integer.parseInt(ageField.getText());
			Double heightFT = Double.parseDouble(heightFTField.getText());
			Double heightIN = Double.parseDouble(heightINField.getText());
			double weight = Double.parseDouble(weightField.getText());			
			//make profile object
			 HealthProfile newProfile = new HealthProfile(name, age, weight, heightFT, heightIN );
			//calculate BMI
			double bmi = newProfile.getBMI();
			String category = newProfile.getCategory();
			double mhr = newProfile.getMaxHR();
			//display info
			bmiField.setText(String.valueOf(bmi));
			categoryField.setText(String.valueOf(category));
			mhrField.setText(String.valueOf(mhr));
		}
		else if(event.getSource() == btnClear) {
			nameField.setText(null);
			ageField.setText(null);
			heightFTField.setText(null);
			heightINField.setText(null);
			weightField.setText(null);
			bmiField.setText(null);
			categoryField.setText(null);
			mhrField.setText(null);
		}
	}

}// end HealthProfileGUI
