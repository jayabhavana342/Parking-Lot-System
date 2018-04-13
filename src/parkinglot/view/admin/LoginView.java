/**
 * 
 */
package parkinglot.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import parkinglot.controller.admin.LoginController;

/**
 * @author bhavana
 *
 */
public class LoginView extends JFrame{
	
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblErrorMessage;

	
	public LoginView() {
		// TODO Auto-generated constructor stub
		
		frame = new JFrame();
		setBounds(200, 200, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Parking Lot System");
		lblNewLabel.setBounds(191, 13, 145, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(56, 87, 69, 16);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(56, 142, 69, 16);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(206, 84, 186, 22);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(206, 139, 186, 22);
		getContentPane().add(txtPassword);
		
		
		
		LoginController controller = new LoginController(this);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()));
            }
        });
		
		btnLogin.setBounds(101, 193, 97, 25);
		getContentPane().add(btnLogin);
		
		lblErrorMessage = new JLabel("");
        lblErrorMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblErrorMessage.setBounds(10, 151, 330, 25);
        getContentPane().add(lblErrorMessage);
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
