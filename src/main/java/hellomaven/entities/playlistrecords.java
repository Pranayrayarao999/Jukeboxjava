package hellomaven.entities;

public class playlistrecords
{
    String playlistId;
    String audioType;
    String audioId;

    public playlistrecords(String playlistId, String audioType, String audioId) {
        this.playlistId = playlistId;
        this.audioType = audioType;
        this.audioId = audioId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    @Override
    public String toString() {
        return "playlistrecords{" +
                "playlistId='" + playlistId + '\'' +
                ", audioType='" + audioType + '\'' +
                ", audioId='" + audioId + '\'' +
                '}';
    }
}
