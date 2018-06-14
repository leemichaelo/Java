package Week3_Presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
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

import Week3_Buisness.Order;
import Week3_Buisness.OrderManager;

public class BurgersRUsGUI extends JFrame implements ActionListener {

	private OrderManager orderManager = new OrderManager();
	private JMenuItem exitItem, addOrderItem, clearForNextItem, newOrderItem;
	private JRadioButton singleBurger, doubleBurger;
	private JCheckBox addCheese, addBacon, makeMeal;
	private JLabel itemPriceLabel, orderQuantityLabel, orderTotalLabel, recieptLabel;
	private JTextField itemPriceField, orderQuantityField, orderTotalField;
	private JTextArea recieptArea;

	public BurgersRUsGUI(String title) throws HeadlessException {
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

		// create menu bar
		JMenuBar mainMenu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu orderMenu = new JMenu("Order");
		// add options to menu bar
		mainPanel.add(mainMenu);
		mainMenu.add(fileMenu);
		mainMenu.add(orderMenu);

		// create options for File Menu
		exitItem = new JMenuItem("Exit");

		// add options for File Menu
		fileMenu.add(exitItem);

		// create options for Order Menu
		addOrderItem = new JMenuItem("Add to Order");
		clearForNextItem = new JMenuItem("Clear for Next Item");
		newOrderItem = new JMenuItem("New Order");

		// add options for Order Menu
		orderMenu.add(addOrderItem);
		orderMenu.add(clearForNextItem);
		orderMenu.add(newOrderItem);

		// implements menubar events
		exitItem.addActionListener(this);
		addOrderItem.addActionListener(this);

		// add radio buttons
		singleBurger = new JRadioButton("Single Burger");
		doubleBurger = new JRadioButton("Double Burger");
		mainPanel.add(singleBurger);
		mainPanel.add(doubleBurger);
		// add button group
		ButtonGroup burgerType = new ButtonGroup();
		burgerType.add(singleBurger);
		burgerType.add(doubleBurger);

		// implements burgerType actions
		singleBurger.addActionListener(this);
		doubleBurger.addActionListener(this);

		// add check boxes for toppings
		addCheese = new JCheckBox("Add Cheese");
		addBacon = new JCheckBox("Add Bacon");
		makeMeal = new JCheckBox("Make It A Meal");
		mainPanel.add(addCheese);
		mainPanel.add(addBacon);
		mainPanel.add(makeMeal);

		// implements toppings actions
		addCheese.addActionListener(this);
		addBacon.addActionListener(this);
		makeMeal.addActionListener(this);

		// add JTextFields & Labels
		itemPriceLabel = new JLabel("Item Price");
		itemPriceField = new JTextField(10);
		itemPriceField.setText("0.00");
		orderQuantityLabel = new JLabel("Quantity");
		orderQuantityField = new JTextField(10);
		orderQuantityField.setText("1");
		orderTotalLabel = new JLabel("Order Total");
		orderTotalField = new JTextField(10);
		recieptLabel = new JLabel("YOUR ORDER");
		recieptArea = new JTextArea(20, 50);
		recieptArea.setEditable(false);
		mainPanel.add(itemPriceLabel);
		mainPanel.add(itemPriceField);
		mainPanel.add(orderQuantityLabel);
		mainPanel.add(orderQuantityField);
		mainPanel.add(orderTotalLabel);
		mainPanel.add(orderTotalField);
		mainPanel.add(recieptLabel);
		mainPanel.add(recieptArea);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int burgerType = 0;
		String order = "";
		double cost = 0;
		double totalCost = 0;
		int quantity;

		// exits through file menu 'exit'
		if (event.getSource() == exitItem) {
			System.exit(0);
		}
		if (event.getSource() == addOrderItem) {
			if (singleBurger.isSelected()) {
				burgerType = 0;
				cost += 3.5;
				order += "Single Burger";
				itemPriceField.setText(String.valueOf(cost));
			} else if (doubleBurger.isSelected()) {
				burgerType = 1;
				cost += 4.75;
				order += "Double Burger";
				itemPriceField.setText(String.valueOf(cost));
			} else {
				JOptionPane.showMessageDialog(null, "Must select a burger", "Error", JOptionPane.ERROR_MESSAGE);
				return; // do NOT continue this method
			}
			if (addCheese.isSelected()) {
				order += ", Cheese ";
				cost += .5;
				// itemPriceField.setText(String.valueOf(cost));
			}
			if (addBacon.isSelected()) {
				order += ", Bacon ";
				cost += 1.25;
				itemPriceField.setText(String.valueOf(cost));
			}
			if (makeMeal.isSelected()) {
				order += ", Meal ";
				cost += 4.00;
				itemPriceField.setText(String.valueOf(cost));
			}

			quantity = Integer.parseInt(orderQuantityField.getText());
			Order newOrder = new Order(burgerType, order, cost, quantity);
			orderManager.addOrder(newOrder);
			recieptArea.append("\n" + quantity + " " + order + " at " + cost + " each.");
			itemPriceLabel.setText(String.valueOf(0));
			orderTotalField.setText(String.valueOf(cost));
		}
		// adds to item price
		if (singleBurger.isSelected()) {
			cost += 3.5;
			order += "Single Burger";
			itemPriceField.setText(String.valueOf(cost));
		} else if (doubleBurger.isSelected()) {
			burgerType = 1;
			cost += 4.75;
			order += "Double Burger";
			itemPriceField.setText(String.valueOf(cost));
		} else {
			JOptionPane.showMessageDialog(null, "Must select a burger", "Error", JOptionPane.ERROR_MESSAGE);
			return; // do NOT continue this method
		}
		if (addCheese.isSelected()) {
			cost += .5;
			// itemPriceField.setText(String.valueOf(cost));
		}
		if (addBacon.isSelected()) {
			cost += 1.25;
			itemPriceField.setText(String.valueOf(cost));
		}
		if (makeMeal.isSelected()) {
			cost += 4.00;
			itemPriceField.setText(String.valueOf(cost));
		}
		// add order object to array here
		// add total as well
	}
	// clears order screen
}


