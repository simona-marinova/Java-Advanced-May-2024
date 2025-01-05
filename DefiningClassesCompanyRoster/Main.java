package DefiningClassesCompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String [] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String departmentName = information[3];
            String email = "n/a";
            int age = -1;
            if(information.length==5) {
                String emailOrAge = information[4];
                char firstSymbol =emailOrAge.charAt(0);
                if(Character.isDigit(firstSymbol)){
                  age =Integer.parseInt(emailOrAge);
                }
                else if(emailOrAge.contains("@")){
               email = emailOrAge;
                }
            }
            else if(information.length==6) {
                email = information[4];
                age = Integer.parseInt(information[5]);
            }
            Employee employee = new Employee (name, salary, position, email ,age);
           Department department = getDepartmentByName (departments, departmentName);
            department.addEmployee(employee);
        }

        Collections.sort(departments, Comparator.comparing(Department::getDepartmentSalary).reversed());
Department highestPaidDepartment = departments.get(0);
        Collections.sort(highestPaidDepartment.getEmployees(), Comparator.comparing(Employee::getSalary).reversed());
        System.out.println(highestPaidDepartment);
    }



    private static Department getDepartmentByName(List<Department> departments, String departmentName) {
        for (Department department : departments) {
            if(department.getName().equals(departmentName)){
                return department;
            }
        }
        Department department = new Department (departmentName);
        departments.add(department);
        return department;
    }
}
