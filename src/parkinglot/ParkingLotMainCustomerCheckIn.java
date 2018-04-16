/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.customer.CustomerCheckInEnterDetails;
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
            	CustomerCheckInEnterDetails frame = new CustomerCheckInEnterDetails();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

	}

}
