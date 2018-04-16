package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import parkinglot.controller.admin.RegisterCustomerController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import parkinglot.view.includes.MenuBar;

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

public class RegisterCustomerView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Email;
	private JTextField Phone;
	private JTextField LicenseNumber;
	private JTextField Address;
	private JTextField SearchBy;
	private JTable table;
	private JScrollPane scrollPane;

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

		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);

		JPanel cards = new JPanel();
		cards.setForeground(Color.WHITE);
		cards.setBackground(Color.BLACK);

		getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(null);
		MenuBar menuBar = new MenuBar();
		menuBar.setBounds(0, 0, 1084, 26);
		cards.add(menuBar);

		// JPanel centerHome = new JPanel();
		// centerHome.setBounds(0, 26, 1, 591);
		// centerHome.setBackground(Color.LIGHT_GRAY);
		// cards.add(centerHome);
		// centerHome.setLayout(null);

		JPanel registerPanel = new JPanel();
		registerPanel.setForeground(Color.BLACK);
		registerPanel.setBackground(Color.LIGHT_GRAY);
		cards.add(registerPanel);
		registerPanel.setBounds(0, 28, 394, 589);
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
				if (!Character.isDigit(arg0.getKeyChar())) {
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
				if (!Character.isDigit(arg0.getKeyChar())) {
					arg0.consume();
				}
			}
		});

		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(138, 334, 228, 139);
		registerPanel.add(Address);

		RegisterCustomerController controller = new RegisterCustomerController(this);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.insert(LastName.getText(), FirstName.getText(), Email.getText(), Address.getText(),
						new Integer(Phone.getText()), LicenseNumber.getText());
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(107, 505, 136, 37);
		registerPanel.add(btnSubmit);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(Color.LIGHT_GRAY);
		cards.add(SearchPanel);
		SearchPanel.setBounds(397, 28, 687, 114);
		SearchPanel.setLayout(null);

		SearchBy = new JTextField();
		SearchBy.setBounds(77, 43, 321, 31);
		SearchPanel.add(SearchBy);
		SearchBy.setColumns(10);

		JButton btnSearchByName = new JButton("Search by Name");
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnSearchByName.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchByName.setBounds(408, 43, 153, 31);
		SearchPanel.add(btnSearchByName);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(397, 145, 687, 472);
		cards.add(panel);

		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel.add(scrollPane);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
