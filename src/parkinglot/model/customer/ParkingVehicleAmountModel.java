package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import parkinglot.model.DatabaseConnection;

public class ParkingVehicleAmountModel {
	private int id;
	private int vehicle_ID;
	private int frequent_parker_id;
	private float bill_amount;
	private float checkout_amount;

	Connection conn;

	public ParkingVehicleAmountModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingVehicleAmountModel(int id, int vehicle_ID, int frequent_parker_id, float bill_amount,
			float checkout_amount) {
		super();
		this.id = id;
		this.vehicle_ID = vehicle_ID;
		this.frequent_parker_id = frequent_parker_id;
		this.bill_amount = bill_amount;
		this.checkout_amount = checkout_amount;
	}

	public int getVehicle_ID() {
		return vehicle_ID;
	}

	public void setVehicle_ID(int vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}

	public float getCheckout_amount() {
		return checkout_amount;
	}

	public void setCheckout_amount(float checkout_amount) {
		this.checkout_amount = checkout_amount;
	}

	public int getFrequent_parker_id() {
		return frequent_parker_id;
	}

	public void setFrequent_parker_id(int frequent_parker_id) {
		this.frequent_parker_id = frequent_parker_id;
	}

	public float getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}

	public boolean updateCheckout(String vID, String billA, String cA) {

		boolean checkout = false;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"INSERT\n" + "INTO\n" + "    `parking_vehicle_amount`(\n" + "        `vehicle_ID`,\n"
							+ "        `bill_amount`,\n" + "        `checkout_amount`\n" + "    )\n" + "VALUES(?,?,?)");

			select.setInt(1, Integer.valueOf(vID));
			select.setFloat(2, Float.valueOf(billA));
			select.setFloat(3, Float.valueOf(cA));

			if (select.executeUpdate() > 0) {
				System.out.println("added nfp");
				checkout = true;

			} else
				checkout = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return checkout;

	}

	public boolean updateFrequentParkerCheckout(String fpID, String vID, String billA, String cA) {
		// TODO Auto-generated method stub
		boolean checkout = false;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("INSERT\n" + "INTO\n" + "    `parking_vehicle_amount`(\n"
					+ "        `vehicle_ID`,\n" + "        `frequent_parker_id`,\n" + "        `bill_amount`,\n"
					+ "        `checkout_amount`\n" + "    )\n" + "VALUES(?,?,?,?)");

			select.setInt(1, Integer.valueOf(vID));
			select.setInt(2, Integer.parseInt(fpID));
			select.setFloat(3, Float.valueOf(billA));
			select.setFloat(4, Float.valueOf(cA));

			if (select.executeUpdate() > 0) {
				System.out.println("added fp");
				checkout = true;

			} else
				checkout = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return checkout;

	}

}
