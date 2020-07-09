package core.java.designpattern.adaptor.advanced;

import core.java.designpattern.adaptor.advanced.AdvancedMusicPlayer;

public class Mp4Player implements AdvancedMusicPlayer {

    @Override
    public void playAdvanced() {
        System.out.println("MP4");
    }
}
