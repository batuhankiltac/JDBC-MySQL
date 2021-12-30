import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {
    static Connection connection = null;
    static DatabaseHelper databaseHelper = new DatabaseHelper();
    static PreparedStatement preparedStatement = null;

    public static void insert() throws SQLException {
        try {
            connection = databaseHelper.getConnection();
            String sqlQuery = ("insert into city (name, countrycode, district, population) values (?, ?, ?, ?)");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Ankara2");
            preparedStatement.setString(2, "TUR");
            preparedStatement.setString(3, "TURKEY");
            preparedStatement.setInt(4, 128000);
            preparedStatement.executeUpdate();
            System.out.println("Kayıt eklendi.");
        }
        catch (SQLException sqlException) {
            databaseHelper.showErrorMessage(sqlException);
        }
        finally {
            assert connection != null;
            assert preparedStatement != null;
            preparedStatement.close();
            connection.close();
        }
    }
}