package parkinglot.controller.customer;

import parkinglot.model.customer.CardDetailsModel;
import parkinglot.model.customer.TimeDetailsModel;
import parkinglot.model.customer.VehicleDetailsModel;
import parkinglot.view.customer.CustomerCheckInEnterDetails;
import parkinglot.view.customer.CustomerChooseSlotsView;
import slots.parking.txstate.edu.Slots;

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

	public void parseDetails(String cardNo, String cvv, String nameOnCard, String vehicleNo, String vehicleType) {
		
//		CustomerChooseSlotsView slotView = new CustomerChooseSlotsView();
//		slotView.setVisible(true);
//		slotView.setLocationRelativeTo(null);

//		slotView.cardNumber.setText(cardNo);
//		slotView.cvv.setText(cvv);
//		slotView.nameOnCard.setText(nameOnCard);
//		slotView.vehicleNo.setText(vehicleNo);
//		slotView.vehicleType.setText(vehicleType);
		
		this.view.dispose();
//		System.out.println(cardNo);
//		Slots.cardNumber.setText(cardNo);
//		Slots.cvv.setText(cvv);
//		Slots.nameOnCard.setText(nameOnCard);
		
		Slots.selectSlot(vehicleType, vehicleNo, cardNo,Integer.valueOf(cvv),nameOnCard);
		

		
	}

}
