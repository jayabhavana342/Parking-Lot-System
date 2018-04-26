package parkinglot.controller.customer.checkout;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.ParkingLevelsSlotsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;
import parkinglot.view.customer.checkout.CustomerCheckOutEnterDetailsView;
import parkinglot.view.customer.checkout.CustomerCheckOutOrUseRewardsView;
import slots.parking.txstate.edu.Slots;

public class CustomerCheckOutEnterDetailsController {
	private CustomerCheckOutEnterDetailsView view;
	private CardDetailsModel cardDetailsModel;
	private VehicleDetailsModel vehicleDetailsModel;
	private TimeDetailsModel timeDetailsModel;
	private ParkingLevelsSlotsModel parkingLevelsSlotsModel;

	Connection conn;

	public CustomerCheckOutEnterDetailsController() {
		// TODO Auto-generated constructor stub
	}

	public CustomerCheckOutEnterDetailsController(CustomerCheckOutEnterDetailsView view) {

		// TODO Auto-generated constructor stub
		this.view = view;
		cardDetailsModel = new CardDetailsModel();
		vehicleDetailsModel = new VehicleDetailsModel();
		timeDetailsModel = new TimeDetailsModel();
		parkingLevelsSlotsModel = new ParkingLevelsSlotsModel();

	}

	public void retrieveCardDetails(String cardNo, int cvv, String nameOnCard) {
		System.out.println("In Controller: ");
		int id = cardDetailsModel.retrieveVehicleDetails(cardNo, cvv, nameOnCard);
		System.out.println("Vehicle ID: " + id);
		if (id == 0) {
			JOptionPane.showMessageDialog(null, "Please enter the correct card Details!");
		} else {
			vehicleDetailsModel.retrieveVehicleDetails(id);
			System.out.println(vehicleDetailsModel.getVehicle_No());

			// Check-out from Slot layout
			Slots.checkOut(vehicleDetailsModel.getVehicle_No());

			CustomerCheckOutOrUseRewardsView customerCheckOutDisplayDetails = new CustomerCheckOutOrUseRewardsView();
			customerCheckOutDisplayDetails.vehicleNo.setText(vehicleDetailsModel.getVehicle_No());
			customerCheckOutDisplayDetails.vehicleType.setText(vehicleDetailsModel.getVehicle_Type());
			customerCheckOutDisplayDetails.vid.setText(String.valueOf(vehicleDetailsModel.getId()));
			
			timeDetailsModel.updateOutTime(id);
			timeDetailsModel.updateNoOfDays(id);
			parkingLevelsSlotsModel.updateIsOccupied(timeDetailsModel.getSlotLevelID(id));
			timeDetailsModel.retrieveTimeDetails(id);
			Timestamp inTime = timeDetailsModel.getIn_Time();
			Timestamp outTime = timeDetailsModel.getOut_Time();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			customerCheckOutDisplayDetails.InTime.setText(dateFormat.format(inTime));
			customerCheckOutDisplayDetails.OutTime.setText(dateFormat.format(outTime));
			customerCheckOutDisplayDetails.noOfDays.setText(String.valueOf(timeDetailsModel.getNoOfDays()));
			customerCheckOutDisplayDetails.rate.setText(String.valueOf(timeDetailsModel.getCheck_in_rate()));
			customerCheckOutDisplayDetails.billAmount.setText(String.valueOf(timeDetailsModel.getBilled_amount()));
			customerCheckOutDisplayDetails.checkOutAmount.setText(String.valueOf(timeDetailsModel.getBilled_amount()));

			customerCheckOutDisplayDetails.setVisible(true);
			customerCheckOutDisplayDetails.setLocationRelativeTo(null);
			
			this.view.dispose();
		}

	}
}
