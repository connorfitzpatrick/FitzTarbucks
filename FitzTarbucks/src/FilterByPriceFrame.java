import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FilterByPriceFrame extends JFrame {

	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	
	private JPanel contentPane;
	private final JLabel lblFilterByPrice = new JLabel("Filter By Price");
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblFindItems = new JLabel("Choose Price Sorting Method:");
	private final JLabel lblTheItemIs = new JLabel("The item is between:");
	private final JFormattedTextField range1FTF = new JFormattedTextField(currencyFormat);
	private final JLabel andlbl = new JLabel("and");
	private final JFormattedTextField range2FTF = new JFormattedTextField(currencyFormat);
	private final JButton btnFilter = new JButton("Filter");
	private final JButton btnClear = new JButton("Clear");
	private final JButton btnExit = new JButton("Exit");
	private final JLabel lblError = new JLabel("Error: you must give a range");
	private double price1;
	private double price2;
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
	FitzItems thing = new FitzItems();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterByPriceFrame frame = new FilterByPriceFrame();
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
	public FilterByPriceFrame() {
		jbInit();
	}
	
	public FilterByPriceFrame(FitzItems item) {
		thing = item;
		jbInit();
	}
	
	private void jbInit() {
		setTitle("Filter By Price Frame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFilterByPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFilterByPrice.setBounds(151, 11, 134, 42);
		
		contentPane.add(lblFilterByPrice);
		comboBox.setToolTipText("<html>\r\n<p>Select sorting method here</p>");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_comboBox_actionPerformed(arg0);
			}
		});
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Between", "Greater Than", "Less Than"}));
		comboBox.setBounds(196, 61, 89, 20);
		
		contentPane.add(comboBox);
		lblFindItems.setBounds(10, 64, 176, 14);
		
		contentPane.add(lblFindItems);
		lblTheItemIs.setBounds(10, 159, 155, 14);
		
		contentPane.add(lblTheItemIs);
		range1FTF.setToolTipText("<html>\r\n<p>Enter price here</p>");
		range1FTF.setBounds(196, 156, 50, 20);
		range1FTF.setValue(0);
		
		contentPane.add(range1FTF);
		andlbl.setBounds(271, 159, 32, 14);
		
		contentPane.add(andlbl);
		range2FTF.setToolTipText("<html>\r\n<p>Enter price here</p>");
		range2FTF.setBounds(320, 156, 50, 20);
		
		contentPane.add(range2FTF);
		range2FTF.setValue(0);
		btnFilter.setToolTipText("<html>\r\n<p>Press to apply filter</p>");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFilter_actionPerformed(arg0);
			}
		});
		btnFilter.setBounds(42, 215, 89, 23);
		
		contentPane.add(btnFilter);
		btnClear.setToolTipText("<html>\r\n<p>Press to clear any entered prices</p>");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClear_actionPerformed(arg0);
			}
		});
		btnClear.setBounds(168, 215, 89, 23);
		
		contentPane.add(btnClear);
		btnExit.setToolTipText("<html>\r\n<p>Press to return to table</p>");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnExit_actionPerformed(arg0);
			}
		});
		btnExit.setBounds(295, 215, 89, 23);
		
		contentPane.add(btnExit);
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 184, 229, 14);
		
		contentPane.add(lblError);
		lblError.setVisible(false);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, range1FTF, range2FTF, btnFilter, btnClear, btnExit}));
	}
	
	protected void do_comboBox_actionPerformed(ActionEvent arg0) {
		if (comboBox.getSelectedIndex() == 0) {
			lblTheItemIs.setText("The item is between:");
			andlbl.setVisible(true);
			range2FTF.setVisible(true);
		} // if
		else if (comboBox.getSelectedIndex() == 1) {
			lblTheItemIs.setText("The item is greater than:");
			andlbl.setVisible(false);
			range2FTF.setVisible(false);
		} // else if
		else {
			lblTheItemIs.setText("The item is less than:");
			andlbl.setVisible(false);
			range2FTF.setVisible(false);
		} // else
	} // combo box value changed event
	
	protected void do_btnClear_actionPerformed(ActionEvent arg0) {
		comboBox.setSelectedIndex(0);
		lblTheItemIs.setText("The item is between:");
		andlbl.setVisible(true);
		range2FTF.setVisible(true);
		range2FTF.setValue(0);
		range1FTF.setValue(0);		
	} // clear button action event
	
	protected void do_btnExit_actionPerformed(ActionEvent arg0) {
		this.dispose();
	} // cancel button action event
	
	protected void do_btnFilter_actionPerformed(ActionEvent arg0) {
		combo = comboBox.getSelectedIndex();
		thing.setCombo(combo);
		
		String p1 = currencyFormat.format(range1FTF.getValue());
		Number n1 = null;
		
		try {
			n1 = currencyFormat.parse(p1);
		} // try
		catch (ParseException e) {
			e.printStackTrace();
		} // catch
		price1 = n1.doubleValue();
		thing.setPrice1(price1);
		
		String p2 = currencyFormat.format(range2FTF.getValue());
		Number n2 = null;
		
		try {
			n2 = currencyFormat.parse(p2);
		} // try
		catch (ParseException e) {
			e.printStackTrace();
		} // catch
		
		price2 = n2.doubleValue();
				    
		if (comboBox.getSelectedIndex() == 0) {
			thing.setPrice2(price2);
			if (price1 > price2) {
		    	thing.setPrice1(price2);
		    	thing.setPrice2(price1);
		    } // if()
		} // if()
		
		if ((comboBox.getSelectedIndex() == 0) && (range1FTF.getValue() == range2FTF.getValue())) {
			lblError.setVisible(true);
		} // if
		else {
			this.dispose();
		} // else()
	} // filter button action event
}
