package hellomaven.entities;

public class audio
{
    String audioId;
    String audioType;
    String podcastId;
    String songId;

    public audio(String audioId, String audioType, String podcastId, String songId) {
        this.audioId = audioId;
        this.audioType = audioType;
        this.podcastId = podcastId;
        this.songId = songId;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "audio{" +
                "audioId='" + audioId + '\'' +
                ", audioType='" + audioType + '\'' +
                ", podcastId='" + podcastId + '\'' +
                ", songId='" + songId + '\'' +
                '}';
    }
}
