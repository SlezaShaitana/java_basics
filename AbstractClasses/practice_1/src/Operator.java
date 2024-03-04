import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Operator implements Employee{
    private final Company company;
    private double monthSalary;
    NumberFormat format = new DecimalFormat("0");
    public Operator(Company company) {
        company.countEmployees ++;
        this.company = company;
        Random random = new Random();
        monthSalary = random.nextInt(60_000 - 50_000) + 50_000;
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public String toString() {
        return "Оператор" + " - " + format.format(getMonthSalary()) + " руб.";
    }
}