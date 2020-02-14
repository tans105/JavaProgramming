package core.java.designpattern.adaptor;

import core.java.designpattern.adaptor.advanced.AdvancedMusicPlayer;
import core.java.designpattern.adaptor.advanced.Mp4Player;
import core.java.designpattern.adaptor.advanced.MpegPlayer;

public class MusicPlayerAdaptor {
    AdvancedMusicPlayer player;

    public void getPlayer(String type) {
        switch (type) {
            case "mp4": {
                player = new Mp4Player();
                break;
            }
            case "mpeg": {
                player = new MpegPlayer();
                break;
            }
        }
    }

    public void play(String type) {
        getPlayer(type);
        player.playAdvanced();
    }
}
