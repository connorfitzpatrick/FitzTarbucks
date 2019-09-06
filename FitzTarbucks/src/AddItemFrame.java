import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class AddItemFrame extends JFrame {

	private JPanel contentPane;
	
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	private final JButton btnApply = new JButton("Apply");
	private final JButton btnClose = new JButton("Close");
	private final JLabel lblAddItem = new JLabel("Add Item");
	private final JLabel lblItemId = new JLabel("Item ID:");
	private final JLabel lblItemName = new JLabel("Item Name:");
	private final JFormattedTextField itemIdFTF = new JFormattedTextField();
	private final JFormattedTextField itemNameFTF = new JFormattedTextField();
	private final JLabel lblBrand = new JLabel("Brand:");
	private final JTextField brandTF = new JTextField();
	private final JLabel lblPrice = new JLabel("Price:");
	private final JFormattedTextField priceFTF = new JFormattedTextField(currencyFormat);
	
//	private final JFormattedTextField priceFTF = new JFormattedTextField();
	
	private final JLabel lblQuantity = new JLabel("Quantity:");
	private final JFormattedTextField quantityFTF = new JFormattedTextField();
	private final JLabel lblItemType = new JLabel("Item Type:");
	private final JComboBox itemTypeComboBox = new JComboBox();
	private final JLabel lblIdError = new JLabel("You must enter an item's ID");
	private final JLabel lblNameError = new JLabel("You must enter the item's name");
	private final JLabel lblTypeError = new JLabel("You must give an item type");
	private final JLabel lblBrandError = new JLabel("You must enter the item's brand");
	private final JLabel lblPriceError = new JLabel("You must enter the items price");
	private final JLabel lblQuantityError = new JLabel("You must enter the item's quantity");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemFrame frame = new AddItemFrame();
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
	public AddItemFrame() {
		brandTF.setToolTipText("<html>\r\n<p>Enter the brand of the item here</p>");
		brandTF.setBounds(93, 189, 94, 20);
		brandTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Add Item Frame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 475, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnApply.setToolTipText("<html>\r\n<p>Click to add item</p>");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnApply_actionPerformed(arg0);
			}
		});
		btnApply.setBounds(93, 332, 94, 23);
		
		contentPane.add(btnApply);
		btnClose.setToolTipText("<html>\r\n<p>Click to return to table</p>");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClose_actionPerformed(arg0);
			}
		});
		btnClose.setBounds(250, 332, 94, 23);
		
		contentPane.add(btnClose);
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddItem.setBounds(191, 11, 72, 14);
		
		contentPane.add(lblAddItem);
		lblItemId.setBounds(10, 42, 46, 14);
		
		contentPane.add(lblItemId);
		lblItemName.setBounds(10, 93, 65, 14);
		
		contentPane.add(lblItemName);
		itemIdFTF.setToolTipText("<html>\r\n<p>Enter item's ID here</p>");
		itemIdFTF.setBounds(93, 39, 94, 20);
		
		contentPane.add(itemIdFTF);
		itemNameFTF.setToolTipText("<html>\r\n<p>Enter item's name here</p>");
		itemNameFTF.setBounds(93, 90, 94, 20);
		
		contentPane.add(itemNameFTF);
		lblBrand.setBounds(10, 192, 46, 14);
		
		contentPane.add(lblBrand);
		
		contentPane.add(brandTF);
		lblPrice.setBounds(10, 240, 46, 14);
		
		contentPane.add(lblPrice);
		priceFTF.setToolTipText("<html>\r\n<p>Enter the price of the item here</p>");
		priceFTF.setBounds(93, 234, 94, 20);
		priceFTF.setValue(0);
		
		contentPane.add(priceFTF);
		lblQuantity.setBounds(10, 286, 65, 14);
		
		contentPane.add(lblQuantity);
		quantityFTF.setToolTipText("<html>\r\n<p>Enter the quantity of the item here</p>");
		quantityFTF.setBounds(93, 283, 94, 20);
		
		contentPane.add(quantityFTF);
		lblItemType.setBounds(10, 143, 65, 14);
		
		contentPane.add(lblItemType);
		itemTypeComboBox.setToolTipText("<html>\r\n<p>Select the type that apllies to the item</p>");
		itemTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Coffee", "Tea", "Pastry", "Sandwich", "Bagel", "Cookie", "Scone", "Other"}));
		itemTypeComboBox.setBounds(93, 140, 94, 20);
		
		contentPane.add(itemTypeComboBox);
		lblIdError.setForeground(Color.RED);
		lblIdError.setBounds(211, 42, 238, 14);
		lblIdError.setVisible(false);
		
		contentPane.add(lblIdError);
		lblNameError.setForeground(Color.RED);
		lblNameError.setBounds(211, 93, 238, 14);
		lblNameError.setVisible(false);
		
		contentPane.add(lblNameError);
		lblTypeError.setForeground(Color.RED);
		lblTypeError.setBounds(211, 143, 238, 14);
		lblTypeError.setVisible(false);
		
		contentPane.add(lblTypeError);
		lblBrandError.setForeground(Color.RED);
		lblBrandError.setBounds(211, 192, 238, 14);
		lblBrandError.setVisible(false);
		
		contentPane.add(lblBrandError);
		lblPriceError.setForeground(Color.RED);
		lblPriceError.setBounds(211, 240, 238, 14);
		lblPriceError.setVisible(false);
		
		contentPane.add(lblPriceError);
		lblQuantityError.setForeground(Color.RED);
		lblQuantityError.setBounds(211, 286, 238, 14);
		lblQuantityError.setVisible(false);
		
		contentPane.add(lblQuantityError);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{itemIdFTF, itemNameFTF, itemTypeComboBox, brandTF, priceFTF, quantityFTF, btnApply, btnClose}));
	}
	protected void do_btnClose_actionPerformed(ActionEvent arg0) {
		this.dispose();
	} // 'close' button action
	protected void do_btnApply_actionPerformed(ActionEvent arg0) {
		if (itemIdFTF.getText().trim().isEmpty() || itemNameFTF.getText().trim().isEmpty() || itemTypeComboBox.getSelectedIndex() == 0 || brandTF.getText().isEmpty() || priceFTF.getText().equals("$0.00") || quantityFTF.getText().trim().isEmpty()) {
			
			if (itemIdFTF.getText().trim().isEmpty()) {
				lblIdError.setVisible(true);
			} // if()
			else {
				lblIdError.setVisible(false);
			} // else()
			
			if (itemNameFTF.getText().trim().isEmpty()) {
				lblNameError.setVisible(true);
			} // if()
			else {
				lblNameError.setVisible(false);
			} // else()
			
			if (itemTypeComboBox.getSelectedIndex() == 0) {
				lblTypeError.setVisible(true);
			} // if()
			else {
				lblTypeError.setVisible(false);
			} // else()
			
			if (brandTF.getText().isEmpty()) {
				lblBrandError.setVisible(true);
			} // if()
			else {
				lblBrandError.setVisible(false);
			} // else()
			
			if (priceFTF.getText().equals("$0.00")) {
				lblPriceError.setVisible(true);
			} // if
			else {
				lblPriceError.setVisible(false);
			} // else()
			
			if (quantityFTF.getText().trim().isEmpty()) {
				lblQuantityError.setVisible(true);
			} // if()
			else {
				lblQuantityError.setVisible(false);
			} // else()
		} // if()
		else {
			lblIdError.setVisible(false);
			lblNameError.setVisible(false);
			lblTypeError.setVisible(false);
			lblBrandError.setVisible(false);
			lblPriceError.setVisible(false);
			lblQuantityError.setVisible(false);
			
			Statement insStmt =  null;
			String insQuery = null;
			ResultSet rs = null; // check for duplicates
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Public/FitzTarbucks.accdb");
			
				Statement stmt = conn.createStatement();
				
				insStmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String NewQuery = "SELECT * FROM Items WHERE ID = " + itemIdFTF.getText().trim();
				System.out.println(NewQuery);
				rs = stmt.executeQuery(NewQuery);
				
				if(rs.next()) {
					System.out.println("Duplicates not allowed");
				} 
				else {
					// build the INSERT command
					insQuery = "INSERT INTO Items (ID, ItemName, ItemType, Brand, Price, Quantity) VALUES (";
					insQuery += itemIdFTF.getText().trim() + ",";
					insQuery += "'" + itemNameFTF.getText().trim() + "',";
					insQuery += "'" + String.valueOf(itemTypeComboBox.getSelectedItem()) + "',";
					insQuery += "'" + brandTF.getText().trim() + "',";
					insQuery += "'" + priceFTF.getValue() + "',";
					insQuery += "'" + quantityFTF.getText().trim() + "')";
					System.out.println(insQuery);
					
					if (insStmt.executeUpdate(insQuery) != 0) {
						System.out.println("Success");
					} // if()
					else {
						System.out.println("nah");
					} //else()
				} // else()
				stmt.close();
				insStmt.close();
				rs.close();
				conn.close();
				this.dispose();
			} // try
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} // catch
		} // else()
	} // apply button action event
} // AddItemFrame
