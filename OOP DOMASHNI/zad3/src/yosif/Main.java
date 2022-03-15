package yosif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amountOfEmployees = Integer.parseInt(sc.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < amountOfEmployees; i++) {
            List<String> input = Arrays.stream((sc.nextLine()).split(" ")).toList();
            System.out.println(input);
            employees.add(i,new Employee(input.get(0),input.get(1),Integer.parseInt(input.get(2)),Double.parseDouble(input.get(3))));
        }

        System.out.println("Enter salary bonus percentage");
        double bonus = sc.nextDouble();

        for (Employee employee : employees) {
            employee.increaseSalary(bonus);
            System.out.println(employee.name + " gets " + employee.salary);
        }
    }
}
