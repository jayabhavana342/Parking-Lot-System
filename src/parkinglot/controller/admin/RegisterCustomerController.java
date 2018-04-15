/**
 * 
 */
package parkinglot.controller.admin;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.view.admin.AdminHomeView;
import parkinglot.view.admin.RegisterCustomerView;

/**
 * @author bhavana
 *
 */
public class RegisterCustomerController {
	
	private FrequentParkingUsersModel model;
	private RegisterCustomerView view;
	
	

	/**
	 * 
	 */
	public RegisterCustomerController(RegisterCustomerView view) {
		// TODO Auto-generated constructor stub
		
		this.view = view;
		model = new FrequentParkingUsersModel();
	}


	public void insert(String last_name, String first_name, String email, String address,
			int phone, String license_id){

		model.insertUpdateDeleteFrequentParker('i', last_name, first_name, email, address, phone, license_id);
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
