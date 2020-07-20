package miniApplications.oddeven;

public class Runner {
    public static void main(String[] args) {
        LogNumber number = new LogNumber();

        OddNumber odd = new OddNumber(number);
        EvenNumber even = new EvenNumber(number);

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t1.start();
        t2.start();
    }
}
