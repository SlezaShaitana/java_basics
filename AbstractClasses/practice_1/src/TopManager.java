import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class TopManager implements Employee {
    private final Company company;
    private static final double TOP_MANAGERS_AWARD = 1.5;
    private double fixSalary;
    private double monthSalary;
    NumberFormat format = new DecimalFormat("0");

    public TopManager(Company company) {
        this.company = company;
        Random random = new Random();
        fixSalary = random.nextInt(120_000 - 90_000) + 90_000;
        if (company.getCompanyIncome() >= 10_000_000) {
            monthSalary = Math.round(fixSalary + (fixSalary * TOP_MANAGERS_AWARD));
        } else {
            monthSalary = fixSalary;
        }
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public String toString() {
        return "Топ менеджер " + " - " + format.format(getMonthSalary()) + " руб.";
    }
}
