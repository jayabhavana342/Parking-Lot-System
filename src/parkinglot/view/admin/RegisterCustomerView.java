package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import parkinglot.controller.admin.RegisterCustomerController;
import parkinglot.model.admin.FrequentParkingUsersModel;
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
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	FrequentParkingUsersModel frequentParkingUser = new FrequentParkingUsersModel();
	private JTextField id;
	private JTextField Rewards;

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
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.insert(LastName.getText(), FirstName.getText(), Email.getText(), Address.getText(),
						new Integer(Phone.getText()), LicenseNumber.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUsersTable(model);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(10, 513, 91, 37);
		registerPanel.add(btnSubmit);

		id = new JTextField();
		id.setBounds(138, 63, 86, 20);
		registerPanel.add(id);
		id.setColumns(10);
		id.setVisible(false);

		Rewards = new JTextField();
		Rewards.setBounds(138, 474, 86, 20);
		registerPanel.add(Rewards);
		Rewards.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.update(id.getText(), LastName.getText(), FirstName.getText(), Email.getText(),
						Address.getText(), new Integer(Phone.getText()), LicenseNumber.getText(), Rewards.getText());

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUsersTable(model);

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(148, 513, 91, 37);
		registerPanel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete(id.getText(), LastName.getText(), FirstName.getText(), Email.getText(),
						Address.getText(), new Integer(Phone.getText()), LicenseNumber.getText(), Rewards.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUsersTable(model);
			}

		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(293, 513, 91, 37);
		registerPanel.add(btnDelete);

		JLabel label_1 = new JLabel("Last Name:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(12, 104, 114, 25);
		registerPanel.add(label_1);

		JLabel label = new JLabel("First Name:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(12, 148, 114, 25);
		registerPanel.add(label);
		Rewards.setVisible(false);

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
				// controller.fillParkingUsersTable(table.getModel(), SearchBy.getText());
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				id.setText(model.getValueAt(i, 0).toString());
				FirstName.setText(model.getValueAt(i, 1).toString());
				LastName.setText(model.getValueAt(i, 2).toString());
				Email.setText(model.getValueAt(i, 3).toString());
				Address.setText(model.getValueAt(i, 4).toString());
				Phone.setText(model.getValueAt(i, 5).toString());
				LicenseNumber.setText(model.getValueAt(i, 6).toString());
				Rewards.setText(model.getValueAt(i, 7).toString());

			}
		});
		table.setBounds(397, 145, 687, 472);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "id", "Last Name", "First Name", "Email",
				"Address", "Phone", "License ID", "Rewards" }));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		showUsersTable(model);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 145, 687, 472);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);

	}

	private void showUsersTable(DefaultTableModel model) {
		ArrayList<FrequentParkingUsersModel> frequentParkerModel = frequentParkingUser.parkingUsersList();
		Object[] row = new Object[8];

		for (int i = 0; i < frequentParkerModel.size(); i++) {
			row[0] = frequentParkerModel.get(i).getId();
			row[1] = frequentParkerModel.get(i).getLast_name();
			row[2] = frequentParkerModel.get(i).getFirst_name();
			row[3] = frequentParkerModel.get(i).getEmail();
			row[4] = frequentParkerModel.get(i).getAddress();
			row[5] = frequentParkerModel.get(i).getPhone();
			row[6] = frequentParkerModel.get(i).getLicense_id();
			row[7] = frequentParkerModel.get(i).getRewards();

			model.addRow(row);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
