package Presentation;

/*******************************************************************************
 * Programmer: Lee-Michael Owen CIS355A week5 // Date: July 2017 
 * Description: Creates window for StockGui
 * Input: Stockname, quanity purchases, price purchased, and current price
 * 		button to add stock object, and remove stock object
 * Output: Displays if the stock has a positive, negative, or equalivant ROI
*******************************************************************************/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Buisness.Stock;
import Persistence.StockIO;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class stockGUI extends JFrame implements ActionListener {

	private Stock stock = new Stock();

	private JPanel ctpMain;
	private JTextField stockNameField, quantityField, purchasePriceField, currentPricesField;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mnOpen, mnSave, mnExit;
	private JList<Stock> stockPurchasesList;
	private DefaultListModel stockPurchasesModel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockGUI frame = new stockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stockGUI() {
		initComponents();

	}

	// Initializes Components and creates events
	private void initComponents() {
		setTitle("Portfolio Mangement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mnOpen = new JMenuItem("Open");
		mnFile.add(mnOpen);

		mnSave = new JMenuItem("Save");
		mnFile.add(mnSave);

		mnExit = new JMenuItem("Exit");
		mnFile.add(mnExit);

		// Implement Menu Bar Events
		mnOpen.addActionListener(this);
		mnSave.addActionListener(this);
		mnExit.addActionListener(this);

		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_ctpMain.setVerticalGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel listTab = new JPanel();
		tabbedPane.addTab("List", null, listTab, null);

		JList stockPurchasesList = new JList();

		JLabel ROILabel = new JLabel("");

		// Add action listener for the stockList
		stockPurchasesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (stockPurchasesList.getSelectedIndex() != -1) {
					Stock s = (Stock) stockPurchasesList.getSelectedValue();
					ROILabel.setText(s.ROI());
				}
			}
		});

		JButton removeStockBtn = new JButton("Remove Stock");
		// Add action listener for the removeStockBtn
		removeStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int item = stockPurchasesList.getSelectedIndex();
				if (item == -1) {
					JOptionPane.showMessageDialog(null, "Must Select Item to Remove");
				} else
					stockPurchasesModel.remove(item);
				Stock.removeStock(item);
				ROILabel.setText("");
			}
		});
		GroupLayout gl_listTab = new GroupLayout(listTab);
		gl_listTab.setHorizontalGroup(gl_listTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listTab.createSequentialGroup()
						.addGroup(gl_listTab.createParallelGroup(Alignment.LEADING)
								.addComponent(ROILabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_listTab.createSequentialGroup().addGap(166).addComponent(removeStockBtn))
								.addComponent(stockPurchasesList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 412,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_listTab.setVerticalGroup(gl_listTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listTab.createSequentialGroup()
						.addComponent(stockPurchasesList, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ROILabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE).addComponent(removeStockBtn)
						.addContainerGap()));
		listTab.setLayout(gl_listTab);

		JPanel addStockTab = new JPanel();
		tabbedPane.addTab("Add Stock", null, addStockTab, null);

		JLabel stockNameLabel = new JLabel("Stock Name:");

		JLabel quantityLabel = new JLabel("Quantity:");

		JLabel purchasePriceLabel = new JLabel("Purchase Price:");

		JLabel currentPriceLabel = new JLabel("Current Price:");

		stockNameField = new JTextField();
		stockNameField.setColumns(10);

		quantityField = new JTextField();
		quantityField.setColumns(10);

		purchasePriceField = new JTextField();
		purchasePriceField.setColumns(10);

		currentPricesField = new JTextField();
		currentPricesField.setColumns(10);

		JButton btnAddStock = new JButton("Add Stock");

		// Creates an action for the addStockBtn
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(quantityField.getText());
				Double pp = Double.parseDouble(purchasePriceField.getText());
				Double cP = Double.parseDouble(currentPricesField.getText());
				stock = new Stock(stockNameField.getText(), qty, pp, cP);
				Stock.addStock(stock);
				stockPurchasesModel.addElement(stock);
				stockPurchasesList.setModel(stockPurchasesModel);
				// configure for single selection only
				stockPurchasesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// clear text fields after creating stock to reduce chance of duplicates
				stockNameField.setText("");
				quantityField.setText("");
				purchasePriceField.setText("");
				currentPricesField.setText("");

			}
		});
		GroupLayout gl_addStockTab = new GroupLayout(addStockTab);
		gl_addStockTab.setHorizontalGroup(gl_addStockTab.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_addStockTab.createSequentialGroup().addGap(57)
						.addGroup(gl_addStockTab.createParallelGroup(Alignment.LEADING, false)
								.addComponent(purchasePriceLabel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(quantityLabel).addComponent(stockNameLabel, GroupLayout.PREFERRED_SIZE,
										83, GroupLayout.PREFERRED_SIZE)
								.addComponent(currentPriceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(35)
						.addGroup(gl_addStockTab.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_addStockTab
								.createSequentialGroup()
								.addGroup(gl_addStockTab.createParallelGroup(Alignment.LEADING, false)
										.addComponent(purchasePriceField).addComponent(quantityField)
										.addComponent(stockNameField, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
								.addGap(12))
								.addGroup(gl_addStockTab.createSequentialGroup().addComponent(currentPricesField)
										.addContainerGap())))
				.addGroup(gl_addStockTab.createSequentialGroup().addGap(156).addComponent(btnAddStock)
						.addContainerGap(185, Short.MAX_VALUE)));
		gl_addStockTab.setVerticalGroup(gl_addStockTab.createParallelGroup(Alignment.LEADING).addGroup(gl_addStockTab
				.createSequentialGroup()
				.addGroup(gl_addStockTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(stockNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(stockNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_addStockTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(quantityLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_addStockTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(purchasePriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(purchasePriceLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_addStockTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(currentPriceLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentPricesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(26).addComponent(btnAddStock).addContainerGap(57, Short.MAX_VALUE)));

		addStockTab.setLayout(gl_addStockTab);
		ctpMain.setLayout(gl_ctpMain);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Opens txt file
		if (event.getSource() == mnOpen) {
			StockIO.read();
			ArrayList<Stock> writeStock = new ArrayList<Stock>();
			writeStock = Stock.returnArray();
			for (Stock s : writeStock) {
				String companyName = s.getCompanyName();
				int qty = s.getNumOfShares();
				Double pp = s.getPurchasePrice();
				Double cP = s.getCurrentPrice();
				stock = new Stock(companyName, qty, pp, cP);
				System.out.println("Reading the File");
				System.out.println(stock.toString());
				stockPurchasesModel.addElement(stock);
				stockPurchasesList.setModel(stockPurchasesModel);
				stockPurchasesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}


		}
		// Saves ArrayList to txt file
		if (event.getSource() == mnSave) {
			StockIO.write();
		}
		// Exits through file menu 'exit'
		if (event.getSource() == mnExit) {
			System.exit(0);
		}

	}

}
