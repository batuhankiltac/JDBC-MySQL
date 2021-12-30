import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {
    static Connection connection = null;
    static DatabaseHelper databaseHelper = new DatabaseHelper();
    static PreparedStatement preparedStatement = null;

    public static void delete() throws SQLException {
        try {
            connection = databaseHelper.getConnection();
            String sqlQuery = ("delete from city where name = ?");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Ankara");
            preparedStatement.executeUpdate();
            System.out.println("Kayıt silindi.");
        } catch (SQLException sqlException) {
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