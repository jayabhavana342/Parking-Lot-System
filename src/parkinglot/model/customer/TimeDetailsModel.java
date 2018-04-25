package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;
import parkinglot.model.admin.ParkingRatesModel;

public class TimeDetailsModel {
	private int id;
	private String vehicle_ID;
	private Timestamp In_Time;
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

	public Timestamp getIn_Time() {
		return In_Time;
	}

	public void setIn_Time(Timestamp in_Time) {
		In_Time = in_Time;
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

			ps = conn.prepareStatement("select rate from parking_rates where is_active = 1");
			ResultSet rs = ps.executeQuery();

			String sql = "INSERT INTO time_details( vehicle_ID, slot_level_id,check_in_rate) VALUES (?,?,?)";
			System.out.println(sql);

			ps = conn.prepareStatement(sql);

			ps.setInt(1, vehicleID);
			ps.setInt(2, slotLevelID);
			if (rs.next()) {
				ps.setFloat(3, rs.getFloat("rate"));
			}

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Time Details added!");
			}

			sql = "SELECT is_ocupied FROM parking_levels_slots where id = ?";
			System.out.println(sql);

			ps = conn.prepareStatement(sql);

			ps.setInt(1, slotLevelID);

			rs = ps.executeQuery();

			if (rs.next()) {
				if (!rs.getBoolean("is_ocupied")) {
					sql = "UPDATE parking_levels_slots set is_ocupied = 1 where id = ?";
					System.out.println(sql);

					ps = conn.prepareStatement(sql);

					ps.setInt(1, slotLevelID);

					if (ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Slot Level ID updated as Occupied");
					}
				}
			}
			
			ParkingRatesModel parkingRatesModel = new ParkingRatesModel();
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void retrieveTimeDetails(int id) {
		try {
			System.out.println("In TimeDetailsModel:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			String sql = "select In_Time,Out_Time,noOfDays from time_details where vehicle_ID = ?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp inTime = rs.getTimestamp(1);
				Timestamp outTime = rs.getTimestamp(2);
				int noOfDays = rs.getInt(3);

				this.In_Time = inTime;
				this.Out_Time = outTime;
				this.noOfDays = noOfDays;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateOutTime(int id) {
		try {
			System.out.println("In TimeDetailsModel:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			String sql = "update time_details set Out_Time = current_timestamp() where vehicle_ID = ?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Out Time Updated!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateNoOfDays(int id) {
		// TODO Auto-generated method stub
		try {
			System.out.println("In TimeDetailsModel:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			String sql = "select datediff(Out_Time,In_Time) from time_details where vehicle_ID = ?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int noOfDays = rs.getInt(1);
				if (noOfDays == 0) {
					return;
				} else {
					sql = "update time_details set noOfDays = ? where vehicle_ID = ?";
					System.out.println(sql);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, noOfDays);
					ps.setInt(2, id);
					ps.executeQuery();
					System.out.println("No. of days updated!");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
