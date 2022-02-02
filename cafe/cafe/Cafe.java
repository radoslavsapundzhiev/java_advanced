package cafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if(capacity > 0) {
            this.employees.add(employee);
            capacity--;
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        this.employees.sort((e1, e2) -> e2.getAge() - e1.getAge());
        return this.employees.get(0);
    }

    public Employee getEmployee(String name) {
        Employee searchedEmployee = null;
        for (Employee employee: employees) {
            if(employee.getName().equals(name)){
                searchedEmployee = employee;
                break;
            }
        }
        return searchedEmployee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(String.format("Employees working at Cafe %s:", name))
                .append(System.lineSeparator());
        for (Employee employee: employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
