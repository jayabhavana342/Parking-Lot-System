/**
 * 
 */
package parkinglot.controller.customer;

import parkinglot.view.customer.CustomerCheckInEnterDetails;
import parkinglot.view.customer.CustomerCheckInHomePage;

/**
 * @author bhavana
 *
 */
public class CustomerCheckInHomePageController {

	CustomerCheckInHomePage view = new CustomerCheckInHomePage();

	/**
	 * 
	 */
	public CustomerCheckInHomePageController(CustomerCheckInHomePage view) {
		System.out.println("hey i am in constructor");
		// TODO Auto-generated constructor stub
		this.view = view;
	}

	public void proceedToEnterCardDetailsScreen() {
		System.out.println("hey i am in function call");
		CustomerCheckInEnterDetails customerCheckInEnterDetails = new CustomerCheckInEnterDetails();
		customerCheckInEnterDetails.setVisible(true);
		customerCheckInEnterDetails.setLocationRelativeTo(null);
		view.dispose();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
