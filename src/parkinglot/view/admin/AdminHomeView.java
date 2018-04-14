/**
 * 
 */
package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;


import parkinglot.view.includes.*;
/**
 * @author bhavana
 *
 */
public class AdminHomeView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel welcomeLabel;
	
	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public void setWelcomeLabel(JLabel welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
	}

	public AdminHomeView() {
		// TODO Auto-generated constructor stub

		setBounds(500,500,1100,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);
		
		JPanel cards = new JPanel();
		cards.setLayout(new BoxLayout(cards, BoxLayout.PAGE_AXIS));
		JPanel card1 = new JPanel();
		card1.add(new MenuBar());
		card1.setBorder(BorderFactory.createLineBorder(Color.black));
		card1.setMaximumSize(new Dimension(Integer.MAX_VALUE, card1.getMaximumSize().height));
		
		JPanel card2 = new JPanel();
		welcomeLabel = new JLabel();
		welcomeLabel.setFont(new Font("Jokerman", Font.BOLD , 25));
		card2.add(welcomeLabel);
		card2.setBackground(Color.BLACK);
		card2.setMaximumSize(new Dimension(Integer.MAX_VALUE, card2.getMaximumSize().height));
		
		cards.add(card1);
		cards.add(card2);
		
		getContentPane().add(cards, BorderLayout.CENTER);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminHomeView view = new AdminHomeView();
        view.setVisible(true);

	}

}
