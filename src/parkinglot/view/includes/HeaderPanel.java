/**
 * 
 */
package parkinglot.view.includes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author bhavana
 *
 */
public class HeaderPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeaderPanel() {
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("<html><font color='white'>Parking Lot System</font></html>");
		lblNewLabel.setFont(new Font("Jokerman", Font.BOLD, 40));

		JLabel picLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\bhava\\git\\Parking-Lot-System\\src\\images\\logo.jpg");
		Image image = imageIcon.getImage();
		Image newimage = image.getScaledInstance(175, 100, Image.SCALE_SMOOTH);
		picLabel.setIcon(new ImageIcon(newimage));

		JLabel picLabel2 = new JLabel();

		Image image2 = imageIcon.getImage();
		Image newimage2 = image2.getScaledInstance(175, 100, Image.SCALE_SMOOTH);
		picLabel2.setIcon(new ImageIcon(newimage2));

		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.BLACK);

		add(picLabel);
		add(lblNewLabel);
		add(picLabel2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
