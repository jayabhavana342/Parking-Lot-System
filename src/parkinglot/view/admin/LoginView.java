package parkinglot.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import parkinglot.controller.admin.LoginController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;

public class LoginView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public JLabel lblErrorMessage;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
		
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		
		
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);		
		
		

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(308, 147, 436, 277);
		centerPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBounds(54, 44, 136, 27);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPassword.setBounds(54, 97, 136, 27);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(220, 44, 171, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 97, 171, 27);
		panel.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(173, 179, 106, 39);
		

		LoginController controller = new LoginController(this);
		btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.checkCredentials(textField.getText(), new String(passwordField.getPassword()));
            }
        });
		
		panel.add(btnSubmit);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500,500,1100,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setErrorMessage(String errorMessage) {
        lblErrorMessage.setText(errorMessage);
    }
}
