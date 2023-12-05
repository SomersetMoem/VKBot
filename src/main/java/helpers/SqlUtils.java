package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {
    private static String url;
    private static String username;
    private static String password;
    Connection connection = DriverManager.getConnection(url, username, password);


    public SqlUtils() throws SQLException {
    }
}
