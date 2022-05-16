package applications.MultithreadedBank;

public class Runner {
    public static void main(String[] args) {
        Account a1 = new Account(new Person("Tanmay", 1), 1000);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    a1.getLast5Txn();
                    a1.deposit(100);
                    a1.withdraw(200);
                    a1.getLast5Txn();
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    a1.getLast5Txn();
                    a1.deposit(400);
                    a1.withdraw(300);
                    a1.getLast5Txn();
                }
            }
        });

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
