package core.java.designpattern.structural.adaptor.example.advanced;

public class MpegPlayer implements AdvancedMusicPlayer {
    @Override
    public void playAdvanced() {
        System.out.println("mpeg");
    }
}
