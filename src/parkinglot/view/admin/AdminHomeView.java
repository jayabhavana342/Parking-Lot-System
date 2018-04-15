package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import parkinglot.view.admin.AdminHomeView;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import parkinglot.view.includes.MenuBar;
import java.awt.Font;

public class AdminHomeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel welcomeLabel;
	public JLabel totalAmountEarned;
	public JLabel frequentParkers;
	public JLabel emptySlots;
	public JLabel carsParked;
	public JLabel todaysRate;

	public AdminHomeView() {
		initialize();

		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);

		JPanel cards = new JPanel();
		cards.setForeground(Color.WHITE);
		cards.setBackground(Color.BLACK);

		getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(null);
		MenuBar menuBar = new MenuBar();
		menuBar.setBounds(0, 0, 1084, 26);
		cards.add(menuBar);
		
		JPanel centerHome = new JPanel();
		centerHome.setBounds(0, 26, 1, 591);
		centerHome.setBackground(Color.LIGHT_GRAY);
		cards.add(centerHome);
		centerHome.setLayout(null);

		welcomeLabel = new JLabel();
		welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setBounds(187, 43, 400, 40);
		centerHome.add(welcomeLabel);

		JLabel todaysRateLabel = new JLabel("Today's Parking Rate");
		todaysRateLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		todaysRateLabel.setBounds(182, 148, 226, 40);
		cards.add(todaysRateLabel);
		todaysRateLabel.setForeground(Color.WHITE);

		System.out.println(todaysRateLabel);

		JLabel carsParkedLabel = new JLabel("Cars Parked");
		carsParkedLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		carsParkedLabel.setForeground(Color.WHITE);
		carsParkedLabel.setBounds(182, 195, 226, 40);
		cards.add(carsParkedLabel);

		JLabel emptySlotsLabel = new JLabel("Empty Slots");
		emptySlotsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		emptySlotsLabel.setForeground(Color.WHITE);
		emptySlotsLabel.setBounds(182, 246, 226, 40);
		cards.add(emptySlotsLabel);

		JLabel frequentParkersLabel = new JLabel("Frequent Parkers");
		frequentParkersLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		frequentParkersLabel.setForeground(Color.WHITE);
		frequentParkersLabel.setBounds(182, 297, 226, 40);
		cards.add(frequentParkersLabel);

		JLabel totalAmountEarnedLabel = new JLabel("Total Amount Earned");
		totalAmountEarnedLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		totalAmountEarnedLabel.setForeground(Color.WHITE);
		totalAmountEarnedLabel.setBounds(182, 388, 226, 40);
		cards.add(totalAmountEarnedLabel);
		
		todaysRate = new JLabel();
		todaysRate.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		todaysRate.setForeground(Color.WHITE);
		todaysRate.setBounds(451, 148, 226, 40);
		cards.add(todaysRate);

		carsParked = new JLabel();
		carsParked.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		carsParked.setForeground(Color.WHITE);
		carsParked.setBounds(451, 195, 226, 40);
		cards.add(carsParked);

		emptySlots = new JLabel();
		emptySlots.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		emptySlots.setForeground(Color.WHITE);
		emptySlots.setBounds(451, 246, 226, 40);
		cards.add(emptySlots);

		frequentParkers = new JLabel();
		frequentParkers.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		frequentParkers.setForeground(Color.WHITE);
		frequentParkers.setBounds(451, 297, 226, 40);
		cards.add(frequentParkers);

		totalAmountEarned = new JLabel();
		totalAmountEarned.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		totalAmountEarned.setForeground(Color.WHITE);
		totalAmountEarned.setBounds(451, 388, 226, 40);
		cards.add(totalAmountEarned);

	}


	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}


	public void setWelcomeLabel(JLabel welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
	}


	public JLabel getTotalAmountEarned() {
		return totalAmountEarned;
	}


	public void setTotalAmountEarned(JLabel totalAmountEarned) {
		this.totalAmountEarned = totalAmountEarned;
	}


	public JLabel getFrequentParkers() {
		return frequentParkers;
	}


	public void setFrequentParkers(JLabel frequentParkers) {
		this.frequentParkers = frequentParkers;
	}


	public JLabel getEmptySlots() {
		return emptySlots;
	}


	public void setEmptySlots(JLabel emptySlots) {
		this.emptySlots = emptySlots;
	}


	public JLabel getCarsParked() {
		return carsParked;
	}


	public void setCarsParked(JLabel carsParked) {
		this.carsParked = carsParked;
	}


	public JLabel getTodaysRate() {
		return todaysRate;
	}


	public void setTodaysRate(JLabel todaysRate) {
		this.todaysRate = todaysRate;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomeView window = new AdminHomeView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
