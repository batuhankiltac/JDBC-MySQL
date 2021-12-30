import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        SelectOperation.select();
        InsertOperation.insert();
        UpdateOperation.update();
        DeleteOperation.delete();
    }
}