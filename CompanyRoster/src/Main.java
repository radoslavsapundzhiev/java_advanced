import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            if(employeeInfo.length == 6) {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (employeeInfo.length == 5) {
                if(employeeInfo[4].contains("@")) {
                    String email = employeeInfo[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(employeeInfo[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (employeeInfo.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            if(!departments.containsKey(department)) {
                List<Employee> employees = new ArrayList<>();
                departments.put(department, employees);
            }
            departments.get(department).add(employee);
        }
        String department = departments
                .entrySet().stream()
                .max(Comparator.comparing(e -> getAverageSalaryDepartment(e.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", department);
        List<Employee> employees = departments.get(department);
        employees.sort(Comparator.comparing(e -> e.getSalary()));
        Collections.reverse(employees);
        employees.forEach(System.out::println);
    }

    public static double getAverageSalaryDepartment(List<Employee> employees) {
        double totalSalary = 0;
        for (Employee employee: employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }
}
