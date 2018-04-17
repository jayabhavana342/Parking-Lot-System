package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;

public class TimeDetailsModel {
	private int id;
	private String vehicle_ID;
	private Timestamp Out_Time;
	private int noOfDays;
	
	Connection conn;

	public TimeDetailsModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_ID() {
		return vehicle_ID;
	}

	public void setVehicle_ID(String vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}

	public Timestamp getOut_Time() {
		return Out_Time;
	}

	public void setOut_Time(Timestamp out_Time) {
		Out_Time = out_Time;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void insertTimeDetailsIntoDB(int vehicleID, int slotLevelID) {
		try {
			System.out.println("In TimeDetails Model:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;
			
			String sql = "INSERT INTO time_details( vehicle_ID, slot_level_id) VALUES (?,?)";
			System.out.println(sql);

				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, vehicleID);
				ps.setInt(2, slotLevelID);
				
				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Time Details added!");
				}
				
			sql = "UPDATE parking_levels_slots set is_ocupied = 1 where id = ?";
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, slotLevelID);
			
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Slot Level ID updated as Occupied");
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
