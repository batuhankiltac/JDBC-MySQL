import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOperation {
    static Connection connection = null;
    static DatabaseHelper databaseHelper = new DatabaseHelper();
    static PreparedStatement preparedStatement = null;

    public static void update() throws SQLException {
        try {
            connection = databaseHelper.getConnection();
            String sqlQuery = ("update city set population = 123456 where name = ?");
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Ankara");
            preparedStatement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
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