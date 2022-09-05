package Dao;

import connectorjavasql.Connector;
import hellomaven.entities.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class audioDao
{
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

    public static List<audio> getAllAudio() throws SQLException
    {
        String query = "select * from audio";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<audio> audioList = new ArrayList();

        while (rs.next()) {
            audio audio = new audio(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
            audioList.add(audio);
        }
        return audioList;
    }
}
