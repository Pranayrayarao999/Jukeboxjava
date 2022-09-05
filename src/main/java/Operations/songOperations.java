package Operations;

import hellomaven.entities.songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class songOperations
{
    List<songs> list=new ArrayList<>();
    public boolean addSongList(songs song) {
        list.add(song);
        return true;
    }

    public List<songs> searchByArtistID(List<songs> allsonglist, String artistName) {

        List<songs> sa = new ArrayList<>();

        Optional filter = allsonglist.stream().filter(p -> p.getArtistName().equalsIgnoreCase(artistName)).findAny();

        if (filter.isPresent()) {

            sa = allsonglist.stream().filter(p -> p.getArtistName().equalsIgnoreCase(artistName)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("no such artistname exist");
        }
        return sa;
    }
    public List<songs> searchByGenre(List<songs> allsonglist, String genre) {

        List<songs> sa = new ArrayList<>();

        Optional filter = allsonglist.stream().filter(p -> p.getSongGenre().equalsIgnoreCase(genre)).findAny();

        if (filter.isPresent()) {

            sa = allsonglist.stream().filter(p -> p.getSongGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("no such genre exist");
        }
        return sa;
    }

    public List<songs> searchByAlbum(List<songs> allsonglist, String album_name) {
        List<songs> sa = new ArrayList<>();
        Optional filter = allsonglist.stream().filter(p -> p.getAlbumName().equalsIgnoreCase(album_name)).findAny();
        if (filter.isPresent()) {
            sa = allsonglist.stream().filter(p -> p.getAlbumName().equalsIgnoreCase(album_name)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("no such album name exist");
        }
        return sa;
    }

    public List<songs> searchBySongName(List<songs> allsonglist, String song_name) {
        List<songs> sa = new ArrayList<>();
        Optional filter = allsonglist.stream().filter(p -> p.getSongName().equalsIgnoreCase(song_name)).findAny();
        if (filter.isPresent()) {
            sa = allsonglist.stream().filter(p -> p.getSongName().equalsIgnoreCase(song_name)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("no such song name exist");
        }
        return sa;
    }

    public void display(List<songs> allsongsList) {

        Consumer<songs> dis= d->System.out.println(d);

        allsongsList.stream().forEach(dis);
    }
}
