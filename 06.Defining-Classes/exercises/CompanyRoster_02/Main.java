package T6DefiningClasses.exercises.CompanyRoster_02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            departments.putIfAbsent(department, new Department());
            Employee employee = null;

            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            departments.get(department).getEmployeeList().add(employee);
        }

        Department maxAvgSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " +
                maxAvgSalaryDepartment.getEmployeeList().get(0).getDepartment());

        maxAvgSalaryDepartment.getEmployeeList()
                .stream()
                .sorted((e1,e2)->Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e-> System.out.println(e.toString()));
    }
}
