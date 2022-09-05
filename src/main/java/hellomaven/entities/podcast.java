package hellomaven.entities;

public class podcast
{
    String podcastId;
    String artistName;
    String podcastName;
    String podcastGenre;
    String releaseDate;
    String podcast_Duration;
    String url;

    public podcast(String podcastId, String artistName, String podcastName, String podcastGenre, String releaseDate, String podcast_Duration, String url) {
        this.podcastId = podcastId;
        this.artistName = artistName;
        this.podcastName = podcastName;
        this.podcastGenre = podcastGenre;
        this.releaseDate = releaseDate;
        this.podcast_Duration = podcast_Duration;
        this.url = url;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getPodcastGenre() {
        return podcastGenre;
    }

    public void setPodcastGenre(String podcastGenre) {
        this.podcastGenre = podcastGenre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPodcast_Duration() {
        return podcast_Duration;
    }

    public void setPodcast_Duration(String podcast_Duration) {
        this.podcast_Duration = podcast_Duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "podcast{" +
                "podcastId='" + podcastId + '\'' +
                ", artistName='" + artistName + '\'' +
                ", podcastName='" + podcastName + '\'' +
                ", podcastGenre='" + podcastGenre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", podcast_Duration='" + podcast_Duration + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
