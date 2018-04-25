package parkinglot.view.admin;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import parkinglot.controller.admin.UpdateRateController;
import parkinglot.view.includes.FooterPanel;
import parkinglot.view.includes.HeaderPanel;
import parkinglot.view.includes.MenuBar;

/**
 * @author AishwaryaRana
 *
 */

public class UpdateRatesView extends JFrame {
	public JTextField currentRate;
	private JTextField NewRate;
	UpdateRateController controller;

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
					UpdateRatesView window = new UpdateRatesView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTextField getTextField() {
		return currentRate;
	}

	public void setTextField(JTextField textField) {
		this.currentRate = textField;
	}

	public JTextField getTextField_1() {
		return NewRate;
	}

	public void setTextField_1(JTextField textField_1) {
		this.NewRate = textField_1;
	}

	/**
	 * Create the application.
	 */
	public UpdateRatesView() {
		initialize();
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new HeaderPanel(), BorderLayout.NORTH);
		getContentPane().add(new FooterPanel(), BorderLayout.SOUTH);

		JPanel cards = new JPanel();
		cards.setForeground(Color.WHITE);
		cards.setBackground(Color.LIGHT_GRAY);
		UpdateRateController controller = new UpdateRateController(this);

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

		JLabel lblCurrentRate = new JLabel("Current Rate");
		lblCurrentRate.setBounds(274, 151, 81, 26);
		cards.add(lblCurrentRate);

		currentRate = new JTextField();

		currentRate.setBounds(393, 153, 116, 22);
		cards.add(currentRate);
		currentRate.setColumns(10);
		JLabel lblNewRate = new JLabel("New Rate");
		lblNewRate.setBounds(287, 211, 56, 16);
		cards.add(lblNewRate);

		NewRate = new JTextField();
		NewRate.setColumns(10);
		NewRate.setBounds(393, 208, 116, 22);
		cards.add(NewRate);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.update(new Float(NewRate.getText()));
				if (currentRate.getText() == NewRate.getText()) {
					JOptionPane.showMessageDialog(null, "Enter a new rate!");
				}
				if (NewRate.getText() == " ") {
					JOptionPane.showMessageDialog(null, "Please enter a new rate to update");
				} else {
					controller.update(new Float(NewRate.getText()));
				}

			}
		});
		btnSubmit.setBounds(341, 278, 97, 25);
		cards.add(btnSubmit);

		JLabel label = new JLabel("");
		label.setBounds(571, 156, 56, 16);
		cards.add(label);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(500, 500, 1100, 800);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
