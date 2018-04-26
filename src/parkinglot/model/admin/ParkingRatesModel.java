/**
 * 
 */
package parkinglot.model.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;

/**
 * @author AishwaryaRana
 *
 */
public class ParkingRatesModel {

	private int id;
	private Date date;
	private float rate;
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
	public ParkingRatesModel(int id, Date date, float rate, boolean is_active) {
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

	public float getRate() {
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

	public void UpdateParking_Rates(float rate) {

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;
			ps = conn.prepareStatement("UPDATE parking_rates SET is_active=0 ORDER BY id DESC LIMIT 1;");
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update Successful");

				ps = conn.prepareStatement("INSERT INTO parking_rates(rate, is_active ) VALUES (?, 1)");
				ps.setFloat(1, rate);
				ps.execute();
		
			JOptionPane.showMessageDialog(null, "New rate is updated");
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

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
			PreparedStatement select = conn.prepareStatement("SELECT rate, is_active FROM parking_rates WHERE is_active= 1");
			ResultSet rs = select.executeQuery();
			if (rs.next()) {
				rate = rs.getFloat("rate");
				is_active = rs.getBoolean("is_active");
				System.out.println(rate);
			} else {
				rate = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
