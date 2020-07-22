package applications.MultithreadedBank;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Account {
    private int balance;
    private Person customer;
    private final Object lock = new Object();
    private BlockingQueue<String> last5Txn;

    Account(Person person, int balance) {
        this.customer = person;
        this.balance = balance;
        this.last5Txn = new ArrayBlockingQueue<>(5);
    }

    public void getBalance() {
        synchronized (lock) {
            System.out.println(this.balance);
        }
    }

    public void deposit(int value) {
        System.out.println("Depositing: " + value);
        synchronized (lock) {
            if (last5Txn.size() == 5) {
                try {
                    last5Txn.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            last5Txn.add("Deposit:" + value);
            balance += value;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Current balance: " + balance);
    }

    public void withdraw(int value) {
        System.out.println("Withdrawing: " + value);
        if (balance - value < 0) {
            System.out.println("Insufficient balance");
        } else {
            synchronized (lock) {
                if (last5Txn.size() == 5) {
                    try {
                        last5Txn.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                last5Txn.add("Withdraw:" + value);
                balance -= value;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Current balance: " + balance);
    }

    public void getLast5Txn() {
        System.out.println("---------Last 5 transaction--------");
        for (String s : last5Txn) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------");
    }

}
