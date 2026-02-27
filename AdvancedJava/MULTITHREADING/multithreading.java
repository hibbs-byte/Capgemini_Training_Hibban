package thread_1;

public class Bank {
    private int balance = 1000;

    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entered withdraw()");
        System.out.println(Thread.currentThread().getName() + " acquired lock");
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " is going to wait");
            wait();
            System.out.println(Thread.currentThread().getName() + " got notified and reacquired lock");
        }
        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " completed withdrawal");
        System.out.println("Remaining balance: " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " entered deposit()");
        System.out.println(Thread.currentThread().getName() + " acquired lock on bank account");
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposited amount");
        System.out.println("Updated balance: " + balance);
        notify();
        System.out.println(Thread.currentThread().getName() + " sent NOTIFY signal");
        System.out.println(Thread.currentThread().getName() + " releasing lock");
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Thread(() -> {
            try {
                bank.withdraw(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-Withdraw");

        Thread t2 = new Thread(() -> {
            bank.deposit(1000);
        }, "Thread-Deposit");

        t1.start();
        t2.start();
    }
}
