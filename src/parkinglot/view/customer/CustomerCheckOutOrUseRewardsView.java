package parkinglot.view.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerCheckOutOrUseRewardsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField enterRewardsToBeUsed;

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(220, 98, 651, 408);
		cards.add(panel);
		panel.setLayout(null);

		JLabel helloCustomer = new JLabel("");
		helloCustomer.setForeground(Color.WHITE);
		helloCustomer.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		helloCustomer.setBounds(35, 11, 235, 45);
		panel.add(helloCustomer);

		JLabel vehicleNumLabel = new JLabel("New label");
		vehicleNumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		vehicleNumLabel.setForeground(Color.WHITE);
		vehicleNumLabel.setBounds(93, 76, 177, 31);
		panel.add(vehicleNumLabel);

		JLabel vehicleTypeLabel = new JLabel("New label");
		vehicleTypeLabel.setForeground(Color.WHITE);
		vehicleTypeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		vehicleTypeLabel.setBounds(93, 118, 177, 31);
		panel.add(vehicleTypeLabel);

		JLabel levelNumLabel = new JLabel("New label");
		levelNumLabel.setForeground(Color.WHITE);
		levelNumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		levelNumLabel.setBounds(93, 160, 177, 31);
		panel.add(levelNumLabel);

		JLabel slotNumLabel = new JLabel("New label");
		slotNumLabel.setForeground(Color.WHITE);
		slotNumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		slotNumLabel.setBounds(93, 202, 177, 31);
		panel.add(slotNumLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(289, 61, 312, 199);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel displayRewardsLabel = new JLabel("Use Frequent Parker Rewards");
		displayRewardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displayRewardsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		displayRewardsLabel.setBounds(10, 11, 292, 32);
		panel_1.add(displayRewardsLabel);

		JLabel availableRewardsLabel = new JLabel("$ rewards");
		availableRewardsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		availableRewardsLabel.setForeground(new Color(50, 205, 50));
		availableRewardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableRewardsLabel.setBounds(50, 38, 211, 24);
		panel_1.add(availableRewardsLabel);

		enterRewardsToBeUsed = new JTextField();
		enterRewardsToBeUsed.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		enterRewardsToBeUsed.setBounds(31, 90, 271, 32);
		panel_1.add(enterRewardsToBeUsed);
		enterRewardsToBeUsed.setColumns(10);

		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 90, 11, 28);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.setBounds(213, 143, 89, 32);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton_1.setBounds(265, 303, 148, 62);
		panel.add(btnNewButton_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
