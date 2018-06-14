package Week_4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessTheNumberGUI extends JFrame implements ActionListener {

	private JLabel guessIt, numLeft, result;
	private JTextField userInput;
	private JButton guessBtn, clearBtn;
	private int guessesLeft = 10;
	private String resultText = "";
	private int theNumber = 1 + (int) (Math.random() * 1000);

	public GuessTheNumberGUI(String title) throws HeadlessException {
		super(title);
		// set the size
		this.setSize(600, 600);

		// set the position
		Dimension screenSize = this.getToolkit().getScreenSize();
		double screen_W = (screenSize.width / 2) - 300;
		double screen_H = (screenSize.height / 2) - 300;

		this.setLocation((int) screen_W, (int) screen_H);

		// set the close operation
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// make panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		this.getContentPane().add(mainPanel);

		// initiate components
		guessIt = new JLabel("Im thining of a number between 1 and 1000. Guess it!");
		userInput = new JTextField(10);
		numLeft = new JLabel("Guesses left: " + guessesLeft);
		result = new JLabel(resultText);
		guessBtn = new JButton("Guess it!");
		clearBtn = new JButton("Start Over!");

		// register action listeners
		guessBtn.addActionListener(this);
		clearBtn.addActionListener(this);

		// set window layout
		setLayout(new FlowLayout(0, 2, 10));

		// add components to window
		this.getContentPane().add(guessIt);
		this.getContentPane().add(userInput);
		this.getContentPane().add(numLeft);
		this.getContentPane().add(result);
		this.getContentPane().add(guessBtn);
		this.getContentPane().add(clearBtn);

	}// ends constructor

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == guessBtn) {
			int whatsTheGuess = Integer.parseInt(userInput.getText());
			if (guessesLeft > 1) {
				if (whatsTheGuess == theNumber) {
					result.setText("Correct!");
				} else if (whatsTheGuess > theNumber) {
					result.setText("Too High!");
					guessesLeft -= 1;
					numLeft.setText("Guesses left: " + guessesLeft);
				} else if (whatsTheGuess < theNumber) {
					result.setText("Too Low!");
					guessesLeft -= 1;
					numLeft.setText("Guesses left: " + guessesLeft);
				}
			} else
				result.setText("You lost, select Start Over to go again!");
		}
		if (event.getSource() == clearBtn) {
			theNumber = 1 + (int) (Math.random() * 1000);
			guessesLeft = 10;
			numLeft.setText("Guesses left: " + guessesLeft);
			result.setText("");
		}
	}
}
