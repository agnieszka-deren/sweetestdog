package pl.agnieszkaderen.sweetestdog.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	
    private static DataSource dataSource;
    
    public static Connection getConnection() throws SQLException {
        return getDataSourceInstance().getConnection();
    }
     
    public static DataSource getDataSourceInstance() {
        if(dataSource == null) {
            try {
                Context initialContext = new InitialContext();
                Context envContext = (Context) initialContext.lookup("java:comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/sweetestdog");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }
	

}
