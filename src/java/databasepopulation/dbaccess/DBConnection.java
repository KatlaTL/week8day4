package databasepopulation.dbaccess;
import static databasepopulation.dbaccess.ConnectionConstants.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
        Class.forName("com.mysql.jdbc.Driver");
        
        return DriverManager.getConnection(url, USER, USERPW);
    }
}
