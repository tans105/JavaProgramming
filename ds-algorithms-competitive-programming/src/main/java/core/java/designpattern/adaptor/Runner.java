package core.java.designpattern.adaptor;

public class Runner {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayerImpl();
        player.play("mp3");
        player.play("mp4");
        player.play("mpeg");
    }
}
