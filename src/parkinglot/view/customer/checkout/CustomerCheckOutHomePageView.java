package parkinglot.view.customer.checkout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class CustomerCheckOutHomePageView extends JFrame {

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
					CustomerCheckOutHomePageView window = new CustomerCheckOutHomePageView();
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
	public CustomerCheckOutHomePageView() {
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
		panel.setBounds(220, 166, 651, 283);
		cards.add(panel);
		panel.setLayout(null);

		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerCheckOutEnterDetailsView customerCheckOutEnterDetails = new CustomerCheckOutEnterDetailsView();
				customerCheckOutEnterDetails.setVisible(true);
				customerCheckOutEnterDetails.setLocationRelativeTo(null);
				dispose();
			}
		});

		btnCheckOut.setForeground(Color.ORANGE);
		btnCheckOut.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btnCheckOut.setBounds(217, 84, 216, 108);
		panel.add(btnCheckOut);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
