/**
 * 
 */
package parkinglot.controller.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

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
	private FrequentParkingUsersModel frequentParkingUsersModel;
	
	

	public LoginController(LoginView view) {
		
		// TODO Auto-generated constructor stub
		this.view = view;
		model = new AdminModel();
		parkingRatesModel = new ParkingRatesModel();
		frequentParkingUsersModel = new FrequentParkingUsersModel();
		
	}

	public void checkCredentials(String email, String password){
        model.setEmail(email);
        model.getCredentials();
        if(password.equals(model.getPassword())){
            AdminHomeView adminHomeView = new AdminHomeView();
            adminHomeView.setVisible(true);
            adminHomeView.setLocationRelativeTo(null);
            System.out.println(adminHomeView);
            adminHomeView.welcomeLabel.setText("<html><font color='white'>Welcome </font></html>");
            parkingRatesModel.getActiveRate();
            if(parkingRatesModel.isIs_active())
            {
            	System.out.println(String.valueOf(parkingRatesModel.getRate()));
            	adminHomeView.todaysRate.setText("$ " + String.valueOf(parkingRatesModel.getRate()));
            }
           
            System.out.println("I am here!' ");
            frequentParkingUsersModel.getFrequentParkersCount();
            if(frequentParkingUsersModel.gettotalFrequentParkers() > 0)
            {
            	System.out.println(String.valueOf(frequentParkingUsersModel.gettotalFrequentParkers()));
            	adminHomeView.frequentParkers.setText(String.valueOf(frequentParkingUsersModel.gettotalFrequentParkers()));
            }
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
