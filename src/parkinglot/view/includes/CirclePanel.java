/**
 * 
 */
package parkinglot.view.includes;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author bhavana
 *
 */
public class CirclePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CirclePanel panel = new CirclePanel();
		panel.setVisible(true);

	}

}
