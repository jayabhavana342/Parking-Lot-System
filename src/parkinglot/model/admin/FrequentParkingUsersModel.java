/**
 * 
 */
package parkinglot.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private int totalFrequentParkers;
	Connection conn;
	
	
	
	

	public FrequentParkingUsersModel() {
		super();
		// TODO Auto-generated constructor stub
	}




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
	
	

	public int gettotalFrequentParkers() {
		return totalFrequentParkers;
	}




	public void setFrequent_parkers_count(int frequent_parkers_count) {
		this.totalFrequentParkers = frequent_parkers_count;
	}




	public void getFrequentParkersCount() {
		// TODO Auto-generated method stub
		
		
		try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement select = conn.prepareStatement("select count(*)as count from frequent_parking_users");
            System.out.println(select);
            ResultSet rs = select.executeQuery();
            
            if(rs.next()){
            	System.out.println("Inside if");
            	totalFrequentParkers = rs.getInt("count");
            	System.out.println("totalFrequentParkers" +totalFrequentParkers);
            }
            else{
            	System.out.println("Inside else");
            	totalFrequentParkers = 0;
            	System.out.println("totalFrequentParkers" +totalFrequentParkers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
