package yosif;

public class Employee {
    String name;
    int age;
    double salary;

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            this.salary += (this.salary * (bonus/100d)) / 2d;
        }else {
            this.salary += (this.salary * (bonus/100d));
        }
    }

    public Employee (String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Employee (String firstName, String lastName, int age, double salary) {
        this.name = firstName + " " + lastName;
        this.age = age;
        this.salary = salary;
    }
}
