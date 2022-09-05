package connectorjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector
{
    static Connection con=null;
    static Statement s=null;

    public static Connection establishConnection() throws ClassNotFoundException, SQLException {
        //1. Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        //2.Establish a connecion
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBoxProject", "root", "Root");
        System.out.println("Connection established");

        return con;

    }


}
