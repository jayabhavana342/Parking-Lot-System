/**
 * 
 */
package parkinglot.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;

/**
 * @author bhavana
 *
 */
public class FrequentParkingUsersModel {
	
	private int id;
	private String last_name;
	private String first_name;
	private String email;
	private String address;
	private int phone;
	private String license_id;
	private int rewards;
	
	Connection conn;
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public int getPhone() {
		return phone;
	}




	public void setPhone(int phone) {
		this.phone = phone;
	}




	public String getLicense_id() {
		return license_id;
	}




	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}




	public int getRewards() {
		return rewards;
	}




	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	public void insertUpdateDeleteFrequentParker(char operation, String last_name, String first_name, String email, String address,
			int phone, String license_id) {
		
		try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement ps;
            
            if(operation == 'i') {
           
            	ps = conn.prepareStatement("INSERT INTO frequent_parking_users(last_name, first_name, email, address, phone, license_id) VALUES (?,?,?,?,?,?)");
            	ps.setString(1, last_name);
            	ps.setString(2, first_name);
            	ps.setString(3, email);
            	ps.setString(4, address);
            	ps.setInt(5, phone);
            	ps.setString(6, license_id);
            	
            	if(ps.executeUpdate() > 0) {
            		JOptionPane.showMessageDialog(null, "New frequent parker added");
            	}
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	/**
	 * 
	 */
	public FrequentParkingUsersModel() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param id
	 * @param last_name
	 * @param first_name
	 * @param email
	 * @param address
	 * @param phone
	 * @param license_id
	 * @param rewards
	 */
	public FrequentParkingUsersModel(int id, String last_name, String first_name, String email, String address,
			int phone, String license_id, int rewards) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.license_id = license_id;
		this.rewards = rewards;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
