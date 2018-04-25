package parkinglot.controller.customer;

import java.sql.Connection;
import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;

public class CustomerChooseSlotsController {
	private CardDetailsModel cardDetailsModel;
	private VehicleDetailsModel vehicleDetailsModel;
	private TimeDetailsModel timeDetailsModel;

	Connection conn;

	public CustomerChooseSlotsController() {
		// TODO Auto-generated constructor stub

		cardDetailsModel = new CardDetailsModel();
		vehicleDetailsModel = new VehicleDetailsModel();
		timeDetailsModel = new TimeDetailsModel();

	}

	public void enterDetailsIntoDB(String cardNo, int cvv, String nameOnCard, String vehicleNo, String vehicleType,
			int slotLevelID) {
		System.out.println("In Controller: ");
		System.out.println(vehicleNo);
		System.out.println(vehicleType);
		System.out.println(slotLevelID);
		int id = vehicleDetailsModel.insertVehicleDetailsIntoDB(vehicleNo, vehicleType);
		System.out.println("Vehicle ID: " + id);
		cardDetailsModel.insertCardDetailsIntoDB(id, cardNo, cvv, nameOnCard);
		timeDetailsModel.insertTimeDetailsIntoDB(id, slotLevelID);
	}
}
