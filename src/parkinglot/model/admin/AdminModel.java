/**
 * 
 */
package parkinglot.model.admin;

/**
 * @author bhavana
 *
 */
public class AdminModel {

	private String last_name, first_name, email, password;
	private int id;

	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String last_name, String first_name, String email, String password, int id) {
		super();
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
