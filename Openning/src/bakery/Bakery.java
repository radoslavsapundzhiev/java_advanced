package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if(this.capacity > 0) {
            this.employees.add(employee);
            this.capacity--;
        }
    }

    public boolean remove(String name) {
        boolean result = this.employees.removeIf(e -> e.getName().equals(name));
        if(result) {
            this.capacity++;
        }
        return result;
    }

    public Employee getOldestEmployee() {
        //return this.employees.stream().max(Comparator.comparing(Employee::getAge)).get();
        this.employees.sort((e1, e2) -> e2.getAge() - e1.getAge());
        return this.employees.get(0);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:%n", name));
        for (Employee employee: this.employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
