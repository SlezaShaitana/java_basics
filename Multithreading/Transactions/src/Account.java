public class Account {

    private volatile long money;
    private String accNumber;
    private volatile boolean isBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        isBlocked = false;
    }

    public void blockAccount() {
        isBlocked = true;
    }

    public Boolean getBlockStatus() {
        return isBlocked;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", isBlocked=" + (isBlocked? "Yes" : "No") +
                '}';
    }
}
