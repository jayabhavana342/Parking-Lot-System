package parkinglot.controller.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;
import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;
import parkinglot.view.customer.CustomerCheckOutDisplayDetails;
import parkinglot.view.customer.CustomerCheckOutEnterDetails;

public class CustomerCheckOutEnterDetailsController {
	private CustomerCheckOutEnterDetails view;
	private CardDetailsModel cardDetailsModel;
	private VehicleDetailsModel vehicleDetailsModel;
	private TimeDetailsModel timeDetailsModel;

	Connection conn;

	public CustomerCheckOutEnterDetailsController() {
		// TODO Auto-generated constructor stub
	}

	public CustomerCheckOutEnterDetailsController(CustomerCheckOutEnterDetails view) {

		// TODO Auto-generated constructor stub
		this.view = view;
		cardDetailsModel = new CardDetailsModel();
		vehicleDetailsModel = new VehicleDetailsModel();
		timeDetailsModel = new TimeDetailsModel();

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
			CustomerCheckOutDisplayDetails customerCheckOutDisplayDetails = new CustomerCheckOutDisplayDetails();
			customerCheckOutDisplayDetails.vehicleNo.setText(vehicleDetailsModel.getVehicle_No());
			customerCheckOutDisplayDetails.vehicleType.setText(vehicleDetailsModel.getVehicle_Type());
			timeDetailsModel.updateOutTime(id);
			timeDetailsModel.updateNoOfDays(id);
			timeDetailsModel.retrieveTimeDetails(id);
			Timestamp inTime = timeDetailsModel.getIn_Time();
			Timestamp outTime = timeDetailsModel.getOut_Time();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			customerCheckOutDisplayDetails.InTime.setText(dateFormat.format(inTime));
			customerCheckOutDisplayDetails.OutTime.setText(dateFormat.format(outTime));
			customerCheckOutDisplayDetails.noOfDays.setText(String.valueOf(timeDetailsModel.getNoOfDays()));
			//customerCheckOutDisplayDetails.OutTime.setText(timeDetailsModel.getOut_Time());
			
			
			customerCheckOutDisplayDetails.setVisible(true);
			customerCheckOutDisplayDetails.setLocationRelativeTo(null);;
			this.view.dispose();
		}

	}
}