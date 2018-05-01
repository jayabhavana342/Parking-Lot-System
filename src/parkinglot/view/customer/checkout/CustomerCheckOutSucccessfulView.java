package parkinglot.view.customer.checkout;

import java.awt.*;
import javax.swing.*;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class CustomerCheckOutSucccessfulView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckOutSucccessfulView window = new CustomerCheckOutSucccessfulView();
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
	public CustomerCheckOutSucccessfulView() {
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

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(220, 98, 651, 408);
		cards.add(panel);
		panel.setLayout(null);

		JLabel thankYou = new JLabel("Thank you, Visit Again!!");
		thankYou.setForeground(Color.RED);
		thankYou.setHorizontalAlignment(SwingConstants.CENTER);
		thankYou.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		thankYou.setBounds(128, 141, 388, 111);
		panel.add(thankYou);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
