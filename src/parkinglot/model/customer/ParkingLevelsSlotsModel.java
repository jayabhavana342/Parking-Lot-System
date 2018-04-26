package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import parkinglot.model.DatabaseConnection;

public class ParkingLevelsSlotsModel {
	private int id;
	private String slot_type;;
	private boolean is_ocupied;
	
	private boolean hasEmptySlots = false;
	private int carSlotsAvailable = 0;
	private int busSlotsAvailable = 0;
	private int bikeSlotsAvailable = 0;

	Connection conn;

	public ParkingLevelsSlotsModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getSlot_type() {
		return slot_type;
	}

	public void setSlot_type(String slot_type) {
		this.slot_type = slot_type;
	}

	public boolean isIs_ocupied() {
		return is_ocupied;
	}

	public void setIs_ocupied(boolean is_ocupied) {
		this.is_ocupied = is_ocupied;
	}

	public ParkingLevelsSlotsModel(int id, String slot_type, boolean is_ocupied, boolean hasEmptySlots) {
		super();
		this.id = id;
		this.slot_type = slot_type;
		this.is_ocupied = is_ocupied;
		this.hasEmptySlots = hasEmptySlots;
	}

	public boolean checkSlotsAvailability() {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT\r\n" + "    IF(COUNT(*) > 0,\r\n" + "    'true',\r\n" + "    'false') AS hasEmptySlots\r\n"
							+ "FROM\r\n" + "    parking_levels_slots\r\n" + "WHERE\r\n" + "    (is_ocupied = 0)");

			rs = select.executeQuery();

			if (rs.next()) {
				if (rs.getString("hasEmptySlots").equals("true"))
					hasEmptySlots = true;
				else
					hasEmptySlots = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hasEmptySlots;

	}

	public int carLotsAvailable() {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT\n" + "    COUNT(*) AS carSlotsAvailable\n" + "FROM\n" + "    parking_levels_slots\n"
							+ "WHERE\n" + "    (is_ocupied = 0) AND (slot_type = 'CAR')");

			rs = select.executeQuery();

			if (rs.next()) {
				carSlotsAvailable = rs.getInt("carSlotsAvailable");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carSlotsAvailable;
	}

	public int bikeLotsAvailable() {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT\n" + "    COUNT(*) AS bikeSlotsAvailable\n" + "FROM\n" + "    parking_levels_slots\n"
							+ "WHERE\n" + "    (is_ocupied = 0) AND (slot_type = 'MOTORCYCLE')");

			rs = select.executeQuery();

			if (rs.next()) {
				bikeSlotsAvailable = rs.getInt("bikeSlotsAvailable");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bikeSlotsAvailable;
	}

	public int busLotsAvailable() {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT\n" + "    COUNT(*) AS busSlotsAvailable\n" + "FROM\n" + "    parking_levels_slots\n"
							+ "WHERE\n" + "    (is_ocupied = 0) AND (slot_type = 'BUS')");

			rs = select.executeQuery();

			if (rs.next()) {
				busSlotsAvailable = rs.getInt("busSlotsAvailable");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return busSlotsAvailable;
	}

	public int vehiclesParked() {
		// TODO Auto-generated method stub
		ResultSet rs;

		int vehiclesParked = 0;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("SELECT\n" + "    COUNT(*) AS vehiclesParked\n" + "FROM\n"
					+ "    `parking_levels_slots`\n" + "WHERE\n" + "    (is_ocupied = 1)");

			rs = select.executeQuery();

			if (rs.next()) {
				vehiclesParked = rs.getInt("vehiclesParked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(vehiclesParked);
		return vehiclesParked;
	}

	public int emptySlots() {
		// TODO Auto-generated method stub
		ResultSet rs;

		int emptySlots = 0;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("	SELECT\n" + "    COUNT(*) AS emptySlots\n" + "FROM\n"
					+ "    `parking_levels_slots`\n" + "WHERE\n" + "    is_ocupied = 0");

			rs = select.executeQuery();

			if (rs.next()) {
				emptySlots = rs.getInt("emptySlots");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(emptySlots);
		return emptySlots;
	}

}
