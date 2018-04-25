/**
 * 
 */
package parkinglot.controller.admin;

import javax.swing.table.TableModel;

import parkinglot.model.admin.FrequentParkingUsersModel;
import parkinglot.view.admin.RegisterCustomerView;

/**
 * @author bhavana
 *
 */
public class RegisterCustomerController {

	private FrequentParkingUsersModel model;

	/**
	 * 
	 */
	public RegisterCustomerController(RegisterCustomerView view) {
		// TODO Auto-generated constructor stub
		model = new FrequentParkingUsersModel();
	}

	public void insert(String last_name, String first_name, String email, String address, int phone,
			String license_id) {

		model.insertUpdateDeleteFrequentParker('i', "", last_name, first_name, email, address, phone, license_id, "");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void update(String id, String last_name, String first_name, String email, String address, Integer phone,
			String license_id, String rewards) {
		// TODO Auto-generated method stub
		model.insertUpdateDeleteFrequentParker('u', id, last_name, first_name, email, address, phone, license_id,
				rewards);
	}

	public void delete(String id, String last_name, String first_name, String email, String address, Integer phone,
			String license_id, String rewards) {
		// TODO Auto-generated method stub
		model.insertUpdateDeleteFrequentParker('d', id, last_name, first_name, email, address, phone, license_id,
				rewards);
	}

	public void fillParkingUsersTable(TableModel model2, String text) {
		// TODO Auto-generated method stub

	}

}
