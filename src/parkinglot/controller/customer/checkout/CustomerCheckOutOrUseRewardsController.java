package parkinglot.controller.customer.checkout;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.model.customer.ParkingVehicleAmountModel;
import parkinglot.view.customer.checkout.CustomerCheckOutOrUseRewardsView;
import parkinglot.view.customer.checkout.CustomerCheckOutSucccessfulView;

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
		view.availableRewardsLabel
				.setText(String.valueOf(Float.valueOf(model.getUserRewards(text)) - Float.valueOf(useR)) + " rewards.");
		view.checkOutAmount.setText(String.valueOf(Float.valueOf(billAmount) - Float.valueOf(useR)));
	}

	public void checkOut(String useR, String fpID, String vID, String billA, String cA) {
		// TODO Auto-generated method stub
		ParkingVehicleAmountModel pvamodel = new ParkingVehicleAmountModel();

		CustomerCheckOutSucccessfulView cView = new CustomerCheckOutSucccessfulView();

		float epsilon = (float) 0.00000001;
		if (Float.compare(Float.valueOf(cA), Float.valueOf(billA)) < epsilon) {
			if (pvamodel.updateFrequentParkerCheckout(fpID, vID, billA, cA)) {
				model.updateRewards(Float.valueOf(useR), Float.valueOf(cA), Integer.valueOf(fpID));
				System.out.println("yes fp");
				cView.setVisible(true);
				cView.setLocationRelativeTo(null);
				this.view.dispose();
			}
		} else {
			if (pvamodel.updateCheckout(vID, billA, cA)) {
				System.out.println("no fp");
				cView.setVisible(true);
				cView.setLocationRelativeTo(null);
				this.view.dispose();
			}
		}

	}

}
