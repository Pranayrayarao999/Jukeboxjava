package hellomaven.entities;

public class playlist
{
    String playlistId;
    String userID;
    String audioId;

    public playlist(String playlistId, String userID, String audioId) {
        this.playlistId = playlistId;
        this.userID = userID;
        this.audioId = audioId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    @Override
    public String toString() {
        return "playlist{" +
                "playlistId='" + playlistId + '\'' +
                ", userID='" + userID + '\'' +
                ", audioId='" + audioId + '\'' +
                '}';
    }
}
