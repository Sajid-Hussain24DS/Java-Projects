package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    // Update with your DB credentials
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_store";
    private static final String USER = "root";
    private static final String PASSWORD = "Sajid@2025DE!";

    private DBConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("MySQL Driver not found!", e);
            }
        }
        return conn;
    }
}
