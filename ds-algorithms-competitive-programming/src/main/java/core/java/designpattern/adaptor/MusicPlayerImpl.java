package core.java.designpattern.adaptor;

public class MusicPlayerImpl implements MusicPlayer {

    MusicPlayerAdaptor adaptor;

    @Override
    public void play(String type) {
        if (type.equalsIgnoreCase("mp3")) {
            playMp3();
        } else {
            adaptor = new MusicPlayerAdaptor();
            adaptor.play(type);
        }
    }

    public void playMp3() {
        System.out.println("Playing mp3");
    }
}
