/**
 * 
 */
package parkinglot.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bhavana
 *
 */
public class DatabaseConnection {

	private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkinglot", "root", "");

                System.out.println("DB connection successful to: " + "jdbc:mysql://localhost:3306/parkinglot");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection.getConnection();
	}

}
