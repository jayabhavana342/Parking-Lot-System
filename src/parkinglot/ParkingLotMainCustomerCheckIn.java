/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.customer.CustomerCheckInHomePage;

/**
 * @author bhavana
 *
 */
public class ParkingLotMainCustomerCheckIn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(() -> {
			try {
				CustomerCheckInHomePage frame = new CustomerCheckInHomePage();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
