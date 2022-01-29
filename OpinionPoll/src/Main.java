import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people = people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());
        people.sort(Comparator.comparing(p -> p.getName()));
        people.forEach(p -> System.out.println(p));
    }
}
