package parkinglot.view.customer.checkin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import parkinglot.controller.customer.checkin.CustomerCheckInEnterDetailsController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class CustomerCheckInEnterDetailsView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField cardNumber;
	private JTextField cvv;
	private JTextField nameOnCard;
	private JTextField vehicleNumber;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckInEnterDetailsView window = new CustomerCheckInEnterDetailsView();
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
	public CustomerCheckInEnterDetailsView() {
		initialize();

		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);

		JPanel cards = new JPanel();
		cards.setForeground(Color.WHITE);
		cards.setBackground(Color.LIGHT_GRAY);

		getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(null);

		JPanel centerHome = new JPanel();
		centerHome.setBounds(0, 26, 1, 591);
		centerHome.setBackground(Color.LIGHT_GRAY);
		cards.add(centerHome);
		centerHome.setLayout(null);
		CustomerCheckInEnterDetailsController controller = new CustomerCheckInEnterDetailsController(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(220, 166, 651, 305);
		cards.add(panel);
		panel.setLayout(null);

		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(38, 32, 148, 31);
		panel.add(lblCardNumber);
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		cardNumber = new JTextField();
		cardNumber.setBounds(357, 36, 259, 28);
		cardNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!Character.isDigit(arg0.getKeyChar())) {
					arg0.consume();
				}
			}
		});
		panel.add(cardNumber);
		cardNumber.setColumns(10);

		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(38, 77, 148, 31);
		panel.add(lblCvv);
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		cvv = new JTextField();
		cvv.setBounds(357, 75, 259, 31);
		cvv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!Character.isDigit(arg0.getKeyChar())) {
					arg0.consume();
				}
			}
		});
		panel.add(cvv);
		cvv.setColumns(10);

		JLabel lblNameOnCard = new JLabel("Name on Card");
		lblNameOnCard.setBounds(38, 116, 148, 31);
		panel.add(lblNameOnCard);
		lblNameOnCard.setForeground(Color.WHITE);
		lblNameOnCard.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		nameOnCard = new JTextField();
		nameOnCard.setBounds(357, 120, 259, 28);
		panel.add(nameOnCard);
		nameOnCard.setColumns(10);

		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setBounds(38, 158, 148, 31);
		panel.add(lblVehicleNumber);
		lblVehicleNumber.setForeground(Color.WHITE);
		lblVehicleNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		vehicleNumber = new JTextField();
		vehicleNumber.setBounds(357, 158, 259, 28);
		panel.add(vehicleNumber);
		vehicleNumber.setColumns(10);

		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setBounds(38, 200, 148, 31);
		panel.add(lblVehicleType);
		lblVehicleType.setForeground(Color.WHITE);
		lblVehicleType.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		JButton chooseSlot = new JButton("Choose a Slot");
		chooseSlot.setBounds(213, 246, 183, 37);
		panel.add(chooseSlot);
		chooseSlot.setForeground(Color.BLACK);
		chooseSlot.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(357, 197, 259, 34);
		comboBox.addItem("Car");
		comboBox.addItem("Bus");
		comboBox.addItem("MOTORCYCLE");
		panel.add(comboBox);
		chooseSlot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(comboBox.getSelectedItem());
				if(cardNumber.getText().equals("")  || cvv.getText().equals("")  || nameOnCard.getText().equals("")  || vehicleNumber.getText().equals("") || comboBox.getSelectedItem().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter all the details");
				}
				else
				{
					controller.parseDetails(cardNumber.getText(), cvv.getText(), nameOnCard.getText(),
							vehicleNumber.getText(), String.valueOf(comboBox.getSelectedItem()));
				}
				

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
