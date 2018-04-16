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
			PreparedStatement select = conn.prepareStatement("SELECT\r\n" + "    COUNT(*) AS carSlotsAvailable\r\n"
					+ "FROM\r\n" + "    parking_levels_slots\r\n" + "WHERE\r\n" + "    (\r\n"
					+ "        (is_ocupied = 0) AND(\r\n" + "        SELECT\r\n"
					+ "            IF(slot_type = 'Car', 1, 0)\r\n" + "        FROM\r\n"
					+ "            parking_slots\r\n" + "        WHERE\r\n"
					+ "            parking_levels_slots.slot_id = parking_slots.slot_id\r\n" + "    )\r\n" + "    )");

			rs = select.executeQuery();

			if (rs.next()) {
				carSlotsAvailable = rs.getInt("carSlotsAvailable");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carSlotsAvailable;
	}

	public int busLotsAvailable() {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("SELECT\r\n" + "    COUNT(*) AS busSlotsAvailable\r\n"
					+ "FROM\r\n" + "    parking_levels_slots\r\n" + "WHERE\r\n" + "    (\r\n"
					+ "        (is_ocupied = 0) AND(\r\n" + "        SELECT\r\n"
					+ "            IF(slot_type = 'Bus', 1, 0)\r\n" + "        FROM\r\n"
					+ "            parking_slots\r\n" + "        WHERE\r\n"
					+ "            parking_levels_slots.slot_id = parking_slots.slot_id\r\n" + "    )\r\n" + "    )");

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
