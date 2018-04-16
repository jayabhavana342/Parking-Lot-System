package parkinglot.controller.customer;

import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;
import parkinglot.view.customer.CustomerChooseSlotsView;

public class CustomerChooseSlotsController 
{
	private CustomerChooseSlotsView view;
	private CardDetailsModel cardDetailsModel;
	private VehicleDetailsModel vehicleDetailsModel;
	private TimeDetailsModel timeDetailsModel;
	
	
	
	public CustomerChooseSlotsController() {
		// TODO Auto-generated constructor stub
	}

public CustomerChooseSlotsController(CustomerChooseSlotsView view) {
		
		// TODO Auto-generated constructor stub
		this.view = view;
		cardDetailsModel = new CardDetailsModel();
		vehicleDetailsModel = new VehicleDetailsModel();
		timeDetailsModel = new TimeDetailsModel();
		
	}

public void enterDetails(String cardNo, String cvv, String nameOnCard, String vehicleNo, String vehicleType) {

	cardDetailsModel.insertCardDetails(cardNo, cvv, nameOnCard, vehicleNo, vehicleType);
    
}
}
