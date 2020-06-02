package core.java.designpattern.observer;

public class Subscriber implements Observer{
    private String name;
    private Channel channel;

    public void subscribeChannel(Channel ch) {
        this.channel = ch;
    }

    public void update() {
        System.out.println("Video uploaded !");
    }


}
