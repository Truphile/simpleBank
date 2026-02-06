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

}
