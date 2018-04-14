/**
 * 
 */
package parkinglot.view.includes;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author bhavana
 *
 */
public class FooterPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FooterPanel() {
		JLabel bhavanaName = new JLabel("Bhavana");
		JLabel aishwaryaName = new JLabel("Aishwarya");
		JLabel michealName = new JLabel("Micheal");
		JLabel shivaranjaniName = new JLabel("Shivaranjani");
		JLabel mehakName = new JLabel("Mehak");
		
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		setLayout(new FlowLayout());
		add(bhavanaName);
		add(aishwaryaName);
		add(michealName);
		add(shivaranjaniName);
		add(mehakName);
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
