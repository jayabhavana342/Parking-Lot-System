package parkinglot.controller.customer;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.view.customer.CustomerCheckOutOrUseRewardsView;

public class CustomerCheckOutOrUseRewardsController {
	private CustomerCheckOutOrUseRewardsView view;
	private FrequentParkingUsersModel model;

	public CustomerCheckOutOrUseRewardsController(CustomerCheckOutOrUseRewardsView view) {
		// TODO Auto-generated method stub
		this.view = view;
		model = new FrequentParkingUsersModel();
		
	}

	public void checkIfFrequentParkerBasedOnPhoneNumber(String text) {
		// TODO Auto-generated method stub
		if(model.checkIfFrequentParkerBasedOnPhoneNumber(text)){
			view.panel.add(view.panel_1);
			view.panel.revalidate();
			view.panel.repaint();
		}
		
	}

}
