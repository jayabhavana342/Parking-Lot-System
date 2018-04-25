package parkinglot.view.customer.checkin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import parkinglot.model.customer.ParkingLevelsSlotsModel;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class CustomerCheckInHomePageView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParkingLevelsSlotsModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckInHomePageView window = new CustomerCheckInHomePageView();
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
	public CustomerCheckInHomePageView() {
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

		JLabel lblWelcome = new JLabel("Welcome..!!");
		lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblWelcome.setBounds(222, 82, 196, 30);
		cards.add(lblWelcome);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(220, 166, 651, 283);
		cards.add(panel);
		panel.setLayout(null);

		if (model.checkSlotsAvailability()) {
			System.out.println("true");

			JButton btnCheckIn = new JButton("Check In");
			btnCheckIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CustomerCheckInEnterDetailsView customerCheckInEnterDetails = new CustomerCheckInEnterDetailsView();
					customerCheckInEnterDetails.setVisible(true);
					customerCheckInEnterDetails.setLocationRelativeTo(null);
					dispose();
				}
			});
			btnCheckIn.setForeground(Color.ORANGE);
			btnCheckIn.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
			btnCheckIn.setBounds(214, 35, 216, 108);
			panel.add(btnCheckIn);

			JLabel carLotsAvailable = new JLabel("Available Car Slots: " + String.valueOf(model.carLotsAvailable()));
			carLotsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
			carLotsAvailable.setForeground(Color.WHITE);
			carLotsAvailable.setBounds(68, 177, 216, 47);
			panel.add(carLotsAvailable);

			JLabel busLotsAvailable = new JLabel("Available Bus Slots: " + String.valueOf(model.busLotsAvailable()));
			busLotsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
			busLotsAvailable.setForeground(Color.WHITE);
			busLotsAvailable.setBounds(379, 177, 216, 47);
			panel.add(busLotsAvailable);

			JLabel bikeLotsAvailable = new JLabel("Available Bike Slots: " + String.valueOf(model.bikeLotsAvailable()));
			bikeLotsAvailable.setForeground(Color.WHITE);
			bikeLotsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
			bikeLotsAvailable.setBounds(233, 225, 216, 47);
			panel.add(bikeLotsAvailable);
		} else {
			JLabel lblNoSlotsAvailable = new JLabel("NO SLOTS AVAILABLE");
			lblNoSlotsAvailable.setForeground(Color.RED);
			lblNoSlotsAvailable.setHorizontalAlignment(SwingConstants.CENTER);
			lblNoSlotsAvailable.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			lblNoSlotsAvailable.setBounds(129, 77, 388, 111);
			panel.add(lblNoSlotsAvailable);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		model = new ParkingLevelsSlotsModel();
	}
}
