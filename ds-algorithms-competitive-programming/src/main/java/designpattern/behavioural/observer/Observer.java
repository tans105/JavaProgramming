package designpattern.behavioural.observer;

public interface Observer {
    void subscribeChannel(Channel ch);
    void update();
}
