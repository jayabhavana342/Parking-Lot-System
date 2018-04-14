/**
 * 
 */
package parkinglot.view.admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import parkinglot.controller.admin.LoginController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

/**
 * @author bhavana
 *
 */

public class LoginView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblErrorMessage;
	
	

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	/**
	 * 
	 */
	public LoginView() {
		// TODO Auto-generated constructor stub
		
		new JFrame();
		setBounds(500,500,1100,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		
		
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);
		
//		JPanel westPanel = new JPanel();
//		getContentPane().add(westPanel, BorderLayout.WEST);
//		
//		JPanel eastPanel = new JPanel();
//		getContentPane().add(eastPanel, BorderLayout.EAST);
		
		
		
		JLabel lblUsername = new JLabel("Email");
		JLabel lblPassword = new JLabel("Password");
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		
		LoginController controller = new LoginController(this);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()));
            }
        });
		
		lblErrorMessage = new JLabel("");
        lblErrorMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerPanel.add(lblUsername);
		centerPanel.add(txtUsername);
		centerPanel.add(lblPassword);
		centerPanel.add(txtPassword);
		centerPanel.add(btnLogin);
		centerPanel.add(lblErrorMessage);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		
	}
	
	public void setErrorMessage(String errorMessage) {
        lblErrorMessage.setText(errorMessage);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginView view = new LoginView();
        view.setVisible(true);
        
	}

}
