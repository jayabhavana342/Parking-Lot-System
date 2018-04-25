package parkinglot.controller.customer;

import parkinglot.view.customer.CustomerCheckInEnterDetails;
import slots.parking.txstate.edu.Slots;

public class CustomerCheckInEnterDetailsController {
	private CustomerCheckInEnterDetails view;

	public CustomerCheckInEnterDetailsController(CustomerCheckInEnterDetails view) {

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
