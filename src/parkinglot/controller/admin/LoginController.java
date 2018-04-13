/**
 * 
 */
package parkinglot.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import parkinglot.model.admin.AdminModel;
import parkinglot.view.admin.LoginView;

/**
 * @author bhavana
 *
 */
public class LoginController {
	
	private LoginView view;
	private AdminModel model;
	
	

	public LoginController(LoginView view) {
		
		// TODO Auto-generated constructor stub
		this.view = view;
		model = new AdminModel();
		
		
	}

	public void checkCredentials(String email, String password){
        model.setEmail(email);
        model.getCredentials();
        if(password.equals(model.getPassword())){
            view.setErrorMessage("Login Success!");
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
