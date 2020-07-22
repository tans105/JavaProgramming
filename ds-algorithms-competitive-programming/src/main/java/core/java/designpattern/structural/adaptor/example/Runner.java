package core.java.designpattern.structural.adaptor.example;

public class Runner {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayerImpl();
        player.play("mp3");
        player.play("mp4");
        player.play("mpeg");
    }
}
