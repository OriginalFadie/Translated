package net.ureshi.translated.Storage;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class MySqlStorage {

    MysqlDataSource dataSource = new MysqlConnectionPoolDataSource();

}