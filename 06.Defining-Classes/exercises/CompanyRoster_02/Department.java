package T6DefiningClasses.exercises.CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public double getAvgSalary() {
//        double sumSalary = 0;
//        for (Employee employee : employeeList) {
//            sumSalary += employee.getSalary();
//        }
//        return sumSalary / employeeList.size();
        return this.employeeList
                .stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0.0);
    }
}
