package parkinglot.view.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import parkinglot.view.includes.MenuBar;
import javax.swing.JLabel;
import java.awt.Font;

public class CustomerCheckInHomePage extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCheckInHomePage window = new CustomerCheckInHomePage();
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
	public CustomerCheckInHomePage() {
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
