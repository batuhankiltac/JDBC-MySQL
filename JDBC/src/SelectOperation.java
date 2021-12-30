import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectOperation {
    static Connection connection = null;
    static DatabaseHelper databaseHelper = new DatabaseHelper();
    static Statement statement;
    static ResultSet resultSet;

    public static void select() throws SQLException {
        try {
            connection = databaseHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select code, name, continent, region from country where continent = 'asia'");
            ArrayList<Country> countries = new ArrayList<>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("name"),
                        resultSet.getString("region")));
            }
            for (Country i : countries) {
                System.out.println(i.getName());
            }
        }
        catch (SQLException sqlException) {
            databaseHelper.showErrorMessage(sqlException);
        }
        finally {
            assert connection != null;
            connection.close();
        }
    }
}