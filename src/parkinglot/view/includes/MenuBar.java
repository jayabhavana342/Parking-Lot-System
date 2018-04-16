/**
 * 
 */
package parkinglot.view.includes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

import parkinglot.view.admin.AdminHomeView;
import parkinglot.view.admin.LoginView;
import parkinglot.view.admin.RegisterCustomerView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author bhavana
 *
 */
public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menu_1;

	public MenuBar() {
		// TODO Auto-generated constructor stub

		JMenu menu = new JMenu("Home");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomeView adminHomeView = new AdminHomeView();
				adminHomeView.setVisible(true);
				adminHomeView.setLocationRelativeTo(null);
			}
		});
		menu.setFont(new Font("Jokerman", Font.BOLD, 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu_1 = new JMenu("Register Customer");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterCustomerView registerCustomerView = new RegisterCustomerView();
				registerCustomerView.setVisible(true);
				registerCustomerView.setLocationRelativeTo(null);
			}
		});
		menu_1.setFont(new Font("Jokerman", Font.BOLD, 15));
		add(menu_1);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("Update Rates");
		menu.setFont(new Font("Jokerman", Font.BOLD, 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("View Reports");
		menu.setFont(new Font("Jokerman", Font.BOLD, 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("Logout");
		menu.setFont(new Font("Jokerman", Font.BOLD, 15));
		add(menu);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar window = new MenuBar();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
