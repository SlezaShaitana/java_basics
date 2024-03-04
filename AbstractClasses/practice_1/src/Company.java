import java.util.*;

public class Company {
    private List<Employee> employeeList;

    Company company;
    String companyName;
    public int companyIncome;
    public int countEmployees;

    public Company(String companyName) {
        System.out.println("\n" + "Список сотрудников компании " + companyName);
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    public void hire(Employee employee){
        employeeList.add(employee);
    }
    public void hireAll(Collection<Employee> employees){
        employeeList.addAll(employees);
    }
    public void fire(Employee employee){
        countEmployees --;
        employeeList.remove(employee);
    }
    public int getIncome(){
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        System.out.println("\n" + "Сотрудники с самыми высокими зарплатами");
        ArrayList<Employee> topSalaryStaffList = new ArrayList<>();
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });

        for (int i = 0; i < count; i ++) {
            topSalaryStaffList.add(employeeList.get(i));
        }
        return topSalaryStaffList;

    }
    public List<Employee> getLowestSalaryStaff(int count) {
        System.out.println("\n" + "Сотрудники с самыми низкими зарплатами");
        ArrayList <Employee> lowestSalaryList = new ArrayList<>();
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });

        for (int i = 0; i < count; i ++){
            lowestSalaryList.add(employeeList.get(i));
        }
        return lowestSalaryList;
    }

    public String getName() {
        return companyName;
    }

    public List<Employee> getListOfAllEmployees() {
        return employeeList;
    }

    public int getCountEmployees() {
        return countEmployees;
    }
}
