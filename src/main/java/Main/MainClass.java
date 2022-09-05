package Main;

import Dao.playlistDao;
import Dao.podcastDao;
import Dao.songsDao;
import Dao.userDao;
import Operations.playlistOperations;
import Operations.podcastOperations;
import Operations.songOperations;
import Operations.userOperations;
import connectorjavasql.Connector;
import hellomaven.entities.playlist;
import hellomaven.entities.podcast;
import hellomaven.entities.songs;
import hellomaven.entities.users;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainClass
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        userOperations uo = new userOperations();
        userDao ud = new userDao();
        Scanner scan = new Scanner(System.in);
        System.out.println("******Welcome to MyMusic********");
        System.out.println("1.SignUp 2.Login");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                ud.insertUser();
                break;
            case 2:
                System.out.println("Enter your userId");
                String userId = scan.next();
                System.out.println("Enter your password");
                String password = scan.next();
                List<users> allUsersList = ud.userRead();
                if (uo.validate(allUsersList, userId, password) == true) {
                    int a = 0;
                    do {
                        System.out.println("Please select one option you want to perform 1.Songs 2.Podcast 3.Playlist");
                        int option1 = scan.nextInt();
                        switch (option1) {
                            case 1:
                                songOperations so = new songOperations();
                                songsDao sd = new songsDao();
                                List<songs> allSongsList = sd.songRead();
                                so.display(allSongsList);
                                System.out.println("Choose a Operation to perform");
                                System.out.println("1.View all songs   2.SearchByArtistName  3.SearchByAlbumName  4.SearchBySongName");
                                int option2 = scan.nextInt();
                                switch (option2) {
                                    case 1:
                                        so.display(allSongsList);
                                        break;
                                    case 2:
                                        System.out.println("Enter artist name");
                                        String artistName = scan.next();
                                        List<songs> searchByArtistName = so.searchByArtistID(allSongsList, artistName);
                                        so.display(searchByArtistName);
                                        break;
                                    case 3:
                                        System.out.println("Enter album name");
                                        String albumname = scan.next();
                                        List<songs> searchByAlbumName = so.searchByAlbum(allSongsList, albumname);
                                        so.display(searchByAlbumName);
                                        break;
                                    case 4:
                                        System.out.println("Enter song name");
                                        String name = scan.next();
                                        List<songs> searchBySongName = so.searchBySongName(allSongsList, name);
                                        so.display(searchBySongName);
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                }
                                break;


                            case 2:
                                podcastDao pd = new podcastDao();
                                podcastOperations po = new podcastOperations();
                                List<podcast> allPodcastList = pd.getAllPodCasts();
                                po.display(allPodcastList);
                                System.out.println("1.view all podcasts  2.search podcast by release date  3.search podcastby genre");
                                int option3 = scan.nextInt();
                                switch (option3) {
                                    case 1:
                                        po.display(allPodcastList);
                                        break;
                                    case 2:
                                        System.out.println("Enter release date(Please enter in YYYY-MM-DD format)");
                                        String releaseDate = scan.next();
                                        List<podcast> searchByReleaseDate = po.searchbyCreatDate(allPodcastList, releaseDate);
                                        po.display(searchByReleaseDate);
                                        break;
                                    case 3:
                                        System.out.println("Enter genre name");
                                        String genre = scan.next();
                                        List<podcast> searchByGenreName = po.searchbygenre(allPodcastList, genre);
                                        po.display(searchByGenreName);
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                        break;
                                }
                                break;

                            case 3:
                                System.out.println("EnterUserId");
                                String uId = scan.next();
                                List<playlist> play = playlistDao.getAllPlaylist(userId);
                                playlistOperations plo = new playlistOperations();
                                plo.display(play);
                                System.out.println("Enter a playlis id");
                                String playId = scan.next();
                                playlistDao.playPlayList(uId, playId);
                                break;

                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                        System.out.println("Do you want to continue 1.Yes 2.No");
                        a = scan.nextInt();
                    } while (a == 1);

                } else {
                    System.out.println("You are an invalid user please enter your user id or password");
                }

        }

    }
}
