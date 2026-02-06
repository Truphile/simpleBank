package simpleBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleBank {

    public static Connection connectToDatabase(String username, String password) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/simple_bank?createDatabaseIfNotExist=true";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

       }


}

