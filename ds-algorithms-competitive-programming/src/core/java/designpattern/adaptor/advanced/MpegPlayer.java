package core.java.designpattern.adaptor.advanced;

import core.java.designpattern.adaptor.advanced.AdvancedMusicPlayer;

public class MpegPlayer implements AdvancedMusicPlayer {
    @Override
    public void playAdvanced() {
        System.out.println("mpeg");
    }
}
