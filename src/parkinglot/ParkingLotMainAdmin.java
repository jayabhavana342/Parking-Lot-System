/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.admin.*;



/**
 * @author bhavana
 *
 */
public class ParkingLotMainAdmin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(() -> {
            try {
                LoginView frame = new LoginView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

	}

}
