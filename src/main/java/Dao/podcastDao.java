package Dao;

import connectorjavasql.Connector;
import hellomaven.entities.podcast;
import hellomaven.entities.songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class podcastDao
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

    public static List<podcast> getAllPodCasts() throws SQLException
    {
        String query = "select * from podcast";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<podcast> podcastsList = new ArrayList();

        while (rs.next()) {
            podcast podcast = new podcast(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));

            podcastsList.add(podcast);
        }
        return podcastsList;
    }

}
