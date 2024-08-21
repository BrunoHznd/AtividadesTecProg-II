import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static Connection connect() throws SQLException {

        try {
            var jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
            var user = "postgres";
            var password = "Hznd";

            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        }

    }
}
