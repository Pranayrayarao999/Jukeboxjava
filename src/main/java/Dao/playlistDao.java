package Dao;

import connectorjavasql.Connector;
import hellomaven.entities.playlist;
import hellomaven.entities.podcast;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class playlistDao
{
    List<podcast> list=new ArrayList<>();
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

    public List<String> getUrl(List<playlist> play) throws SQLException {
        List<String> url=new ArrayList<>();
        for(int i=0;i<play.size();i++){
            String type= String.valueOf(play.get(1));
            String audioId= String.valueOf(play.get(2));
            if(type.contains("song")){
                String query="select url from audio join songs where audio.songid=songs.songid" +
                        "and audio.audioId = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, audioId);
                ResultSet rs = ps.executeQuery();
                rs.next();
                url.add(rs.getString(1));
            }
            else if(type.contains("pod")){
                String query="select url from audio join podcast where audio.podcastid=podcast.podcastid" +
                        "and audio.audioId = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, audioId);
                ResultSet rs = ps.executeQuery();
                rs.next();
                url.add(rs.getString(1));
            }
        }
        return url;
    }

    public static List<playlist> getAllPlaylist(String userId) throws SQLException
    {
        String query = "select * from playlist where userId =?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        List<playlist> play = new ArrayList();

        while (rs.next()) {
            playlist playlist = new playlist(rs.getString(1), rs.getString(2),rs.getString(3));
            play.add(playlist);
        }
        return play;
    }

    public static void playPlayList(String userId,String playlistID) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        String query="select SongID,Songname,url from songs where songId in" +
                "(select songId from audio where audioId in" +
                "(select audioId from playlistrecords where playlistid=?))";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, playlistID);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String url = rs.getString(3);
            Scanner scanner = new Scanner(System.in);
            File file = null;
            file = new File(url);

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            System.out.println("Now playing\n" + rs.getString(2));
            System.out.println();
            int response=0;
            clip.start();
            while (!(response ==6)) {
                System.out.println("1 = play, 2 = Stop, 3 = Reset, 4 = Next Song, 5=Loop, 6=Quit");
                System.out.print("Enter your choice: ");
                response = scanner.nextInt();
                //response = response.toUpperCase();
                int i = 5;
                switch (response) {
                    case 1:
                        clip.start();

                        break;
                    case 2:
                        clip.stop();
                        break;
                    case 3:
                        clip.setMicrosecondPosition(0);
                        break;
                    case 4:
                        clip.close();
                        break;

                    case 5:
                        clip.loop(2);
                        break;

                    default:
                        System.out.println("Not a valid response");
                }
            }
        }
    }

    public int addsong(String audioId,String playlistName,String playId) throws SQLException
    {
        String query
                = "insert into playlistrecords(audioId,audiotype,playlistid) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, audioId);
        ps.setString(2,playlistName );
        ps.setString(3,playId );
        int n = ps.executeUpdate();
        return n;
    }

    public int delete(String audioId) throws SQLException
    {
        String query = "delete from playlist where audioId =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, audioId);
        int n = ps.executeUpdate();
        return n;
    }

    public List<playlist> readPlayList() throws SQLException, ClassNotFoundException {
        List<playlist> list2=new ArrayList<>();
        Statement s=con.createStatement();
        PreparedStatement ps=con.prepareStatement("select *from playlist;");
        ResultSet res=ps.executeQuery();
        while(res.next()){
            list2.add(new playlist(res.getString(1),res.getString(2),res.getString(3)));
        }
        return list2;
    }

}
