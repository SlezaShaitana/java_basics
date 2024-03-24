public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(10010, "A1");
        Account account2 = new Account(700000, "A2");

        Account account3 = new Account(100000, "A3");
        Account account4 = new Account(300000, "A4");

        Bank bank = new Bank();
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        Thread thread1 = new Thread(
                () -> {
                    bank.transfer("A1", "A2", 70000);
                    bank.transfer("A2", "A1", 10000);
                    bank.transfer("A2", "A3", 90000);
                });

        Thread thread2 = new Thread(
                () -> {
                    bank.transfer("A3", "A4", 40000);
                    bank.transfer("A3", "A4", 30000);
                    bank.transfer("A1", "A2", 90000);
                });

        Thread thread3 = new Thread(() -> {
            bank.transfer("A1", "A3", 40000);
            bank.transfer("A2", "A4", 30000);
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("После операций:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
        System.out.println(account4);
    }
}
