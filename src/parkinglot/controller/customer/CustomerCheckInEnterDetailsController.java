package parkinglot.controller.customer;

import parkinglot.model.admin.AdminModel;

import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;
import parkinglot.view.customer.CustomerCheckInEnterDetails;

public class CustomerCheckInEnterDetailsController {
	private CustomerCheckInEnterDetails view;
	private CardDetailsModel cardDetailsmodel;
	private VehicleDetailsModel vehicleDetailsmodel;
	private TimeDetailsModel timeDetailsModel;
	
	

	public CustomerCheckInEnterDetailsController(CustomerCheckInEnterDetails view) {
		
		// TODO Auto-generated constructor stub
		this.view = view;
		cardDetailsmodel = new CardDetailsModel();
		vehicleDetailsmodel = new VehicleDetailsModel();
		timeDetailsModel = new TimeDetailsModel();
		
	}

	public CustomerCheckInEnterDetailsController() {
		// TODO Auto-generated constructor stub
	}

	public void insertDetails(String cardNo, String cvv, String nameOnCard, String vehicleNo, String vehicleType) 
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
