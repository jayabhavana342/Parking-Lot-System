/**
 * 
 */
package parkinglot.controller.admin;

import parkinglot.model.admin.*;
import parkinglot.view.admin.LoginView;
import parkinglot.view.admin.AdminHomeView;


/**
 * @author bhavana
 *
 */
public class LoginController {
	
	private LoginView view;
	private AdminModel model;
	private ParkingRatesModel parkingRatesModel;
	
	

	public LoginController(LoginView view) {
		
		// TODO Auto-generated constructor stub
		this.view = view;
		model = new AdminModel();
		parkingRatesModel = new ParkingRatesModel();
		
	}

	public void checkCredentials(String email, String password){
        model.setEmail(email);
        model.getCredentials();
        if(password.equals(model.getPassword())){
            AdminHomeView adminHomeView = new AdminHomeView();
            adminHomeView.setVisible(true);
            adminHomeView.setLocationRelativeTo(null);
            adminHomeView.welcomeLabel.setText("<html><font color='white'>Welcome "+view.getTextField().getText()+"</font></html>");
            parkingRatesModel.getActiveRate();
            if(parkingRatesModel.isIs_active())
            	System.out.println(String.valueOf(parkingRatesModel.getRate()));
            	adminHomeView.todaysRate.setText("$ " + String.valueOf(parkingRatesModel.getRate()));
            view.dispose();
        }
        else{
            view.setErrorMessage("Login Failed!");
        }
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
