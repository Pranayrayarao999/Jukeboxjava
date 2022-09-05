package hellomaven.entities;

public class songs
{
    String songId;
    String artistName;
    String songName;
    String songGenre;
    String albumName;
    String releaseDate;
    String song_Duration;
    String url;

    public songs(String songId, String artistName, String songName, String songGenre, String albumName, String releaseDate, String song_Duration, String url) {
        this.songId = songId;
        this.artistName = artistName;
        this.songName = songName;
        this.songGenre = songGenre;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.song_Duration = song_Duration;
        this.url = url;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSong_Duration() {
        return song_Duration;
    }

    public void setSong_Duration(String song_Duration) {
        this.song_Duration = song_Duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "songs{" +
                "songId='" + songId + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songName='" + songName + '\'' +
                ", songGenre='" + songGenre + '\'' +
                ", albumName='" + albumName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", song_Duration='" + song_Duration + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
