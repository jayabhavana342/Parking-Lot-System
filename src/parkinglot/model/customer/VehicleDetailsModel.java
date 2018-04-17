package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;

public class VehicleDetailsModel {
	private int id;
	private String vehicle_No;
	private String Vehicle_Type;
	private int slot_level_id;
	
	Connection conn;

	public VehicleDetailsModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_No() {
		return vehicle_No;
	}

	public void setVehicle_No(String vehicle_No) {
		this.vehicle_No = vehicle_No;
	}

	public String getVehicle_Type() {
		return Vehicle_Type;
	}

	public void setVehicle_Type(String vehicle_Type) {
		Vehicle_Type = vehicle_Type;
	}

	public int getSlot_level_id() {
		return slot_level_id;
	}

	public void setSlot_level_id(int slot_level_id) {
		this.slot_level_id = slot_level_id;
	}

	public int insertVehicleDetailsIntoDB(String vehicleNo, String vehicleType) {
		int lastInsertVehicleID = 0;
		try {
				System.out.println("In VehicleDetailsModel:");
				System.out.println(vehicleNo);
				System.out.println(vehicleType);
				conn = DatabaseConnection.getConnection();
				PreparedStatement ps;
			
				String sql = "select id from vehicle_details where vehicle_No = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vehicleNo);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					lastInsertVehicleID = rs.getInt(1);
					JOptionPane.showMessageDialog(null, "Vehicle Details already existing!");		
				}
				else
				{
					sql = "INSERT INTO `vehicle_details`(`vehicle_No`, `Vehicle_Type`) VALUES (?,?)";
					System.out.println(sql);

						ps = conn.prepareStatement(sql);
						
						ps.setString(1, vehicleNo);
						ps.setString(2, vehicleType);
						
						if (ps.executeUpdate() > 0)
						{
							JOptionPane.showMessageDialog(null, "Vehicle Details added!");
						}
						
					sql = "select last_insert_id() from vehicle_details";
					System.out.println(sql);
					
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next())
					{
						lastInsertVehicleID = rs.getInt(1);
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastInsertVehicleID;
		
	}

}
