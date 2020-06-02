package core.java.designpattern.observer;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);

    void notifySubscribers();

    void upload();
}
