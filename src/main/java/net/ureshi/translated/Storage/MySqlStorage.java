package net.ureshi.translated.Storage;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.bukkit.Bukkit;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

import static javax.sql.rowset.spi.SyncFactory.getLogger;
import static net.ureshi.translated.Translated.*;


public class MySqlStorage {

    private void testDataSource(DataSource dataSource) throws SQLException {

        try (Connection conn = dataSource.getConnection()) {

            if (!conn.isValid(1000)) {

                throw new SQLException("Could not establish database connection.");

            } else {

                Bukkit.getConsoleSender().sendMessage("Connection is validated!");
            }
        }
    }

    public void initMySQLDataSource() throws SQLException {

        MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
        // set credentials
        dataSource.setServerName(host);
        dataSource.setPortNumber(Integer.parseInt(port));
        dataSource.setDatabaseName(database);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Bukkit.getConsoleSender().sendMessage("Credidentials Set");

        testDataSource(dataSource);
    }


    public void initDb() throws SQLException, IOException {

        String setup;
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("dbsetup.sql")) {

            assert in != null;
            setup = new String(in.readAllBytes());

        } catch (IOException e) {

            getLogger().log(Level.SEVERE, "Could not read db setup file.", e);

            throw e;
        }
    }
}


