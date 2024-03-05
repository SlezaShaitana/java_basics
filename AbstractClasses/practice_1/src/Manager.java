import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Manager implements Employee {
    private final Company company;
    private static final double MANAGERS_AWARD = 0.05;
    private double monthSalary;
    private double fixManagerSalary;
    private int managersRevenue;
    NumberFormat format = new DecimalFormat("0");

    public Manager(Company company) {
        this.company = company;
        Random random = new Random();
        fixManagerSalary = random.nextInt(90_000 - 60_000) + 60_000;
        managersRevenue = (int) Math.round(Math.random() * (140000 - 115000)) + 115000;
        company.increaseIncome(managersRevenue);
        monthSalary = Math.round(fixManagerSalary + (managersRevenue * MANAGERS_AWARD));
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public String toString() {
        return "Менеджер" + " - " + format.format(getMonthSalary()) + " руб. "
                + "Заработано денег для компании: " + format.format(managersRevenue);
    }
}
