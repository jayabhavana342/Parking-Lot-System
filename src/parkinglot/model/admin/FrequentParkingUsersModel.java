/**
 * 
 */
package parkinglot.model.admin;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
	private String phone;
	private String license_id;
	private float rewards;
	private int totalFrequentParkers;

	Connection conn;

	public FrequentParkingUsersModel() {
		super();
		// TODO Auto-generated constructor stub
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
			String phone, String license_id, float f) {
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

	public void setRewards(float rewards) {
		this.rewards = rewards;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLicense_id() {
		return license_id;
	}

	public void setLicense_id(String license_id) {
		this.license_id = license_id;
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

	public ArrayList<FrequentParkingUsersModel> parkingUsersList() {
		ArrayList<FrequentParkingUsersModel> parkingUsersList = new ArrayList<FrequentParkingUsersModel>();

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			ps = conn.prepareStatement("SELECT * FROM frequent_parking_users;");

			ResultSet rs = ps.executeQuery();
			FrequentParkingUsersModel frequentParker;
			while (rs.next()) {
				frequentParker = new FrequentParkingUsersModel(rs.getInt("id"), rs.getString("last_name"),
						rs.getString("first_name"), rs.getString("email"), rs.getString("address"),
						rs.getString("phone"), rs.getString("license_id"), rs.getFloat("rewards"));

				parkingUsersList.add(frequentParker);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return parkingUsersList;
	}

	public void executeSQLQuery(String query, String message) {
		conn = DatabaseConnection.getConnection();

		Statement st;

		try {
			st = conn.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				JOptionPane.showMessageDialog(null, "Data " + message + "Successfully.");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertUpdateDeleteFrequentParker(char operation, String id, String last_name, String first_name,
			String email, String address, int phone, String license_id, String rewards) {

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

			if (operation == 'u') {

				ps = conn.prepareStatement("UPDATE\n" + "    `frequent_parking_users`\n" + "SET\n" + "    `id` = ?,\n"
						+ "    `last_name` = ?,\n" + "    `first_name` = ?,\n" + "    `email` = ?,\n"
						+ "    `address` = ?,\n" + "    `phone` = ?,\n" + "    `license_id` = ?,\n"
						+ "    `rewards` = ? \n" + "WHERE\n" + "    `id` = ?");
				ps.setString(1, id);
				ps.setString(2, last_name);
				ps.setString(3, first_name);
				ps.setString(4, email);
				ps.setString(5, address);
				ps.setInt(6, phone);
				ps.setString(7, license_id);
				ps.setString(8, rewards);
				ps.setString(9, id);
				System.out.println(ps);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "frequent parker updated");
				}

			}

			if (operation == 'd') {

				ps = conn.prepareStatement(
						"DELETE\n" + "FROM\n" + "    `frequent_parking_users`\n" + "WHERE\n" + "    id = ?");
				ps.setString(1, id);
				System.out.println(ps);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, " frequent parker deleted");
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

	public float getUserRewards(String phoneNumber) {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn
					.prepareStatement("SELECT rewards FROM frequent_parking_users WHERE phone =?");

			select.setString(1, phoneNumber);
			rs = select.executeQuery();

			if (rs.next()) {

				System.out.println(rs.getFloat("rewards"));
				return rs.getFloat("rewards");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public int getUserID(String phoneNumber) {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("SELECT id FROM frequent_parking_users WHERE phone =?");

			select.setString(1, phoneNumber);
			rs = select.executeQuery();

			if (rs.next()) {

				System.out.println(rs.getInt("id"));
				return rs.getInt("id");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public float getUserRewardsBasedOnID(int id) {
		ResultSet rs;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("SELECT rewards FROM frequent_parking_users WHERE id =?");

			select.setInt(1, id);
			rs = select.executeQuery();

			if (rs.next()) {

				System.out.println(rs.getFloat("rewards"));
				return rs.getFloat("rewards");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public float getRewards() {
		return rewards;
	}

	public void updateRewards(float useR, float cA, int id, boolean empty) {
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps;

			ps = conn.prepareStatement("UPDATE\n" + "	    `frequent_parking_users`\n" + "	SET\n"
					+ "	    `rewards` =?\n" + "	WHERE\n" + "	    id = ?");
			// if (empty) {
			// ps.setFloat(1, ((Float.valueOf(getUserRewardsBasedOnID(id))) +
			// Float.valueOf((float) (cA * 0.10))));
			// } else {
			ps.setFloat(1, ((Float.valueOf(getUserRewardsBasedOnID(id) - useR)) + Float.valueOf((float) (cA * 0.10))));
			// }

			ps.setInt(2, id);

			System.out.println(ps);

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "frequent parker rewards updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
