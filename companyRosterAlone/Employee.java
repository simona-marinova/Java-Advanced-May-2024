package companyRosterAlone;

public class Employee {
    //: name, salary, position, department, email, and age.
    //The name, salary, position, and department are mandatory, while the rest are optional.

    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




//{name1} {salary1} {email1} {age1}
    @Override
    public String toString() {
        return String.format("%s %.2f %s %d\n",this.name,this.salary, this.email, this.age);
    }
}
