package parkinglot.view.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import parkinglot.controller.customer.CustomerCheckOutEnterDetailsController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class CustomerCheckOutDisplayDetails extends JFrame{
	public JTextField vehicleNo;
	public JTextField vehicleType;
	public JTextField InTime;
	public JTextField OutTime;
	public JTextField noOfDays;
	public JTextField rate;
	public JTextField amount;
	
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckOutDisplayDetails window = new CustomerCheckOutDisplayDetails();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CustomerCheckOutDisplayDetails() {
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
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setForeground(Color.WHITE);
		lblVehicleNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleNumber.setBounds(324, 93, 148, 31);
		cards.add(lblVehicleNumber);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setForeground(Color.WHITE);
		lblVehicleType.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleType.setBounds(324, 137, 148, 31);
		cards.add(lblVehicleType);
		
		JLabel lblInTime = new JLabel("In Time");
		lblInTime.setForeground(Color.WHITE);
		lblInTime.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblInTime.setBounds(324, 181, 148, 31);
		cards.add(lblInTime);
		
		JLabel lblOutTime = new JLabel("Out Time\r\n");
		lblOutTime.setForeground(Color.WHITE);
		lblOutTime.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblOutTime.setBounds(324, 225, 148, 31);
		cards.add(lblOutTime);
		
		JLabel lblParkingRateday = new JLabel("Parking Rate/day");
		lblParkingRateday.setForeground(Color.WHITE);
		lblParkingRateday.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblParkingRateday.setBounds(324, 313, 148, 31);
		cards.add(lblParkingRateday);
		
		JLabel lblTotalAmountTo = new JLabel("Total Amount to be paid");
		lblTotalAmountTo.setForeground(Color.WHITE);
		lblTotalAmountTo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblTotalAmountTo.setBounds(324, 348, 229, 31);
		cards.add(lblTotalAmountTo);
		
		JLabel lblNoOfDays = new JLabel("No. of days");
		lblNoOfDays.setForeground(Color.WHITE);
		lblNoOfDays.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNoOfDays.setBounds(324, 269, 148, 31);
		cards.add(lblNoOfDays);
		
		vehicleNo = new JTextField();
		vehicleNo.setEditable(false);
		vehicleNo.setBackground(Color.LIGHT_GRAY);
		vehicleNo.setColumns(10);
		vehicleNo.setBounds(565, 96, 259, 28);
		cards.add(vehicleNo);
		vehicleNo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		vehicleType = new JTextField();
		vehicleType.setEditable(false);
		vehicleType.setBackground(Color.LIGHT_GRAY);
		vehicleType.setColumns(10);
		vehicleType.setBounds(565, 137, 259, 28);
		cards.add(vehicleType);
		vehicleType.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		InTime = new JTextField();
		InTime.setEditable(false);
		InTime.setBackground(Color.LIGHT_GRAY);
		InTime.setColumns(10);
		InTime.setBounds(565, 178, 259, 28);
		cards.add(InTime);
		InTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		OutTime = new JTextField();
		OutTime.setEditable(false);
		OutTime.setBackground(Color.LIGHT_GRAY);
		OutTime.setColumns(10);
		OutTime.setBounds(565, 219, 259, 28);
		cards.add(OutTime);
		OutTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		noOfDays = new JTextField();
		noOfDays.setEditable(false);
		noOfDays.setBackground(Color.LIGHT_GRAY);
		noOfDays.setColumns(10);
		noOfDays.setBounds(565, 269, 259, 28);
		cards.add(noOfDays);
		noOfDays.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		rate = new JTextField();
		rate.setEditable(false);
		rate.setBackground(Color.LIGHT_GRAY);
		rate.setColumns(10);
		rate.setBounds(565, 310, 259, 28);
		cards.add(rate);
		rate.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		amount = new JTextField();
		amount.setEditable(false);
		amount.setBackground(Color.LIGHT_GRAY);
		amount.setColumns(10);
		amount.setBounds(565, 351, 259, 28);
		cards.add(amount);
		amount.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JButton btnProceedToPayments = new JButton("Proceed to Payments");
		btnProceedToPayments.setForeground(Color.BLACK);
		btnProceedToPayments.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnProceedToPayments.setBounds(448, 451, 274, 37);
		cards.add(btnProceedToPayments);
		//CustomerCheckOutDisplayDetailsController controller = new CustomerCheckOutDisplayDetailsController(this);
	}
	
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}