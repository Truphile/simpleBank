package simpleBankTest;

import org.junit.Test;
import simpleBank.SimpleBank;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class SimpleBankTest {
   private final String username = "scripted";
   private final String password = "Seenmore01@";

    @Test
    public void testCanConnectToDatabase() {

        try (Connection connection = SimpleBank.connectToDatabase(username, password);){
            assertNotNull(connection);
            assertTrue(connection.isValid(3));
        }catch (SQLException ex) {
            assertNull(ex);

        }

    }

    @Test
    public void testCanCreateTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS accounts (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                account_number VARCHAR(50)UNIQUE NOT NULL,
                balance DECIMAL(15,2) DEFAULT 0.00
                );""";
        try (Connection connection = SimpleBank.connectToDatabase(username, password)){
            SimpleBank.createTable(query, connection);
            assertNotNull(connection);
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null,null,"accounts",new String[]{"TABLE"});
            boolean isTablesExists = resultSet.next();
            assertTrue(isTablesExists);
        } catch (SQLException e) {
            e.printStackTrace();
            assertNull(e);
        }
    }

}
