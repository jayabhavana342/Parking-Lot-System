package parkinglot.controller.customer.checkin;

import parkinglot.view.customer.checkin.CustomerCheckInEnterDetailsView;
import slots.parking.txstate.edu.Slots;

public class CustomerCheckInEnterDetailsController {
	private CustomerCheckInEnterDetailsView view;

	public CustomerCheckInEnterDetailsController(CustomerCheckInEnterDetailsView view) {

		// TODO Auto-generated constructor stub
		this.view = view;

	}

	public CustomerCheckInEnterDetailsController() {
		// TODO Auto-generated constructor stub
	}

	public void parseDetails(String cardNo, String cvv, String nameOnCard, String vehicleNo, String vehicleType) {

		this.view.dispose();

		Slots.selectSlot(vehicleType, vehicleNo, cardNo, Integer.valueOf(cvv), nameOnCard);

	}

}
