package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class RegisterCustomerView extends JFrame{
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Email;
	private JTextField Phone;
	private JTextField LicenseNumber;
	private JTextField Address;
	private JTextField SearchBy;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCustomerView window = new RegisterCustomerView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterCustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		setBounds(500,500,1100,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setBounds(0, 0, 1082, 74);
		getContentPane().add(headerPanel);
		
		FooterPanel footerPanel = new FooterPanel();
		footerPanel.setBounds(0, 719, 1082, 34);
		getContentPane().add(footerPanel);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(0, 75, 394, 643);
		getContentPane().add(registerPanel);
		registerPanel.setLayout(null);
		
		JLabel lblNewCustomerRegistration = new JLabel("New Customer Registration");
		lblNewCustomerRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCustomerRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewCustomerRegistration.setBounds(0, 27, 394, 25);
		registerPanel.add(lblNewCustomerRegistration);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(12, 98, 114, 25);
		registerPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(12, 142, 114, 25);
		registerPanel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(12, 190, 114, 25);
		registerPanel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhone.setBounds(12, 236, 114, 25);
		registerPanel.add(lblPhone);
		
		JLabel lblLicenseNumber = new JLabel("License Number:");
		lblLicenseNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenseNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLicenseNumber.setBounds(12, 287, 114, 25);
		registerPanel.add(lblLicenseNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(12, 336, 114, 137);
		registerPanel.add(lblAddress);
		
		FirstName = new JTextField();
		FirstName.setBounds(138, 96, 228, 31);
		registerPanel.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		LastName.setBounds(138, 140, 228, 31);
		registerPanel.add(LastName);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(138, 188, 228, 31);
		registerPanel.add(Email);
		
		Phone = new JTextField();
		Phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!Character.isDigit(arg0.getKeyChar()))
				{
					arg0.consume();
				}
			}
		});
		Phone.setColumns(10);
		Phone.setBounds(138, 232, 228, 31);
		registerPanel.add(Phone);
		
		LicenseNumber = new JTextField();
		LicenseNumber.setColumns(10);
		LicenseNumber.setBounds(138, 285, 228, 31);
		registerPanel.add(LicenseNumber);
		LicenseNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!Character.isDigit(arg0.getKeyChar()))
				{
					arg0.consume();
				}
			}
		});

		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(138, 334, 228, 139);
		registerPanel.add(Address);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(108, 505, 136, 37);
		registerPanel.add(btnSubmit);
		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(395, 75, 687, 114);
		getContentPane().add(SearchPanel);
		SearchPanel.setLayout(null);
		
		SearchBy = new JTextField();
		SearchBy.setBounds(77, 43, 247, 31);
		SearchPanel.add(SearchBy);
		SearchBy.setColumns(10);
		
		JButton btnSearchByName = new JButton("Search by Name");
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearchByName.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchByName.setBounds(408, 49, 173, 18);
		SearchPanel.add(btnSearchByName);
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(395, 186, 687, 532);
		getContentPane().add(TablePanel);
		TablePanel.setLayout(new BorderLayout());
		
	
		
		
	}
}
