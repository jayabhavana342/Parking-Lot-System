/**
 * 
 */
package parkinglot.view.includes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * @author bhavana
 *
 */
public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MenuBar() {
		// TODO Auto-generated constructor stub
		
		JMenu menu = new JMenu("Register Customer");
		menu.setFont(new Font("Jokerman", Font.BOLD , 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("Update Rates");
		menu.setFont(new Font("Jokerman", Font.BOLD , 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("View Reports");
		menu.setFont(new Font("Jokerman", Font.BOLD , 15));
		add(menu);
		menu = new JMenu("|");
		add(menu);
		menu = new JMenu("Logout");
		menu.setFont(new Font("Jokerman", Font.BOLD , 15));
		add(menu);
		
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuBar view = new MenuBar();
        view.setVisible(true);
	}

}
