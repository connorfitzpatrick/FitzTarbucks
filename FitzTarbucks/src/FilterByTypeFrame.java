import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class FilterByTypeFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblFilterByType = new JLabel("Filter By Type");
	private final JCheckBox chckbxCoffee = new JCheckBox("Coffee");
	private final JCheckBox chckbxTea = new JCheckBox("Tea");
	private final JCheckBox chckbxPastry = new JCheckBox("Pastry");
	private final JCheckBox chckbxSandwich = new JCheckBox("Sandwich");
	private final JCheckBox chckbxBagel = new JCheckBox("Bagel");
	private final JCheckBox chckbxCookie = new JCheckBox("Cookie");
	private final JCheckBox chckbxScone = new JCheckBox("Scone");
	private final JCheckBox chckbxOther = new JCheckBox("Other");
	private final JButton btnFilter = new JButton("Filter");
	private final JButton btnClear = new JButton("Clear");
	private final JLabel lblError = new JLabel("Error: You must Choose a Filter");
	private final JButton btnCancel = new JButton("Cancel");
	private double value1;
	private double value2;
	private boolean nameSort;
	private boolean priceSort;
	private boolean typeSort;
	private int combo;
	private boolean coffee = false;
	private boolean tea = false;
	private boolean pastry = false;
	private boolean sandwich = false;
	private boolean bagel = false;
	private boolean cookie = false;
	private boolean scone = false;
	private boolean other = false;
	FitzItems item = new FitzItems();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterByTypeFrame frame = new FilterByTypeFrame();
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
	public FilterByTypeFrame() {
		jbInit();
	}
	
	public FilterByTypeFrame(FitzItems thing) {
		item = thing;
		jbInit();
	} 
 	
	private void jbInit() {
		setTitle("Filter By Type Frame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFilterByType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFilterByType.setBounds(149, 11, 142, 33);
		
		contentPane.add(lblFilterByType);
		chckbxCoffee.setToolTipText("<html>\r\n<p>Click to select \"Coffee\" filter</p>");
		chckbxCoffee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCoffee.setBounds(54, 51, 97, 23);
		
		contentPane.add(chckbxCoffee);
		chckbxTea.setToolTipText("<html>\r\n<p>Click to select \"Tea\" filter</p>");
		chckbxTea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTea.setBounds(54, 87, 97, 23);
		
		contentPane.add(chckbxTea);
		chckbxPastry.setToolTipText("<html>\r\n<p>Click to select \"Pastry\" filter</p>");
		chckbxPastry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPastry.setBounds(54, 122, 97, 23);
		
		contentPane.add(chckbxPastry);
		chckbxSandwich.setToolTipText("<html>\r\n<p>Click to select \"Sandwich\" filter</p>");
		chckbxSandwich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxSandwich.setBounds(54, 161, 97, 23);
		
		contentPane.add(chckbxSandwich);
		chckbxBagel.setToolTipText("<html>\r\n<p>Click to select \"Bagel\" filter</p>");
		chckbxBagel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxBagel.setBounds(283, 51, 97, 23);
		
		contentPane.add(chckbxBagel);
		chckbxCookie.setToolTipText("<html>\r\n<p>Click to select \"Cookie\" filter</p>");
		chckbxCookie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCookie.setBounds(283, 87, 97, 23);
		
		contentPane.add(chckbxCookie);
		chckbxScone.setToolTipText("<html>\r\n<p>Click to select \"Scone\" filter</p>");
		chckbxScone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxScone.setBounds(283, 122, 97, 23);
		
		contentPane.add(chckbxScone);
		chckbxOther.setToolTipText("<html>\r\n<p>Click to select \"Other\" filter</p>");
		chckbxOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxOther.setBounds(283, 161, 97, 23);
		
		contentPane.add(chckbxOther);
		btnFilter.setToolTipText("<html>\r\n<p>Press to apply selected filters</p>");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFilter_actionPerformed(arg0);
			}
		});
		btnFilter.setBounds(54, 227, 89, 23);
		
		contentPane.add(btnFilter);
		btnClear.setToolTipText("<html>\r\n<p>Click to unselect all filters</p>");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClear_actionPerformed(arg0);
			}
		});
		btnClear.setBounds(173, 227, 89, 23);
		
		contentPane.add(btnClear);
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 202, 200, 14);
		
		contentPane.add(lblError);
		lblError.setVisible(false);
		btnCancel.setToolTipText("<html>\r\n<p>Click to return to table</p>");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(291, 227, 89, 23);
		
		contentPane.add(btnCancel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{chckbxCoffee, chckbxTea, chckbxPastry, chckbxSandwich, chckbxBagel, chckbxCookie, chckbxScone, chckbxOther, btnFilter, btnClear, btnCancel}));
	}
	
	protected void do_btnClear_actionPerformed(ActionEvent arg0) {
		chckbxCoffee.setSelected(false);
		chckbxTea.setSelected(false);
		chckbxPastry.setSelected(false);
		chckbxSandwich.setSelected(false);
		chckbxBagel.setSelected(false);
		chckbxCookie.setSelected(false);
		chckbxScone.setSelected(false);
		chckbxOther.setSelected(false);
	} // clear button action event
	
	protected void do_btnFilter_actionPerformed(ActionEvent arg0) {
		if (!(chckbxCoffee.isSelected()) && !(chckbxTea.isSelected()) && !(chckbxPastry.isSelected()) && !(chckbxSandwich.isSelected()) && !(chckbxBagel.isSelected()) && !(chckbxCookie.isSelected()) && !(chckbxScone.isSelected()) && !(chckbxOther.isSelected())) {
			lblError.setVisible(true);
			item.setCoffee(false);
			item.setTea(false);
			item.setPastry(false);
			item.setSandwich(false);
			item.setBagel(false);
			item.setCookie(false);
			item.setScone(false);
			item.setOther(false);
		} // if
		else {
			lblError.setVisible(false);
			
			if (chckbxCoffee.isSelected()) {
				coffee = true;
				item.setCoffee(coffee);
			} // if()
			else {
				item.setCoffee(false);
			} // else()
			
			if (chckbxTea.isSelected()) {
				tea = true;
				item.setTea(tea);
			} // if()
			else {
				item.setTea(false);
			} // else()
			
			if (chckbxPastry.isSelected()) {
				pastry = true;
				item.setPastry(pastry);
			} // if()
			else {
				item.setPastry(false);
			} // else()
			
			if (chckbxSandwich.isSelected()) {
				sandwich = true;
				item.setSandwich(sandwich);
			} // if()
			else {
				sandwich = false;
				item.setSandwich(sandwich);
			} // else()
			
			if (chckbxBagel.isSelected()) {
				bagel = true;
				item.setBagel(bagel);
			} // if()
			else {
				item.setBagel(false);
			} // else()
			
			if (chckbxCookie.isSelected()) {
				cookie = true;
				item.setCookie(cookie);
			} // if()
			else {
				item.setCookie(false);
			} // if()
			
			if (chckbxScone.isSelected()) {
				scone = true;
				item.setScone(scone);
			} // if()
			else {
				item.setScone(false);
			} // else()
			
			if (chckbxOther.isSelected()) {
				other = true;
				item.setOther(other);
			} // if()
			else {
				item.setOther(false);
			} // else()
			this.dispose();
		} // else()
	} 
	
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	} // cancel button action event
}