package DefiningClassesCompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee (String name, double salary, String position, String email, int age) {
this.name = name;
this. salary = salary;
this.position = position;
this.email = email;
this.age =age;

    }

    public double getSalary() {
        return salary;
    }
    public String toString() {
        //{name1} {salary1} {email1} {age1}
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
