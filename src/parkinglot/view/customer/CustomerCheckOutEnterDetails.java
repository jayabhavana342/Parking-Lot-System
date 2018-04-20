package parkinglot.view.customer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import parkinglot.controller.customer.CustomerCheckInEnterDetailsController;
import parkinglot.controller.customer.CustomerCheckOutEnterDetailsController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerCheckOutEnterDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField cardNumber;
	private JTextField cvv;
	private JTextField nameOnCard;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckOutEnterDetails window = new CustomerCheckOutEnterDetails();
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
	public CustomerCheckOutEnterDetails() {
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
		CustomerCheckOutEnterDetailsController controller = new CustomerCheckOutEnterDetailsController(this);

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
		panel.add(cardNumber);
		cardNumber.setColumns(10);

		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(38, 77, 148, 31);
		panel.add(lblCvv);
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Comic Sans MS", Font.BOLD, 17));

		cvv = new JTextField();
		cvv.setBounds(357, 75, 259, 31);
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

		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(213, 246, 183, 37);
		panel.add(btnCheckOut);
		btnCheckOut.setForeground(Color.BLACK);
		btnCheckOut.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnCheckOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(cardNumber.getText());
				System.out.println(cvv.getText());
				System.out.println(nameOnCard.getText());
				controller.retrieveCardDetails(cardNumber.getText(), new Integer(cvv.getText()), nameOnCard.getText());
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