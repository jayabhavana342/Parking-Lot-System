/**
 * 
 */
package parkinglot.model.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import parkinglot.model.DatabaseConnection;

/**
 * @author bhavana
 *
 */
public class ParkingRatesModel {
	
	private int id;
	private Date date;
	private int rate;
	private boolean is_active;
	Connection conn;
	
	

	/**
	 * 
	 */
	public ParkingRatesModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @param id
	 * @param date
	 * @param rate
	 * @param is_active
	 */
	public ParkingRatesModel(int id, Date date, int rate, boolean is_active) {
		super();
		this.id = id;
		this.date = date;
		this.rate = rate;
		this.is_active = is_active;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getRate() {
		return rate;
	}



	public void setRate(int rate) {
		this.rate = rate;
	}



	public boolean isIs_active() {
		return is_active;
	}



	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void getActiveRate() {
		// TODO Auto-generated method stub
		
		
		try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement select = conn.prepareStatement("SELECT rate FROM parking_rates WHERE is_active=1");
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                rate = rs.getInt("rate");
                is_active = true;
            }
            else{
                rate = 0;
                is_active = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
