package Dao;

import connectorjavasql.Connector;
import hellomaven.entities.songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class songsDao
{
    List<songs> list=new ArrayList<>();
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

    //crud operations
    public List<songs> songRead() throws SQLException, ClassNotFoundException {

        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select * from songs");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list.add(new songs(res.getString(1),res.getString(2),
                    res.getString(3),res.getString(4),res.getString(5),
                    res.getString(6),res.getString(7),res.getString(8)));
        }
        return list;
    }

}
