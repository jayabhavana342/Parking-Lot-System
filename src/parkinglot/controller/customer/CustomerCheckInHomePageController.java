/**
 * 
 */
package parkinglot.controller.customer;

import parkinglot.model.customer.ParkingLevelsSlotsModel;
import parkinglot.view.admin.AdminHomeView;
import parkinglot.view.customer.CustomerCheckInHomePage;

/**
 * @author bhavana
 *
 */
public class CustomerCheckInHomePageController {

	CustomerCheckInHomePage view = new CustomerCheckInHomePage();
	ParkingLevelsSlotsModel model;

	/**
	 * 
	 */
	public CustomerCheckInHomePageController(CustomerCheckInHomePage view) {
		// TODO Auto-generated constructor stub

		this.view = view;
		model = new ParkingLevelsSlotsModel();
	}

	public void proceedToEnterCardDetailsScreen() {
		AdminHomeView adminHomeView = new AdminHomeView();
		adminHomeView.setVisible(true);
		adminHomeView.setLocationRelativeTo(null);
		view.dispose();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
