package designpattern.structural.adaptor.example.advanced;

public class Mp4Player implements AdvancedMusicPlayer {

    @Override
    public void playAdvanced() {
        System.out.println("MP4");
    }
}
