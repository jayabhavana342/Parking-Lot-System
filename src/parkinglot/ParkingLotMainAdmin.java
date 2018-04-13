/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.admin.*;
import parkinglot.controller.admin.*;



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
//                AddFrequentParkingLotUser frame2 = new AddFrequentParkingLotUser(frame);
//                LoginController controller = new LoginController(frame);
//                controller.contol();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

	}

}
