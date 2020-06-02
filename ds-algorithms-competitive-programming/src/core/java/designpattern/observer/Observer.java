package core.java.designpattern.observer;

public interface Observer {
    void subscribeChannel(Channel ch);
    void update();
}
