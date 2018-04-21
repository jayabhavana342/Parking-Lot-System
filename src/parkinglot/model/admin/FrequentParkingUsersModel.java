/**
 * 
 */
package parkinglot.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import parkinglot.model.DatabaseConnection;

/**
 * @author bhavana
 *
 */
public class FrequentParkingUsersModel {

	private int id;
	private String last_name;
	private String first_name;
	private String email;
	private String address;
	private int phone;
	private String license_id;
	private float rewards;
	private int totalFrequentParkers;

	Connection conn;

	public FrequentParkingUsersModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLicense_id() {
		return license_id;
	}

	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}

	public float getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	public int gettotalFrequentParkers() {
		return totalFrequentParkers;
	}

	public void setFrequent_parkers_count(int frequent_parkers_count) {
		this.totalFrequentParkers = frequent_parkers_count;
	}

	/**
	 * @param id
	 * @param last_name
	 * @param first_name
	 * @param email
	 * @param address
	 * @param phone
	 * @param license_id
	 * @param f
	 */
	public FrequentParkingUsersModel(int id, String last_name, String first_name, String email, String address,
			int phone, String license_id, float f) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.license_id = license_id;
		this.rewards = f;
	}

	public void insertUpdateDeleteFrequentParker(char operation, String last_name, String first_name, String email,
			String address, int phone, String license_id) {

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			if (operation == 'i') {

				ps = conn.prepareStatement(
						"INSERT INTO frequent_parking_users(last_name, first_name, email, address, phone, license_id) VALUES (?,?,?,?,?,?)");
				ps.setString(1, last_name);
				ps.setString(2, first_name);
				ps.setString(3, email);
				ps.setString(4, address);
				ps.setInt(5, phone);
				ps.setString(6, license_id);
				System.out.println(ps);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "New frequent parker added");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getFrequentParkersCount() {
		// TODO Auto-generated method stub

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("select count(*)as count from frequent_parking_users");
			System.out.println(select);
			ResultSet rs = select.executeQuery();

			if (rs.next()) {
				System.out.println("Inside if");
				totalFrequentParkers = rs.getInt("count");
				System.out.println("totalFrequentParkers" + totalFrequentParkers);
			} else {
				System.out.println("Inside else");
				totalFrequentParkers = 0;
				System.out.println("totalFrequentParkers" + totalFrequentParkers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getFrequentParkersBasedOnSearch(TableModel tableModel, String valueToSearch) {

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT * FROM frequent_parking_users WHERE CONCAT(first_name, last_name, email, address, phone, license_id) LIKE ?");
			System.out.println(select);
			System.out.println("%" + valueToSearch + "%");
			select.setString(1, "%" + valueToSearch + "%");

			ResultSet rs = select.executeQuery();

			System.out.println("table model");

			FrequentParkingUsersModel model;

			Object[] row;

			while (rs.next()) {
				System.out.println(rs);
				tableModel = (TableModel) new FrequentParkingUsersModel(rs.getInt("id"), rs.getString("last_name"),
						rs.getString("first_name"), rs.getString("email"), rs.getString("address"), rs.getInt("phone"),
						rs.getString("license_id"), rs.getFloat("rewards"));
				// row = new Object[8];
				// row[0] = rs.getInt(1);
				// row[1] = rs.getString(2);
				// row[2] = rs.getString(3);
				// row[3] = rs.getString(4);
				// row[4] = rs.getString(5);
				// row[5] = rs.getString(6);
				// row[6] = rs.getString(7);
				// row[7] = rs.getFloat(8);

				// model.addRow(row);

				System.out.println("%" + valueToSearch + "%");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkIfFrequentParkerBasedOnPhoneNumber(String phoneNumber) {
		ResultSet rs;
		boolean checkFrequentParker = false;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement(
					"SELECT IF(COUNT(*) > 0, 'true','false') AS checkFrequentParker FROM frequent_parking_users WHERE phone =?");

			select.setString(1, phoneNumber);
			rs = select.executeQuery();

			if (rs.next()) {
				
				if (rs.getString("checkFrequentParker").equals("true"))
					checkFrequentParker = true;
				else
					checkFrequentParker = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return checkFrequentParker;
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
