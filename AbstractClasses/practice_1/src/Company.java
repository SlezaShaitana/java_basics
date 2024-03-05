import java.util.*;

public class Company {
    private List<Employee> employeeList;

    Company company;
    private String companyName;
    private int companyIncome;

    public Company(String companyName) {
        System.out.println("\n" + "Список сотрудников компании " + companyName);
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }
    public void hireAll(Collection<Employee> employees) {
        employeeList.addAll(employees);
    }
    public void fire(Employee employee) {
        employeeList.remove(employee);
    }
    public int getCompanyIncome() {
        return companyIncome;
    }

    public void increaseIncome(int managersRevenue) {
        this.companyIncome += managersRevenue;
    }

    public String getName() {
        return companyName;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        System.out.println("\n" + "Сотрудники с самыми высокими зарплатами");
        ArrayList<Employee> topSalaryStaffList = new ArrayList<>();
        employeeList.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());

        for (int i = 0; i < count; i ++) {
            topSalaryStaffList.add(employeeList.get(i));
        }
        return topSalaryStaffList;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        System.out.println("\n" + "Сотрудники с самыми низкими зарплатами");
        ArrayList <Employee> lowestSalaryList = new ArrayList<>();
        employeeList.sort(Comparator.comparingDouble(Employee::getMonthSalary));

        for (int i = 0; i < count; i ++) {
            lowestSalaryList.add(employeeList.get(i));
        }
        return lowestSalaryList;
    }

    public List<Employee> getListOfAllEmployees() {
        return employeeList;
    }
}
