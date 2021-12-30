import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    final String USERNAME = "*****"; // your mysql username
    final String PASSWORD = "*****"; // your mysql password
    final String URL = "jdbc:mysql://localhost:3306/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void showErrorMessage(SQLException sqlException) {
        System.out.println("ERROR: " + sqlException.getMessage());
        System.out.println("ERROR CODE: " + sqlException.getErrorCode());
    }
}