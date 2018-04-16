package parkinglot.view.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerChooseSlotsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JTextField cardNumber;
	public JTextField cvv;
	public JTextField nameOnCard;
	public JTextField vehicleNo;
	public JTextField vehicleType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerChooseSlotsView window = new CustomerChooseSlotsView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerChooseSlotsView() {
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

		cardNumber = new JTextField();
		cardNumber.setBounds(351, 84, 168, 33);
		cards.add(cardNumber);
		cardNumber.setColumns(10);

		cvv = new JTextField();
		cvv.setColumns(10);
		cvv.setBounds(351, 139, 168, 33);
		cards.add(cvv);

		nameOnCard = new JTextField();
		nameOnCard.setColumns(10);
		nameOnCard.setBounds(351, 193, 168, 33);
		cards.add(nameOnCard);

		vehicleNo = new JTextField();
		vehicleNo.setColumns(10);
		vehicleNo.setBounds(351, 248, 168, 33);
		cards.add(vehicleNo);

		vehicleType = new JTextField();
		vehicleType.setColumns(10);
		vehicleType.setBounds(351, 301, 168, 33);
		cards.add(vehicleType);

		JButton btnNewButton = new JButton("Enter into Db");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(293, 405, 168, 33);
		cards.add(btnNewButton);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
