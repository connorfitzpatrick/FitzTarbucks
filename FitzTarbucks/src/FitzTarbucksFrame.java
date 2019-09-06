import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FitzTarbucksFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp =  new JMenu("Help");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByName = new JMenuItem("By Name");
	private final JMenuItem mntmByPrice = new JMenuItem("By Price");
	private final JMenuItem mntmByType = new JMenuItem("By Type");
	private final JMenuItem mntmByPrice_1 = new JMenuItem("By Price");
	private final JMenuItem mntmByType_1 = new JMenuItem("By Type");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblTarbucksInventoryTracker = new JLabel("Tarbucks Inventory Tracker");
	private double value1;
	private double value2;
	private boolean nameSort;
	private boolean priceSort;
	private boolean typeSort;
	private int combo;
	private boolean coffee;
	private boolean tea;
	private boolean pastry;
	private boolean sandwich;
	private boolean bagel;
	private boolean cookie;
	private boolean scone;
	private boolean other;
	FitzItems item = new FitzItems();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitzTarbucksFrame frame = new FitzTarbucksFrame();
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
	public FitzTarbucksFrame() {
		jbInit();
	}
	
	public FitzTarbucksFrame(FitzItems bag) {
		nameSort = bag.getNameSort();
		priceSort = bag.getPriceSort();
		typeSort = bag.getTypeSort();
		value1 = bag.getPrice1();
		value2 = bag.getPrice2();
		combo = bag.getCombo();
		coffee = bag.getCoffee();
		tea = bag.getTea();
		pastry = bag.getPastry();
		sandwich = bag.getSandwich();
		bagel = bag.getBagel();
		cookie = bag.getCookie();
		scone = bag.getScone();
		other = bag.getOther();
		
		item = new FitzItems(value1, value2, nameSort, priceSort, typeSort, combo, coffee, tea, pastry, sandwich, bagel, cookie, scone, other);
		
		jbInit();
	}
	
	private void jbInit() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				do_this_windowGainedFocus(arg0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Fitz Tarbucks Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 430);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddItem_actionPerformed(arg0);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		mntmByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByName_actionPerformed(arg0);
			}
		});
	
		mnSetSort.add(mntmByName);
		mntmByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByPrice);
		mntmByType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByType_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByType);
		
		mnTools.add(mnSetFilter);
		mntmByPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByPrice_1);
		mntmByType_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByType_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByType_1);
		
		menuBar.add(mnHelp);
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmHome_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmHome);
		mntmFilterByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmFilterByPrice_actionPerformed(arg0);
			}
		});
		mntmAddItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddItem_1_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmAddItem_1);
		
		mnHelp.add(mntmFilterByPrice);
		mntmFilterByType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmFilterByType_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmFilterByType);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 79, 589, 194);
		
		contentPane.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Item Name", "Item Type", "Brand", "Price", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		lblTarbucksInventoryTracker.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTarbucksInventoryTracker.setBounds(141, 11, 324, 47);
		
		contentPane.add(lblTarbucksInventoryTracker);
		
		// load the driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} // try
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		btnClear.setToolTipText("<html>\r\n<p>Click here to remove sort and filter settings</p>");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClear_actionPerformed(arg0);
			}
		});
		btnClear.setBounds(260, 334, 89, 23);
		
		contentPane.add(btnClear);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnClear, mntmExit, mntmAddItem, mntmByName, mntmByPrice, mntmByType, mntmByPrice_1, mntmByType_1, mntmHome, mntmAddItem_1, mntmFilterByPrice, mntmFilterByType}));
		lblSorts.setBounds(10, 282, 442, 14);
		
		contentPane.add(lblSorts);
		lblFilters.setBounds(10, 296, 589, 14);
		
		contentPane.add(lblFilters);
		lblActiveFilters.setBounds(10, 309, 589, 14);
		
		contentPane.add(lblActiveFilters);
	}
			
	protected void do_mntmByName_actionPerformed(ActionEvent arg0) {
		boolean nameSort = true;
		boolean priceSort = false;
		boolean typeSort = false;
		
		item.setNameSort(nameSort);
		item.setPriceSort(priceSort);
		item.setTypeSort(typeSort);
		
		query();
	} // sort by name action method
	
	protected void do_mntmByPrice_actionPerformed(ActionEvent arg0) {
		boolean nameSort = false;
		boolean priceSort = true;
		boolean typeSort = false;
		
		item.setNameSort(nameSort);
		item.setPriceSort(priceSort);
		item.setTypeSort(typeSort);
		
		query();
	} // sort by price action method
	
	protected void do_mntmByType_actionPerformed(ActionEvent arg0) {
		boolean nameSort = false;
		boolean priceSort = false;
		boolean typeSort = true;
		
		item.setNameSort(nameSort);
		item.setPriceSort(priceSort);
		item.setTypeSort(typeSort);

		query();
	} // sort by type action method
	
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		System.exit(0);
	} // exit menu item action 
	
	protected void do_mntmAddItem_actionPerformed(ActionEvent arg0) {
		AddItemFrame add = new AddItemFrame();
		add.setVisible(true);
		add.setLocation(this.getX() + 20, this.getY() + 20);
	} // add item action performed
	
	protected void do_mntmByPrice_1_actionPerformed(ActionEvent arg0) {
		value1 = item.getPrice1();
		value2 = item.getPrice2();
		nameSort = item.getNameSort();
		priceSort = item.getPriceSort();
		typeSort = item.getTypeSort();
		combo = item.getCombo();
		coffee = item.getCoffee();
		tea = item.getTea();
		pastry = item.getPastry();
		sandwich = item.getSandwich();
		bagel = item.getBagel();
		cookie = item.getCookie();
		scone = item.getScone();
		other = item.getOther();
		
		item = new FitzItems(value1, value2, nameSort, priceSort, typeSort, combo, coffee, tea, pastry, sandwich, bagel, cookie, scone, other);
		FilterByPriceFrame filterPrice = new FilterByPriceFrame(item);
		filterPrice.setVisible(true);
		filterPrice.setLocation(this.getX() + 20, this.getY() + 20);
	} // FilterByPrice Action Event
	
	protected void do_mntmByType_1_actionPerformed(ActionEvent arg0) {
		value1 = item.getPrice1();
		value2 = item.getPrice2();
		nameSort = item.getNameSort();
		priceSort = item.getPriceSort();
		typeSort = item.getTypeSort();
		combo = item.getCombo();
		coffee = item.getCoffee();
		tea = item.getTea();
		pastry = item.getPastry();
		sandwich = item.getSandwich();
		bagel = item.getBagel();
		cookie = item.getCookie();
		scone = item.getScone();
		other = item.getOther();
		
		item = new FitzItems(value1, value2, nameSort, priceSort, typeSort, combo, coffee, tea, pastry, sandwich, bagel, cookie, scone, other);
		FilterByTypeFrame filterType = new FilterByTypeFrame(item);
		filterType.setVisible(true);
		filterType.setLocation(this.getX() + 20, this.getY() + 20);
	} // FilterByType Action Event
	
	ResultSet rs = null;
	Statement stmt = null;
	private final JButton btnClear = new JButton("Clear");
	private final JMenuItem mntmHome = new JMenuItem("Home");
	private final JMenuItem mntmFilterByPrice = new JMenuItem("Filter By Price");
	private final JMenuItem mntmFilterByType = new JMenuItem("Filter By Type");
	private final JMenuItem mntmAddItem_1 = new JMenuItem("Add Item");
	private final JLabel lblSorts = new JLabel("Active Sort:");
	private final JLabel lblFilters = new JLabel("Active Filters - Types:");
	private final JLabel lblActiveFilters = new JLabel("Active Filters - Prices:");
	
	protected void do_this_windowGainedFocus(WindowEvent arg0) {	
		query();
	} // Window focus gained
	
	public void query() {
		String sorts = "Active Sort: ";
		String filters = "Active Filters - Types:";
		String prices = "Actice Filters - Prices";
		try {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Public/FitzTarbucks.accdb");
			
			stmt = conn.createStatement();
			
			String query = "select ID, ItemName, ItemType, Brand, Price, Quantity from Items Where 1 = 1";
			
		// FILTER BY TYPE
			
			if (item.getCoffee() == true) {
				filters += " Coffee";
				query += " AND (ItemType = 'Coffee'";
				if (item.getOther() == false && item.getScone() == false && item.getCookie() == false && item.getBagel() == false && item.getSandwich() == false && item.getPastry() == false && item.getTea() == false) {
					query += ")";
				} // if
			} // if()
			if (item.getTea() == true) {
				if(item.getCoffee() == false) {
					filters += " Tea";
					query += " AND (ItemType = 'Tea'";
				} //if()
				else {
					query += " OR ItemType = 'Tea'";
					filters += ", Tea";
					if (item.getOther() == false && item.getScone() == false && item.getCookie() == false && item.getBagel() == false && item.getSandwich() == false && item.getPastry() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getPastry() == true) {
				if (item.getCoffee() == false && item.getTea() == false) {
					filters += " Pastry";
					query += " AND (ItemType = 'Pastry'";
				} // if()
				else {
					query += " OR ItemType = 'Pastry'";
					filters += ", Pastry";
					if (item.getOther() == false && item.getScone() == false && item.getCookie() == false && item.getBagel() == false && item.getSandwich() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getSandwich() == true) {
				if (item.getCoffee() == false && item.getTea() == false && item.getPastry() == false) {
					filters += " Sandwich";
					query += " AND (ItemType = 'Sandwich'";
				} // if()
				else {
					query += " OR ItemType = 'Sandwich'";
					filters += ", Sandwich";
					if (item.getOther() == false && item.getScone() == false && item.getCookie() == false && item.getBagel() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getBagel() == true) {
				if (item.getCoffee() == false && item.getTea() == false && item.getPastry() == false && item.getSandwich() == false) {
					filters += " Bagel";
					query += " AND (ItemType = 'Bagel'";
				} // if()
				else {
					filters += ", Bagel";
					query += " OR ItemType = 'Bagel'";
					if (item.getOther() == false && item.getScone() == false && item.getCookie() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getCookie() == true) {
				if (item.getCoffee() == false && item.getTea() == false && item.getPastry() == false && item.getSandwich() == false && item.getBagel() == false) {
					filters += " Cookie";
					query += " AND (ItemType = 'Cookie'";
				} // if()
				else {
					filters += ", Cookie";
					query += " OR ItemType = 'Cookie'";
					if (item.getOther() == false && item.getScone() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getScone() == true) {
				if (item.getCoffee() == false && item.getTea() == false && item.getPastry() == false && item.getSandwich() == false && item.getBagel() == false && item.getCookie() == false) {
					query += " AND (ItemType = 'Scone'";
					filters += " Scone";
				} // if()
				else {
					filters += ", Scone";
					query += " OR ItemType = 'Scone'";
					if (item.getOther() == false) {
						query += ")";
					} // if
				} // else()
			} // if()
			if (item.getOther() == true) {
				if (item.getCoffee() == false && item.getTea() == false && item.getPastry() == false && item.getSandwich() == false && item.getBagel() == false && item.getCookie() == false && item.getScone() == false) {
					query += " AND (ItemType = 'Other)'";
					filters += " Scone";
				} // if()
				else {
					filters += ", Other";
					query += " OR ItemType = 'Other')";
				} // else()
			} // if()
			
		// FILTER BY PRICE
			
			if (item.getCombo() == 0) {
				query += " And Price >= ";
				query += item.getPrice1();
				query += " And Price <= ";
				query += item.getPrice2();
				prices += " Between $";
				prices += item.getPrice1();
				prices += " and $";
				prices += item.getPrice2();
			} // if()
			else if (item.getCombo() == 1) {
				query += " And Price > ";
				query += item.getPrice1();
				prices += " Greater than $";
				prices += item.getPrice1();
			} // else if()
			else {
				if (item.getCombo() == 2) {
					query += " And Price < ";
					query += item.getPrice1();
					prices += " Less than $";
					prices += item.getPrice1();
				} // if()
			} // else()
			
		// SORT
		
			if (item.getTypeSort() == true) {
				query += " order by ItemType";
				sorts += " Item Type";
			} // if()
			else if (item.getNameSort() == true) {
				query += " order by ItemName";
				sorts += " Item Name";
			} // else if
			else if (item.getPriceSort() == true) {
				query += " order by price";
				sorts += " Item Price";
			} // if()
			else {
				query += " order by ID";
				sorts += " Item ID";
			} // else()
			
			// execute query
			rs = stmt.executeQuery(query);
			
			// remove previously added rows
			while (table.getRowCount() > 0) {
				((DefaultTableModel)table.getModel()).removeRow(0);
			} // while
			
			// process the results
			// find number of columns in result
			int numColumns = rs.getMetaData().getColumnCount();
			
			while(rs.next()) {
				// create an object array to hold a single record
				Object[] row = new Object[numColumns];
				for (int i = 0; i < numColumns; i++) {
					row[i] = rs.getObject(i + 1);
				} // for
				((DefaultTableModel)table.getModel()).insertRow(rs.getRow()-1, row);
			} // while
			lblSorts.setText(sorts);
			lblFilters.setText(filters);
			lblActiveFilters.setText(prices);
			rs.close();
			conn.close();
		} // try
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	} // query()
	protected void do_btnClear_actionPerformed(ActionEvent arg0) {
		item.setNameSort(false);
		item.setPriceSort(false);
		item.setTypeSort(false);
		item.setCoffee(false);
		item.setTea(false);
		item.setPastry(false);
		item.setSandwich(false);
		item.setBagel(false);
		item.setCookie(false);
		item.setScone(false);
		item.setOther(false);
		item.setCombo(-5);
		
		query();
	}
	
	protected void do_mntmHome_actionPerformed(ActionEvent arg0) {
		String help1 = "The table shows all records that meet you current specifications."
				+ "\n" + "To Sort the Data: Click 'Edit' in the menu bar, and hover over 'Sort By'." 
				+ "\n" + "          Next, choose  whether you would like to sort by name, type, or price." 
				+ "\n" + "          Click your desired sorting method" 
				+ "\n" + "To Filter the Data: Click 'Edit' in the menu bar, and hover over 'Filter By." 
				+ "\n" + "          Next, Click your desired filter, By Price or By Type." 
				+ "\n" + "To Remove Chosen Filters and Sorts: press the button labeled 'Clear' under the table" 
				+ "\n" + "To Exit Program: You may either press the red 'x' in the right hand corner or" 
				+ "\n" + "          click 'File' in the menu bar, and then click 'Exit'.";
		
		JOptionPane.showOptionDialog(null, help1,"Home Help", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
	
	protected void do_mntmFilterByPrice_actionPerformed(ActionEvent arg0) {
		String help2 = "1) Choose whether you want to find results greater, less than, or between numbers." 
				+ "\n" + "          Click on the combo box and choose the desired option." 
				+ "\n" + "2) Input the currency amounts that you would like to use as constraints." 
				+ "\n" + "3) Press the button labeled 'Filter'." 
				+ "\n" + "To Clear Input Boxes: Press the button labeled 'Clear.'" 
				+ "\n" + "To Exit Window: Click the Button labeled 'Exit.'";
		
		JOptionPane.showOptionDialog(null, help2,"Filter By Price Help", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
	
	protected void do_mntmAddItem_1_actionPerformed(ActionEvent arg0) {
		String help1 = "Item ID: Enter the item's ID number here."
				+ "\n" + "Item Name: Enter the item's Name here." 
				+ "\n" + "Item Type: Click on the combo box and click the choice that matches the items type'." 
				+ "\n" + "Brand: Enter the item's brand here." 
				+ "\n" + "Price: Enter the item's price here." 
				+ "\n" + "Quantity: Enter the quantity of the item here." 
				+ "\n" + "To Add Item: Click the button labeled 'Add.'" 
				+ "\n" + "To Exit Window: Click the Button labeled 'Exit.'";
		
		JOptionPane.showOptionDialog(null, help1,"Add Item Help", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
	
	protected void do_mntmFilterByType_actionPerformed(ActionEvent arg0) {
		String help1 = "Coffee: Click this checkbox to include 'Coffee' in filtering"
				+ "\n" + "Tea: Click this checkbox to include 'Tea' in filtering." 
				+ "\n" + "Pastry: Click this checkbox to include 'Pastry' in filtering." 
				+ "\n" + "Sandwich: Click this checkbox to include 'Sandwich' in filtering." 
				+ "\n" + "Bagel: Click this checkbox to include 'Bagel' in filtering." 
				+ "\n" + "Cookie: Click this checkbox to include 'Cookie' in filtering." 
				+ "\n" + "Scone: Click this checkbox to include 'Scone' in filtering." 
				+ "\n" + "Other: Click this checkbox to include 'Other' in filtering."
				+ "\n" + "To Clear Data: Click the button labeled 'Clear.'"
				+ "\n" + "To Filter Data: Click the button labeled 'Filter.'" 
				+ "\n" + "To Exit Window: Click the button labeled 'Exit'.";
		
		JOptionPane.showOptionDialog(null, help1, "Filter By Type", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
	}
} // FitzTarbucksFrame
