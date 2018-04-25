package parkinglot.view.customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import parkinglot.controller.customer.CustomerCheckOutOrUseRewardsController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class CustomerCheckOutOrUseRewardsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField enterRewardsToBeUsed;
	public JTextField vehicleNo;
	public JTextField vehicleType;
	public JTextField InTime;
	public JTextField OutTime;
	public JTextField noOfDays;
	public JTextField rate;
	public JTextField amount;
	public JPanel panel_1;
	public JPanel panel;
	private JTextField phoneNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckOutOrUseRewardsView window = new CustomerCheckOutOrUseRewardsView();
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
	public CustomerCheckOutOrUseRewardsView() {
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

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(160, 49, 785, 496);
		cards.add(panel);
		panel.setLayout(null);

		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setForeground(Color.WHITE);
		lblVehicleNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleNumber.setBounds(34, 84, 148, 31);
		panel.add(lblVehicleNumber);

		JLabel helloCustomer = new JLabel("");
		helloCustomer.setForeground(Color.WHITE);
		helloCustomer.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		helloCustomer.setBounds(35, 11, 235, 45);
		panel.add(helloCustomer);

		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setForeground(Color.WHITE);
		lblVehicleType.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleType.setBounds(34, 122, 148, 31);
		panel.add(lblVehicleType);

		JLabel lblInTime = new JLabel("In Time");
		lblInTime.setForeground(Color.WHITE);
		lblInTime.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblInTime.setBounds(34, 159, 148, 31);
		panel.add(lblInTime);

		JLabel lblOutTime = new JLabel("Out Time\r\n");
		lblOutTime.setForeground(Color.WHITE);
		lblOutTime.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblOutTime.setBounds(34, 203, 148, 31);
		panel.add(lblOutTime);

		JLabel lblParkingRateday = new JLabel("Parking Rate/day");
		lblParkingRateday.setForeground(Color.WHITE);
		lblParkingRateday.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblParkingRateday.setBounds(34, 284, 148, 31);
		panel.add(lblParkingRateday);

		JLabel lblTotalAmountTo = new JLabel("Amount to be paid");
		lblTotalAmountTo.setForeground(Color.WHITE);
		lblTotalAmountTo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblTotalAmountTo.setBounds(34, 326, 229, 31);
		panel.add(lblTotalAmountTo);

		JLabel lblNoOfDays = new JLabel("No. of days");
		lblNoOfDays.setForeground(Color.WHITE);
		lblNoOfDays.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNoOfDays.setBounds(34, 245, 148, 31);
		panel.add(lblNoOfDays);

		vehicleNo = new JTextField();
		vehicleNo.setEditable(false);
		vehicleNo.setBackground(Color.LIGHT_GRAY);
		vehicleNo.setColumns(10);
		vehicleNo.setBounds(219, 88, 157, 28);
		panel.add(vehicleNo);
		vehicleNo.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		vehicleType = new JTextField();
		vehicleType.setEditable(false);
		vehicleType.setBackground(Color.LIGHT_GRAY);
		vehicleType.setColumns(10);
		vehicleType.setBounds(219, 126, 157, 28);
		panel.add(vehicleType);
		vehicleType.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		InTime = new JTextField();
		InTime.setEditable(false);
		InTime.setBackground(Color.LIGHT_GRAY);
		InTime.setColumns(10);
		InTime.setBounds(219, 163, 157, 28);
		panel.add(InTime);
		InTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		OutTime = new JTextField();
		OutTime.setEditable(false);
		OutTime.setBackground(Color.LIGHT_GRAY);
		OutTime.setColumns(10);
		OutTime.setBounds(219, 204, 157, 28);
		panel.add(OutTime);
		OutTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		noOfDays = new JTextField();
		noOfDays.setEditable(false);
		noOfDays.setBackground(Color.LIGHT_GRAY);
		noOfDays.setColumns(10);
		noOfDays.setBounds(219, 249, 157, 28);
		panel.add(noOfDays);
		noOfDays.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		rate = new JTextField();
		rate.setEditable(false);
		rate.setBackground(Color.LIGHT_GRAY);
		rate.setColumns(10);
		rate.setBounds(219, 288, 157, 28);
		panel.add(rate);
		rate.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		amount = new JTextField();
		amount.setEditable(false);
		amount.setBackground(Color.LIGHT_GRAY);
		amount.setColumns(10);
		amount.setBounds(248, 330, 128, 28);
		panel.add(amount);
		amount.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton_1.setBounds(347, 421, 148, 62);
		panel.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(388, 33, 385, 165);
		panel.add(panel_2);

		phoneNo = new JTextField();
		phoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		phoneNo.setColumns(10);
		phoneNo.setBounds(135, 77, 167, 32);
		panel_2.add(phoneNo);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblPhoneNo.setBounds(22, 78, 89, 28);
		panel_2.add(lblPhoneNo);

		CustomerCheckOutOrUseRewardsController controller = new CustomerCheckOutOrUseRewardsController(this);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.checkIfFrequentParkerBasedOnPhoneNumber(phoneNo.getText());
			}
		});

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(388, 211, 385, 159);
		panel_1.setLayout(null);
		System.out.println();
		// panel.add(panel_1);

		JLabel displayRewardsLabel = new JLabel("Use Frequent Parker Rewards");
		displayRewardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displayRewardsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		displayRewardsLabel.setBounds(0, 11, 385, 32);
		panel_1.add(displayRewardsLabel);

		JLabel availableRewardsLabel = new JLabel("$ rewards");
		availableRewardsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		availableRewardsLabel.setForeground(new Color(50, 205, 50));
		availableRewardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableRewardsLabel.setBounds(96, 38, 211, 24);
		panel_1.add(availableRewardsLabel);

		enterRewardsToBeUsed = new JTextField();
		enterRewardsToBeUsed.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		enterRewardsToBeUsed.setBounds(86, 75, 271, 32);
		panel_1.add(enterRewardsToBeUsed);
		enterRewardsToBeUsed.setColumns(10);

		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setBounds(59, 77, 11, 28);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.setBounds(120, 120, 89, 32);
		panel_1.add(btnNewButton);

		btnEnter.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEnter.setBounds(134, 130, 89, 32);
		panel_2.add(btnEnter);

		// panel_1.setVisible(true);
		// cards.add(panel_1);

		JLabel lblToUseRewards = new JLabel("To use Rewards, \r\nenter your registered Phone No.");
		lblToUseRewards.setHorizontalAlignment(SwingConstants.CENTER);
		lblToUseRewards.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblToUseRewards.setBounds(0, 13, 395, 64);
		panel_2.add(lblToUseRewards);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
