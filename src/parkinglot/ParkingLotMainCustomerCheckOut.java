/**
 * 
 */
package parkinglot;

import java.awt.EventQueue;

import parkinglot.view.customer.CustomerCheckOutHomePage;

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
                CustomerCheckOutHomePage frame = new CustomerCheckOutHomePage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

	}

}
