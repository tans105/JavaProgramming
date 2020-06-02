package core.java.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    List<Subscriber> subscriberList = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber sub : subscriberList) {
            sub.update();
        }
    }

    public void upload() {
        System.out.println("Video uploaded");
        notifySubscribers();
    }
}
