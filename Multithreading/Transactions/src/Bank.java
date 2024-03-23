import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new Hashtable<>();
    private final Random random = new Random();
    private static final long LIMIT = 50_000;
    

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (amount <= fromAccount.getMoney()) {
            if (!(fromAccount.getBlockStatus() || toAccount.getBlockStatus())) {
                if (amount < LIMIT) {
                    synchronized (fromAccount) {
                        fromAccount.setMoney(fromAccount.getMoney() - amount);
                    }
                    synchronized (toAccount) {
                        toAccount.setMoney(toAccount.getMoney() + amount);
                    }
                } else {
                    try {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            synchronized (fromAccount) {
                                fromAccount.blockedAccount();
                            }
                            synchronized (toAccount) {
                                toAccount.blockedAccount();
                            }

                        } else {
                            synchronized (fromAccount) {
                                fromAccount.setMoney(fromAccount.getMoney() - amount);
                            }
                            synchronized (toAccount) {
                                toAccount.setMoney(toAccount.getMoney() + amount);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sumAllAccounts = 0;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            sumAllAccounts += entry.getValue().getMoney();
        }
        return sumAllAccounts;
    }
}
