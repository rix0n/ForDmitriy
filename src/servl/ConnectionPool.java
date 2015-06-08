package servl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by 1 on 31.05.2015.
 */
public class ConnectionPool {

    private ConnectionPool(){}

    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/exodb");
        } catch (NamingException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnect() throws SQLException{
        Connection conn = dataSource.getConnection();
        return conn;
    }

}
