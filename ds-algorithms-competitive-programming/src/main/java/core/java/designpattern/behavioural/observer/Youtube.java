package core.java.designpattern.behavioural.observer;

public class Youtube {
    public static void main(String[] args) {
        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        Subscriber sub3 = new Subscriber();
        Subscriber sub4 = new Subscriber();
        Subscriber sub5 = new Subscriber();

        Channel c1 = new Channel();


        c1.subscribe(sub1);
        c1.subscribe(sub2);
        c1.subscribe(sub3);
        c1.subscribe(sub4);
        c1.subscribe(sub5);

        sub1.subscribeChannel(c1);
        sub2.subscribeChannel(c1);
        sub3.subscribeChannel(c1);
        sub4.subscribeChannel(c1);
        sub5.subscribeChannel(c1);

        c1.upload();
    }
}
