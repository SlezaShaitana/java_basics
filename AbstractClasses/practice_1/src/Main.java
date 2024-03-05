public class Main {

    public static void main(String[] args) {
        Company orion = new Company("Орион");

        for (int i = 0; i < 270; i++) {
            for (i = 0; i < 180; i++) {
                orion.hire(new Operator(orion));
            }
            for (i = 180; i < 260; i++) {
                orion.hire(new Manager(orion));
            }
            for (i = 260; i < 270; i++) {
                orion.hire(new TopManager(orion));
            }
        }
        System.out.println("Всего сотрудников: " + orion.getListOfAllEmployees().size());

        for (Employee lowestSalaryStaffList : orion.getLowestSalaryStaff(30)) {
            System.out.println(lowestSalaryStaffList);
        }

        for (Employee TopSalaryStaffList : orion.getTopSalaryStaff(15)) {
            System.out.println(TopSalaryStaffList);
        }

        System.out.println("Увольняем половину сотрудников.");

        int employeeListSize = orion.getListOfAllEmployees().size();

        for (int i = 0; i < employeeListSize / 2; i++) {
            orion.fire(orion.getListOfAllEmployees().get(0));
        }

        for (Employee lowestSalaryStaffList : orion.getLowestSalaryStaff(30)) {
            System.out.println(lowestSalaryStaffList);
        }

        for (Employee TopSalaryStaffList : orion.getTopSalaryStaff(15)) {
            System.out.println(TopSalaryStaffList);
        }

        System.out.println("Всего сотрудников: " + orion.getListOfAllEmployees().size());
        System.out.println(orion.getCompanyIncome());
    }
}
