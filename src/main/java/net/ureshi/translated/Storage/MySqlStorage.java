package net.ureshi.translated.Storage;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import static javax.sql.rowset.spi.SyncFactory.getLogger;
import static jdk.xml.internal.SecuritySupport.getClassLoader;
import static net.ureshi.translated.Translated.*;


public class MySqlStorage {

    private DataSource dataSource;

    private void testDataSource(DataSource dataSource) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            if (!conn.isValid(1000)) {
                throw new SQLException("Could not establish database connection.");
            }
        }
    }

    public DataSource initMySQLDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();
        // set credentials
        dataSource.setServerName(host);
        dataSource.setPortNumber(Integer.parseInt(port));
        dataSource.setDatabaseName(database);
        dataSource.setUser(username);
        dataSource.setPassword(password);


        testDataSource(dataSource);
        return dataSource;
    }

    public void initdb() throws SQLException, IOException {
        String setup;
        try (InputStream in = getClassLoader().getResourceAsStream("dbsetup.sql")) {
            setup = new String(in.readAllBytes());
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Could not read dbsetup.sql.", e);
            throw e;
        }
    }
}


