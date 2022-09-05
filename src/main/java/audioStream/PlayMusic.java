package audioStream;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayMusic
{
    AudioInputStream audioInputStream;
    Clip clip;
    static String status=" ";
    String filepath;
    long currentframe;
    String name;
    public PlayMusic(String filepath,String name)
    {
        this.filepath=filepath;
        this.name=name;
    }
    public String getStatus()
    {
        return status;
    }
    public void play() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
        System.out.println("playing");
        status = "play";
    }
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentframe =this.clip.getMicrosecondPosition();
        System.out.println("Paused");
        clip.stop();
        status = "paused";
    }
    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+ "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentframe);
        this.clip.start();
        System.out.println("Playing");
        status="play";
    }
    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentframe = 0L;
        clip.setMicrosecondPosition(0);
        this.clip.start();
        System.out.println("Playing");
        status="play";
    }
    public void stop()
    {
        currentframe = 0L;
        clip.stop();
        clip.close();
        status="stop";
    }
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
