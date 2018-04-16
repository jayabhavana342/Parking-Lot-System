package parkinglot.view.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import parkinglot.controller.admin.LoginController;
import parkinglot.controller.customer.CustomerCheckInEnterDetailsController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerCheckInEnterDetails extends JFrame{
	private JTextField cardNumber;
	private JTextField cvv;
	private JTextField nameOnCard;
	private JTextField vehicleNumber;
	private JTextField vehicleType;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckInEnterDetails window = new CustomerCheckInEnterDetails();
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
	public CustomerCheckInEnterDetails() {
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
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCardNumber.setBounds(267, 107, 148, 31);
		cards.add(lblCardNumber);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCvv.setBounds(267, 161, 148, 31);
		cards.add(lblCvv);
		
		JLabel lblNameOnCard = new JLabel("Name on Card");
		lblNameOnCard.setForeground(Color.WHITE);
		lblNameOnCard.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNameOnCard.setBounds(267, 216, 148, 31);
		cards.add(lblNameOnCard);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setForeground(Color.WHITE);
		lblVehicleNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleNumber.setBounds(267, 277, 148, 31);
		cards.add(lblVehicleNumber);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setForeground(Color.WHITE);
		lblVehicleType.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblVehicleType.setBounds(267, 334, 148, 31);
		cards.add(lblVehicleType);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(464, 107, 259, 28);
		cards.add(cardNumber);
		cardNumber.setColumns(10);
		
		cvv = new JTextField();
		cvv.setColumns(10);
		cvv.setBounds(464, 161, 259, 28);
		cards.add(cvv);
		
		nameOnCard = new JTextField();
		nameOnCard.setColumns(10);
		nameOnCard.setBounds(464, 216, 259, 28);
		cards.add(nameOnCard);
		
		vehicleNumber = new JTextField();
		vehicleNumber.setColumns(10);
		vehicleNumber.setBounds(464, 280, 259, 28);
		cards.add(vehicleNumber);
		
		vehicleType = new JTextField();
		vehicleType.setColumns(10);
		vehicleType.setBounds(464, 337, 259, 28);
		cards.add(vehicleType);
		
		JButton chooseSlot = new JButton("Choose a Slot");
		chooseSlot.setForeground(Color.BLACK);
		chooseSlot.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		chooseSlot.setBounds(394, 420, 183, 37);
		CustomerCheckInEnterDetailsController controller = new CustomerCheckInEnterDetailsController(this);
		chooseSlot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.parseDetails(cardNumber.getText(),cvv.getText(),nameOnCard.getText(),vehicleNumber.getText(),vehicleType.getText());
            }
        });
		cards.add(chooseSlot);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
