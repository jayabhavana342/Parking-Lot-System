/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.customer.checkout.CustomerCheckOutHomePageView;

/**
 * @author bhavana
 *
 */
public class ParkingLotMainCustomerCheckOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(() -> {
			try {
				CustomerCheckOutHomePageView frame = new CustomerCheckOutHomePageView();
				frame.setVisible(true);
				frame.setLocation(200, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
