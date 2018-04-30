package parkinglot.controller.customer.checkout;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.view.customer.checkout.CustomerCheckOutOrUseRewardsView;

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
		view.availableRewardsLabel.setText(model.getUserRewards(text) + " rewards.");

		if (model.checkIfFrequentParkerBasedOnPhoneNumber(text)) {
			view.panel.add(view.panel_1);
			view.panel.revalidate();
			view.panel.repaint();
		}
	}

	public void applyRewads(String useR, String billAmount, String text) {
		// TODO Auto-generated method stub
		view.billAmount.setVisible(false);
		view.checkOutAmount.setVisible(true);
		view.availableRewardsLabel.setText(String.valueOf(Float.valueOf(model.getUserRewards(text)) - Float.valueOf(useR)) + " rewards.");
		view.checkOutAmount.setText(String.valueOf(Float.valueOf(billAmount) - Float.valueOf(useR)));
	}

}
