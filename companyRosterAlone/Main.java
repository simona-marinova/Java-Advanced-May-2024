package companyRosterAlone;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] information = scanner.nextLine().split(" ");
            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String departmentName = information[3];
            String email = "n/a";
            int age = -1;
            if (information.length == 6) {
                email = information[4];
                age = Integer.parseInt(information[5]);
            } else if (information.length == 5) {
                char firstChar = information[4].charAt(0);
                if (Character.isDigit(firstChar)) {
                    age = Integer.parseInt(information[4]);
                } else if (information[4].contains("@")) {
                    email = information[4];
                }
            }
            Employee employee = new Employee(name, salary, position, email, age);
            Department department = getDepartmentByName(departmentName, departments);
            department.addEmployee(employee);
        }

//Peter 120.00 Dev Development peter@abv.bg 28
        Department departmentHighestSalary = getHighestAverageSalary(departments);
        Collections.sort(departmentHighestSalary.getEmployees(), Comparator.comparing(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s\n", departmentHighestSalary.getDepartmentName());
        System.out.print(departmentHighestSalary.getEmployees().toString().replace("[", "").replace("]","").replace(", ", ""));

    }

    public static Department getDepartmentByName(String name, List<Department> departments) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(name)) {
                return department;
            }
        }
        Department department = new Department(name);
        departments.add(department);
        return department;
    }

    public static Department getHighestAverageSalary(List<Department> departments) {
        Department departmentHighestSalary = new Department("");
        double averageSalary = 0;
        double highestAverageSalary = 0;
        for (Department department : departments) {
            int size = 0;
            double sum = 0;
            for (Employee employee : department.getEmployees()) {
                sum += employee.getSalary();
            }
            size = department.getEmployees().size();
            averageSalary = sum / size;
            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                departmentHighestSalary = department;
            }
        }

        return departmentHighestSalary;
    }
}
