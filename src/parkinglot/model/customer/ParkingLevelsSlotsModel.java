package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import parkinglot.model.DatabaseConnection;

public class ParkingLevelsSlotsModel {
	private int id;
	private int slot_id;
	private int level_id;
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

	public int getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}

	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public boolean isIs_ocupied() {
		return is_ocupied;
	}

	public void setIs_ocupied(boolean is_ocupied) {
		this.is_ocupied = is_ocupied;
	}

	/**
	 * @param id
	 * @param slot_id
	 * @param level_id
	 * @param is_ocupied
	 */
	public ParkingLevelsSlotsModel(int id, int slot_id, int level_id, boolean is_ocupied) {
		super();
		this.id = id;
		this.slot_id = slot_id;
		this.level_id = level_id;
		this.is_ocupied = is_ocupied;
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

}
