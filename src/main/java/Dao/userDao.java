package Dao;

import connectorjavasql.Connector;
import hellomaven.entities.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userDao
{
    Scanner scan=new Scanner(System.in);
    List<users> list1=new ArrayList<>();
    static Connection con;

    static {
        try {
            con = Connector.establishConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser() throws SQLException {
        System.out.println("Enter Your Name");
        String name = scan.next();

        System.out.println("Enter Your password");
        String password = scan.next();

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?);");
        ps.setInt(1,userDao.generateUserid());
        ps.setString(2,name);
        ps.setString(3,password);

        int rowsaffected = ps.executeUpdate();
        if (rowsaffected != 0) {
            System.out.println("Your Account created sucesssfully");
        }
    }
    public static int generateUserid()
    {
        int min = 0;
        int max = 999999999;
        int accountNumberGenrate = (int) (Math.random()*(max-min)+min);
        return accountNumberGenrate;
    }

    public List<users> userRead() throws SQLException, ClassNotFoundException {

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from users");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list1.add(new users(res.getString(1),res.getString(2),res.getString(3)));
        }
        return list1;
    }
}
