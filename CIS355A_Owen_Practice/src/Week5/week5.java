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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class week5 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCircle, mnSquare, mnTriangle;
	private JMenuItem redCircle, blueCircle, greenCircle, redSquare, blueSquare, greenSquare, redTriangle, blueTriangle,
			greenTriangle;
	private JLabel img;

	public week5(String title) {
		setTitle("Shapes");
		//Create Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Create Menu Bar
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		//Add Shape Options to the Menu Bar
		mnCircle = new JMenu("Circle");
		menuBar.add(mnCircle);
		mnSquare = new JMenu("Square");
		menuBar.add(mnSquare);
		mnTriangle = new JMenu("Triangle");
		menuBar.add(mnTriangle);
		
		//Add Color Options to the Circle Option
		redCircle = new JMenuItem("Red");
		mnCircle.add(redCircle);
		blueCircle = new JMenuItem("Blue");
		mnCircle.add(blueCircle);
		greenCircle = new JMenuItem("Green");
		mnCircle.add(greenCircle);
		
		//Add Color Options to the Square Option
		redSquare = new JMenuItem("Red");
		mnSquare.add(redSquare);	
		blueSquare = new JMenuItem("Blue");
		mnSquare.add(blueSquare);
		greenSquare = new JMenuItem("Green");
		mnSquare.add(greenSquare);
		
		//Add Color Options to the Triangle Option
		redTriangle = new JMenuItem("Red");
		mnTriangle.add(redTriangle);
		blueTriangle = new JMenuItem("Blue");
		mnTriangle.add(blueTriangle);
		greenTriangle = new JMenuItem("Green");
		mnTriangle.add(greenTriangle);
		
		//Add image label
		img = new JLabel("");
		img.setBounds(158, 74, 209, 130);
		contentPane.add(img);
		
		//Implements Circle Image actions
		redCircle.addActionListener(this);
		blueCircle.addActionListener(this);
		greenCircle.addActionListener(this);
		//Implements Square Image Actions
		redSquare.addActionListener(this);
		blueSquare.addActionListener(this);
		greenSquare.addActionListener(this);
		//Implements Triangle Image Actions
		redTriangle.addActionListener(this);
		blueTriangle.addActionListener(this);
		greenTriangle.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Events for the Circle Color Options
		if (e.getSource() == redCircle) {
		img.setIcon(new ImageIcon("img\\download.png"));
		}
		if (e.getSource() == blueCircle) {
		img.setIcon(new ImageIcon("img\\blueCircle.png"));
		}
		if (e.getSource() == greenCircle) {
		img.setIcon(new ImageIcon("img\\greenCircle.png"));
		}
		
		//Events for the Square Color Options
		if (e.getSource() == redSquare) {
		img.setIcon(new ImageIcon("img\\redSquare.png"));
		}
		if (e.getSource() == blueSquare) {
		img.setIcon(new ImageIcon("img\\blueSquare.png"));
		}
		if (e.getSource() == greenSquare) {
		img.setIcon(new ImageIcon("img\\greenSquare.png"));
		}
		
		//Events for the Triangle Color Options
		if (e.getSource() == redTriangle) {
		img.setIcon(new ImageIcon("img\\redTriangle.png"));
		}
		if (e.getSource() == blueTriangle) {
		img.setIcon(new ImageIcon("img\\blueTriangle.png"));
		}
		if (e.getSource() == greenTriangle) {
		img.setIcon(new ImageIcon("img\\greenTriangle.png"));
		}
	}
}
