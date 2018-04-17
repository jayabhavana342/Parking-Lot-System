/**
 * 
 */
package parkinglot.controller.admin;

import javax.swing.JTextField;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.model.admin.ParkingRatesModel;
import parkinglot.view.admin.RegisterCustomerView;
import parkinglot.view.admin.UpdateRatesView;

/**
 * @author AishwaryaRana
 *
 */
public class UpdateRateController {

	/**
	 * @param args
	 
	 */
	private ParkingRatesModel model;
	private UpdateRatesView view;

	public UpdateRateController(UpdateRatesView view) {
		// TODO Auto-generated constructor stub
		
		this.view = view;
		model = new ParkingRatesModel();
	}
	
	public void update(float rate){

		model.UpdateParking_Rates(rate);
        
    }
	
	
	
	public JTextField getActiveRate(){

		model.getActiveRate();

		view.currentRate.setText(String.valueOf(model.getRate()));
		return null;
		
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
