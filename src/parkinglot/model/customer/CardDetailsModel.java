package parkinglot.model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import parkinglot.model.DatabaseConnection;

public class CardDetailsModel {
	private int id;
	private String vehicle_ID;
	private String card_No;
	private int cvv;
	private String name_on_card;
	Connection conn;

	public CardDetailsModel() {
		super();
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

	public String getCard_No() {
		return card_No;
	}

	public void setCard_No(String card_No) {
		this.card_No = card_No;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public void insertCardDetailsIntoDB(int vehicleID, String cardNo, int cvv, String nameOnCard) {
		try {
			System.out.println("In CardDetailsModel:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			String sql = "INSERT INTO card_details( vehicle_ID, card_No,cvv,name_on_card ) VALUES (?,?,?,?)";
			System.out.println(sql);

			ps = conn.prepareStatement(sql);

			ps.setInt(1, vehicleID);
			ps.setString(2, cardNo);
			ps.setInt(3, cvv);
			ps.setString(4, nameOnCard);

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Card Details added!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int retrieveVehicleDetails(String cardNo, int cvv, String nameOnCard) {
		int vehicleID = 0;
		try {

			System.out.println("In CardDetailsModel:");
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			String sql = "select a.vehicle_ID from card_details a join time_details b on a.vehicle_ID = b.vehicle_ID where b.Out_Time = '0000-00-00 00:00:00'"
					+ "  and  a.card_No = ? and a.cvv = ? and a.name_on_card = ?";
			System.out.println(sql);

			ps = conn.prepareStatement(sql);

			ps.setString(1, cardNo);
			ps.setInt(2, cvv);
			ps.setString(3, nameOnCard);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vehicleID = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleID;
	}

}
