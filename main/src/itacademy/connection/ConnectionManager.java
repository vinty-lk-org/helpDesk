package itacademy.connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
// Через одиночный коннект.
//    private static final String URL = "jdbc:postgresql://localhost:5432/Help_desk";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//    }
//}

//  Через пул.
    private static final String DB_URL =
//            "jdbc:postgresql://localhost:5432/Help_desk?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
        "jdbc:postgresql://localhost:5432/Help_desk";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static DataSource dataSource;

    static {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("org.postgresql.Driver");
        poolProperties.setUrl(DB_URL);
        poolProperties.setUsername(USER);
        poolProperties.setPassword(PASSWORD);
        dataSource = new DataSource(poolProperties);
    }

    private ConnectionManager() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}