/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.customer.checkin.CustomerCheckInHomePageView;

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
				CustomerCheckInHomePageView frame = new CustomerCheckInHomePageView();
				frame.setVisible(true);
				frame.setLocation(500, 200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
